package com.dao;
import com.bean.*;
import com.DBUtil.DBUtil;
import sun.security.pkcs11.Secmod;

import java.sql.*;
import java.util.*;
public class RefereeDao {
    private ReqPageInfo page;
    private String reqId;

    public RefereeDao(RequestBean bean){
        this.reqId = bean.getReqId();
        this.page = bean.getReqPageInfo();
    }

    public List<RefGroupBean> GetRefGroup(){
        Connection conn = null;
        PreparedStatement state;
        List<RefGroupBean> list = new ArrayList<>();
        RefGroupBean bean;
        try{
            conn = DBUtil.getConnection();
            state = conn.prepareStatement("select ref_group_id ,ref_name from refgroup, referee where group_leader = ref_id and ref_group = ref_group_id");
            ResultSet set = state.executeQuery();
            while(set.next()){
                bean = new RefGroupBean(set.getString(2),set.getString(1));
                list.add(bean);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            return list;
        }
    }

    public boolean GiveAMark(PersonScoreBean s){
        if(isScored(s)||s.getScore()<0){
            return false;
        }
        Connection conn = null;
        PreparedStatement state = null;
        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into scores values (?,?,?,?)";
            state = conn.prepareStatement(sql);
            state.setString(1,s.getAth_id());
            state.setString(2,s.getCom_id());
            state.setString(3,reqId);
            state.setDouble(4,s.getScore());
            int i = state.executeUpdate();
            if(i>0){
                conn.commit();
                statusChange(s.getCom_id());
                return true;
            }else{
                DBUtil.rollback(conn);
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            DBUtil.rollback(conn);
            return false;
        }finally {
            DBUtil.closeConn(conn);
        }
    }

    public boolean notPass(PersonScoreBean s,int status){
        Connection conn = null;
        PreparedStatement state1,state2;
        try{
            String sql1,sql2;
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            sql1 = "update participation set status = ? where ath_id = ? and com_id = ?";
            state1 = conn.prepareStatement(sql1);
            state1.setInt(1,status);
            state1.setString(3,s.getCom_id());
            switch (status){
                case 0:
                    state1.setString(2,s.getAth_id());
                    break;
                case 1:
                    state1.setString(2,"%");
                    break;
            }
            int i = state1.executeUpdate();
            if(status == 0){
                sql2 = "delete from scores where ath_id = ? and com_id = ?";
                state2 = conn.prepareStatement(sql2);
                state2.setString(1,s.getAth_id());
                state2.setString(2,s.getCom_id());
                int j = state2.executeUpdate();
                if(j<=0){
                    DBUtil.rollback(conn);
                    return false;
                }
            }
            if(i<=0){
                DBUtil.rollback(conn);
                return false;
            }else {
                conn.commit();
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            DBUtil.rollback(conn);
            return false;
        }finally {
            DBUtil.closeConn(conn);
        }
    }

    public boolean GiveDP(PersonScoreBean s){
        if(s.isPass()){
            double score = getResult(s.getCom_id(),s.getAth_id());
            Connection conn = DBUtil.getConnection();
            PreparedStatement state;
            try{
                conn.setAutoCommit(false);
                String sql = "update participation set status = 2,D = ?, P = ?,result = ? where ath_id = ? and com_id = ? ";
                state = conn.prepareStatement(sql);
                state.setDouble(1,s.getD());
                state.setDouble(2,s.getP());
                state.setDouble(3,s.getD()+s.getP()+score);
                state.setString(4,s.getAth_id());
                state.setString(5,s.getCom_id());
                int i = state.executeUpdate();
                if(i>0){
                    conn.commit();
                    return true;
                }else{
                    DBUtil.rollback(conn);
                    return false;
                }
            }catch (SQLException e){
                e.printStackTrace();
                DBUtil.rollback(conn);
                return false;
            }finally {
                DBUtil.closeConn(conn);
            }
        }else{
           return notPass(s,0);
        }
    }

    public boolean finalReview(PersonScoreBean s){
        if(s.isPass()){
            Connection conn = DBUtil.getConnection();
            PreparedStatement state,state2;
            try{
                conn.setAutoCommit(false);
                String sql = "update participation set status = 3 where com_id = ? ";
                state = conn.prepareStatement(sql);
                state.setString(1,s.getCom_id());
                int i = state.executeUpdate();
                if(i>0){
                    conn.commit();
                    getRank(s.getCom_id());
                    return true;
                }else{
                    DBUtil.rollback(conn);
                    return false;
                }
            }catch (SQLException e){
                e.printStackTrace();
                DBUtil.rollback(conn);
                return false;
            }finally {
                ArrangeFinal(s.getCom_id());
                DBUtil.closeConn(conn);
            }
        }else {
            notPass(s,1);
        }
        return true;
    }

//    public List<PersonScoreBean> getComList(String com_id){
//        List<PersonScoreBean> list = getScoreLists("裁判长",com_id);
//        if(list.size()<1){
//            return null;
//        }
//        List<PersonScoreBean> result = new ArrayList<>();
//        ComScoreBean bean = new ComScoreBean(list.get(0));
//        for (PersonScoreBean s:
//             list) {
//            if(!bean.addAthlete(s)){
//                result.add(bean);
//                bean = new ComScoreBean(s);
//            }
//        }
//        result.add(bean);
//        return result;
//    }

    public List<ComScoreBean> getCompetitions(String authority){
        String sql = null;
        switch (authority){
            case "裁判":
                sql = "select com_id,item_name,sex,age from competition natural join m_item where ref_group_id in (select ref_group from referee where ref_id = ?) and exists (select * from participation where competition.com_id = com_id and status = 0)";
                break;
            case "总裁判":
                sql = "select com_id,item_name,sex,age from competition natural join m_item where ref_group_id in (select ref_group_id from refgroup where group_leader = ?) and exists (select * from participation where competition.com_id = com_id and status = 1)";
                break;
            case "裁判长":
                sql = "select com_id,item_name,sex,age from competition natural join m_item where item_id in (" +
                        "select item_id from m_item where chief_ref = ?) and exists (" +
                        "select * from participation where competition.com_id = com_id and status = 2)";
                break;
        }
        Connection conn = null;
        List<ComScoreBean> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            PreparedStatement state = conn.prepareStatement(sql);
            state.setString(1,reqId);
            ResultSet set = state.executeQuery();
            ComScoreBean bean;
            while(set.next()){
                bean = new ComScoreBean();
                bean.setCom_id(set.getString(1));
                bean.setItem_name(set.getString(2));
                bean.setAge(set.getString(4));
                bean.setSex(set.getString(3));
                list.add(bean);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
            return  list;
        }
    }


    //status 标志评分状态， 0为可以评分，1为所有普通裁判评分完成，2为总裁判通过，3为裁判长通过，即评分结束
    public List<PersonScoreBean> getBasicInfo(String authority,String com_id){
        List<PersonScoreBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement state = null,state2 = null;
        ResultSet set = null,set2 = null;
        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = " ";
            switch(authority){
                case "裁判":
                    //是不是可以用not exists语句？
                    sql = "select ath_id, ath_name,com_id , P, D from participation where status = 0 and com_id = ?";
                    break;
                case "总裁判":
                    sql = "select ath_id, ath_name, com_id, P, D from participation where status = 1 and com_id = ? ";
                    break;
                case "裁判长":
                    sql = "select ath_id, ath_name, com_id, P, D from participation  where status = 2 and com_id = ?";
                    break;
            }
            state = conn.prepareStatement(sql);
            state.setString(1,com_id);
            set = state.executeQuery();
            PersonScoreBean s;
            String ref_master = "";
            if(authority.equals("裁判长")){
                state2 = conn.prepareStatement("select ref_name from referee natural join refgroup natural join competition where com_id = ?");
                state2.setString(1,com_id);
                set2 = state2.executeQuery();
                if(set2.next()){
                    ref_master = set2.getString(1);
                }
            }
            while(set.next()) {
                s = new PersonScoreBean();
                s.setAth_id(set.getString("ath_id"));
                s.setAth_name(set.getString("ath_name"));
                s.setCom_id(set.getString("com_id"));
                s.setP(set.getDouble("P"));
                s.setD(set.getDouble("D"));
                s.setBigReferee(ref_master);
                if(authority.equals("裁判")&&!isScored(s)){
                    list.add(s);
                }else if(!authority.equals("裁判")) {
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



    public List<PersonScoreBean> getScoreLists(String authority,String com_id){
        List<PersonScoreBean> list = getBasicInfo(authority,com_id);
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

    private void statusChange(String com_id) {
        Connection conn = null;
        PreparedStatement state;
        String sql = "update participation set status = 1 where com_id = ? and ath_id in (" +
                "select ath_id from scores where com_id = ? group by (ath_id,com_id) having count(*) = (" +
                "select count(*)-1 from referee group by ref_group having ref_group in (" +
                "select ref_group_id from competition where com_id = ?)))";
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            state = conn.prepareStatement(sql);
            state.setString(1,com_id);
            state.setString(2,com_id);
            state.setString(3,com_id);
            state.executeUpdate();
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
            DBUtil.rollback(conn);
        }finally {
            DBUtil.closeConn(conn);
        }
    }

    private double getResult(String com_id,String ath_id){
        Connection conn=null;
        PreparedStatement state;
        double result = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "select score from scores where com_id = ? and ath_id = ? order by score";
            state = conn.prepareStatement(sql);
            state.setString(1,com_id);
            state.setString(2,ath_id);
            ResultSet set = state.executeQuery();
            List<Double> list = new ArrayList<>();
            while(set.next()){
                list.add(set.getDouble(1));
            }
            for(int i = 1;i<list.size()-1;i++){
                result+=list.get(i);
            }
            return result;
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            DBUtil.closeConn(conn);
        }
    }

    private void getRank(String com_id){
        Connection conn = null;
        PreparedStatement state1,state2;
        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            state1 = conn.prepareStatement("select ath_id from participation where com_id = ? order by result desc");
            state1.setString(1,com_id);
            ResultSet set = state1.executeQuery();
            state2 = conn.prepareStatement("update participation set rank = ? where com_id = ? and ath_id = ?");
            int rank = 0;
            while(set.next()){
                ++rank;
                state2.setInt(1,rank);
                state2.setString(2,com_id);
                state2.setString(3,set.getString(1));
                state2.executeUpdate();
            }
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
            DBUtil.rollback(conn);
        }finally {
            DBUtil.closeConn(conn);
        }
    }

    private void ArrangeFinal(String com_id){
        Connection conn = null;
        PreparedStatement state1,state2,state3,state4;
        try{
            conn = DBUtil.getConnection();
            state1 = conn.prepareStatement("select item_id,ref_group_id from competition where com_id = ? and not exist (select * from participation natural join competition where (status < 3 or finals = 'Y') and item_id = competition.item_id)");
            state1.setString(1,com_id);
            ResultSet set = state1.executeQuery();
            if(set.next()){
                String item_id = set.getString(1);
                String ref_group = set.getString(2);
                state2 = conn.prepareStatement("update into compeition values (?,?,?,'Y',?)");
                state2.setString(1,"FI"+item_id);
                state2.setString(2,item_id);
                state2.setString(3,ref_group);
                state2.setString(4,"2019-05-31");
                state2.executeUpdate();
                state3 = conn.prepareStatement("insert into participation (ath_id,com_id)values (?,?)");
                state4 = conn.prepareStatement("select ath_id from participation natural join competition where rank < 4 and item_id = ?");
                state4.setString(1,item_id);
                ResultSet set2 = state4.executeQuery();
                while(set2.next()){
                    state3.setString(1,set2.getString(1));
                    state3.setString(2,"FI"+item_id);
                    state3.executeUpdate();
                }
            }else{
                return;
            }
        }catch (SQLException e){
            e.printStackTrace();
            DBUtil.rollback(conn);
        }finally {
            DBUtil.closeConn(conn);
        }
    }

    public double GetTeamSumScore(String team_id,String item_id){
        Connection conn = null;
        double score = 0;
        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement state1 = conn.prepareStatement("select score from scores natural join competition where item_id = ? and ath_id in (select ath_id from athletes where team_id = ?)");
            state1.setString(1,item_id);
            state1.setString(2,team_id);
            ResultSet set1 = state1.executeQuery();
            while(set1.next()){
                score += set1.getDouble(1);
            }
        }catch (SQLException e){
            DBUtil.rollback(conn);
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
            return score;
        }
    }

    public List<ResultBean> getAthleteResult(){
        Connection conn = null;
        List<ResultBean> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            PreparedStatement state = conn.prepareStatement("select ath_id,athname,athsex,athage,team_name from athletes natural join team");
            ResultSet set = state.executeQuery();
            ResultBean r;
            while(set.next()){
                r = new ResultBean();
                r.setTeam_name(set.getString("team_name"));
                r.setAth_id(set.getString("ath_id"));
                r.setAth_name(set.getString("athname"));
                r.setAge(set.getInt("athage"));
                r.setSex(set.getString("athsex"));
                r.setResult(String.valueOf(GetAthleteSumItem(r.getAth_id())));
                list.add(r);
            }
        }catch (SQLException E){
            E.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
            return list;
        }
    }

    public double GetAthleteSumItem(String ath_id){
        Connection conn = null;
        double score = 0;
        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement state1 = conn.prepareStatement("select score from scores where ath_id = ?");
            state1.setString(1,ath_id);
            ResultSet set1 = state1.executeQuery();
            while(set1.next()){
                score += set1.getDouble(1);
            }
        }catch (SQLException e){
            DBUtil.rollback(conn);
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
            return score;
        }
    }
}
