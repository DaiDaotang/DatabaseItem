package com.dao;

import com.DBUtil.DBUtil;
import com.bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class GetAthleteDao {
    private GetAthleteListBean bean;
    public GetAthleteDao(GetAthleteListBean b)
    {
        bean=b;
    }

    public List<AthleteList> returnAthleteList()
    {
        List<AthleteList> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement state1,state2;
        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            String itemName=bean.getItemName();
            String sex=bean.getSex();
            String age=bean.getAge();

            state1=conn.prepareStatement("select item_id from m_item where item_name = ? and age= ? and sex= ?");
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
            state2=conn.prepareStatement("select athname ,ath_id , team_name from athletes natural join team where ath_id in (select ath_id from enrollment where item_id = ?) and not exists (select * from competition natural join participation where item_id = ? and athletes.ath_id = ath_id);");
            state2.setString(1,item_id);
            state2.setString(2,item_id);
            ResultSet set2 = state2.executeQuery();
            AthleteList s;
            while(set2.next())
            {
                s = new AthleteList();
                s.setAth_id(set2.getString("ath_id"));
                s.setAth_name(set2.getString("athname"));
                s.setTeam_name(set2.getString("team_name"));
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
}
