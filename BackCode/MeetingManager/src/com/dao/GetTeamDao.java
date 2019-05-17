package com.dao;

import com.DBUtil.DBUtil;
import com.bean.TeamBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetTeamDao {

    public List<TeamBean> returnTeamList()
    {
        List<TeamBean> list = new ArrayList<>();
        Connection conn = null;
        TeamBean bean;
        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement state1 = conn.prepareStatement("select team_id, team_name from team");
            ResultSet set = state1.executeQuery();
            while ((set.next()))
            {
                bean = new TeamBean();
                bean.setTeam_id(set.getString(1));
                bean.setTeam_name(set.getString(2));
                list.add(bean);
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
