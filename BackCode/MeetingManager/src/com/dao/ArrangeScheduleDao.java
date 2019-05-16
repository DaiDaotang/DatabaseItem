package com.dao;

import com.DBUtil.DBUtil;
import com.bean.ArrangeScheduleBean;
import com.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArrangeScheduleDao {
    private ArrangeScheduleBean bean;
    public ArrangeScheduleDao(ArrangeScheduleBean b){
        bean = b;
    }
    public int setCom_id()
    {
        Connection conn = DBUtil.getConnection();
        PreparedStatement state;
        try{
            conn.setAutoCommit(false);
            String sql="SELECT COUNT(*) FROM competition";
            state = conn.prepareStatement(sql);
            ResultSet set = state.executeQuery();
            if(set.next()){
                int i = set.getInt(1);
                return i;
            }
            else
            {
                return 0;
            }
        }catch (SQLException e){
            e.printStackTrace();
            DBUtil.rollback(conn);
            return 0;
        }finally {
            DBUtil.closeConn(conn);
        }
    }
    public void arrangeschedule()
    {
        Connection conn=null;
        PreparedStatement state1,state2,state3;
        String item_name=bean.getItemName();
        String sex=bean.getSex();
        String age=bean.getAgeDelivery();
        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            state1=conn.prepareStatement("select item_id from m_item where item_name = ? and age= ? and sex= ?");
            state1.setString(1,item_name);
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
                return;
            }
            int a=setCom_id();
            for (Group_list group:
                 bean.getGroup_lists()){
                state2=conn.prepareStatement("INSERT INTO competition VALUES (?,?,?,'N',?)");
                String s = item_id + a;
                a++;
                state2.setString(1,s);
                state2.setString(2,item_id);
                state2.setString(3,group.getRef_group());
                state2.setString(4,group.getTime());
                int x = state2.executeUpdate();
                if(x<1){
                    System.err.println(s);
                }
                for (Ath_list ath:
                     group.getAth_lists()) {
                    state3=conn.prepareStatement("INSERT INTO participation (ATH_ID,COM_ID,STATUS, ATH_NAME) VALUES (?,?,-1,?)");
                    state3.setString(1,ath.getAth_id());
                    state3.setString(2,s);
                    state3.setString(3,ath.getAth_name());
                    int y = state3.executeUpdate();
                    if(y<1){
                        System.err.println(ath.getAth_id());
                    }
                }
            }
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
            DBUtil.rollback(conn);
        }finally {
            DBUtil.closeConn(conn);
        }
    }
}
