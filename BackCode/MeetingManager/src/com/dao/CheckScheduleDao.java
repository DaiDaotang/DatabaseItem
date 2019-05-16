package com.dao;

import com.DBUtil.DBUtil;
import com.bean.*;
import com.bean.CheckScheduleBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckScheduleDao {
    private CheckScheduleBean bean;
    private ReqPageInfo page;
    public CheckScheduleDao(CheckScheduleBean b, ReqPageInfo p)
    {
        bean=b;
        page=p;
    }

    public List<ScheduleBean> returnScheduleByitemName()
    {
        List<ScheduleBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement state1,state2;
        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            String itemName=bean.getItemName();
            String sex=bean.getSex();
            String age=bean.getAge();
            if(itemName == "" || sex == "" || age == ""){
                return null;
            }
            state1=conn.prepareStatement("select item_id from m_item where item_name = ? and age = ? and sex = ?");
            state1.setString(1,itemName);
            state1.setString(2,age);
            state1.setString(3,sex);
            ResultSet set = state1.executeQuery();
            String item_id;
            if(set.next())
            {
                item_id = set.getString("item_id");
            }
            else
            {
                return null;
            }
            state2 = conn.prepareStatement("select com_id, ref_group_id, time,count(*) from competition natural join participation group by (com_id,ref_group_id,time,item_id) having item_id = ? ");
            state2.setString(1,item_id);
            ResultSet set2 = state2.executeQuery();
            ScheduleBean s;
            int index = 0,size = 0;
            int curPage = page.getCurPage();
            int pageSize = page.getPageSize();
            while(set2.next()&&size<pageSize)
            {
                index++;
                if(index<pageSize*(curPage-1))
                {
                    continue;
                }
                size++;
                s = new ScheduleBean();
                s.setCom_id(set2.getString("com_id"));
                s.setRef_group_id(set2.getString("ref_group_id"));
                s.setTime(set2.getString("time"));
                s.setAmount(set2.getString(4));

                list.add(s);
            }
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
            DBUtil.rollback(conn);
        }finally {
            DBUtil.closeConn(conn);
            return list;
        }
    }
    public List<ScheduleBean> returnSchedule()
    {
        List<ScheduleBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement state1,state2;
        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sex=bean.getSex();
            String age=bean.getAge();
            if(sex == "" || age == ""){
                return null;
            }
            state1=conn.prepareStatement("select item_id from m_item where age= ? and sex= ?");
            state1.setString(1,age);
            state1.setString(2,sex);
            ResultSet set = state1.executeQuery();
            String item_id;
            int index = 0,size = 0;
            int curPage = page.getCurPage();
            int pageSize = page.getPageSize();
            while(set.next())
            {
                item_id = set.getString("item_id");
                state2 = conn.prepareStatement("select com_id, ref_group_id, time,count(*) from competition natural join participation group by (com_id,ref_group_id,time,item_id) having item_id = ?");
                state2.setString(1,item_id);
                ResultSet set2 = state2.executeQuery();
                ScheduleBean s;
                while(set2.next()&&size<pageSize)
                {
                    index++;
                    if(index<pageSize*(curPage-1))
                    {
                        continue;
                    }
                    size++;
                    s = new ScheduleBean();
                    s.setCom_id(set2.getString("com_id"));
                    s.setRef_group_id(set2.getString("ref_group_id"));
                    s.setTime(set2.getString("time"));
                    s.setAmount(set2.getString(4));

                    list.add(s);
                }
            }

            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
            DBUtil.rollback(conn);
        }finally {
            DBUtil.closeConn(conn);
            return list;
        }
    }
}
