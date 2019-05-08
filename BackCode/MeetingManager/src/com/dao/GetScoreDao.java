package com.dao;
import com.bean.*;
import com.DBUtil.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class GetScoreDao {
    private ReqPageInfo page;
    private String reqId;

    public GetScoreDao(RequestBean bean){
        this.reqId = bean.getReqId();
        this.page = bean.getReqPageInfo();
    }

    public List<PersonScoreBean> getBasicInfo(String authority){
        List<PersonScoreBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet set = null;
        try{
            conn = DBUtil.getConnection();
            String sql = " ";
            switch(authority){
                case "裁判":
                    sql = "select ath_id, ath_name, com_id, com_name, item_name, sex, age, P, D from competition natural join participation natural join m_item where status = 0 and com_id in (select com_id from competition where ref_group_id in (select ref_group_id from referee where ref_id = ?))";
                    break;
                case "总裁判":
                    sql = "select ath_id, ath_name, com_id, com_name, item_name, sex, age, P, D from competition natural join participation natural join m_item where status = 1 and com_id in (select com_id from competition where ref_group_id in (select ref_group_id from refgroup where group_leader = ?))";
                    break;
                case "裁判长":
                    sql = "select ath_id, ath_name, com_id, com_name, item_name, sex, age, P, D from competiton natural join participation natural join m_item where status = 3 and chief_ref = ?";
                    break;
            }
            state = conn.prepareStatement(sql);
            state.setString(1,reqId);
            set = state.executeQuery();
            PersonScoreBean s;
            while(set.next()) {
                s = new PersonScoreBean();
                s.setAge(set.getString("age"));
                s.setAth_id(set.getString("ath_id"));
                s.setAth_name(set.getString("ath_name"));
                s.setCom_id(set.getString("com_id"));
                s.setCom_name(set.getString("com_name"));
                s.setSex(set.getString("sex"));
                s.setP(set.getDouble("P"));
                s.setD(set.getDouble("D"));
                s.setItem_name(set.getString("item_name"));
                if(authority=="裁判"||!isScored(s)){
                    list.add(s);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
            return list;
        }
    }

    public List<PersonScoreBean> getScoreLists(String authority){
        List<PersonScoreBean> list = getBasicInfo(authority);
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet set = null;
        for (PersonScoreBean s:
                list) {
            getScoreList(s);
        }
        return list;
    }

    private void getScoreList(PersonScoreBean s){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet set = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "select ref_name,score from scores natural join referee where ath_id = ? and com_id = ?";
            state = conn.prepareStatement(sql);
            state.setString(1,s.getAth_id());
            state.setString(2,s.getCom_id());
            set = state.executeQuery();
            double score;
            String ref;
            while (set.next()){
                ref = set.getString("ref_name");
                score = set.getDouble("score");
                s.addScore(score,ref);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
        }
    }

    private boolean isScored(PersonScoreBean s){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet set = null;
        try{
            conn = DBUtil.getConnection();
            String sql = "select score from scores where ath_id = ? and com_id = ? and ref_id = ?";
            state = conn.prepareStatement(sql);
            state.setString(1,s.getAth_id());
            state.setString(2,s.getCom_id());
            state.setString(3,reqId);
            set = state.executeQuery();
            if (set.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.closeConn(conn);
        }
    }
}
