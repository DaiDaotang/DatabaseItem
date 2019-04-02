package com.dao;
import com.bean.CheckResultBean;
import com.bean.ReqPageInfo;
import com.bean.ResultBean;
import com.DBUtil.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CheckResultDao {
    private CheckResultBean bean;
    private ReqPageInfo page;
    //private String teamName;
    //private String teamId;
    public CheckResultDao(){}

    public CheckResultDao(CheckResultBean bean,ReqPageInfo page){
        setBean(bean);
        setPage(page);
    }

    public ReqPageInfo getPage() {
        return page;
    }

    public void setPage(ReqPageInfo page) {
        this.page = page;
    }

    public void setBean(CheckResultBean bean) {
        this.bean = bean;
    }

    public CheckResultBean getBean() {
        return bean;
    }

    public List<ResultBean> GetResultByAthlete(){
        if(bean==null||page==null){
            return null;
        }
        String ath_name = bean.getAth_name();
        int curPage = page.getCurPage();
        int pageSize = page.getPageSize();
        List<ResultBean> results = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            pStatement = conn.prepareStatement("select ath_id,result,finals,rank from competition natural join participation where ath_id in(select ath_id from athletes where ath_name = ?)");
            pStatement.setString(1,ath_name);
            resultSet = pStatement.executeQuery();
            ResultBean result;
            int index = 0,size = 0;
            while(resultSet.next()&&size<pageSize){
                index++;
                if(index<pageSize*(curPage-1))
                {
                    continue;
                }
                size++;
                result = new ResultBean();
                result.setAth_name(ath_name);
                result.setAth_id(resultSet.getString("ath_id"));
                GetTeamMessage(result);
                String isFinal = resultSet.getString("finals");
                if(isFinal=="Y"){
                    result.setFinal_result(resultSet.getString("result"));
                    result.setFinal_rank(resultSet.getString("rank"));
                }else{
                    result.setPri_result(resultSet.getString("result"));
                    result.setPri_rank(resultSet.getString("rank"));
                }
                results.add(result);
            }
            conn.commit();
            return results;
        }catch (SQLException e){
            try {
                if(conn!=null) conn.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }finally {
                return null;
            }
        }finally {
            try {
                if(resultSet!=null) resultSet.close();
                if(pStatement!=null) pStatement.close();
                if(conn!=null) conn.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
    }

    private void GetTeamMessage(ResultBean result){
        String ath_name = bean.getAth_name();
        Connection conn = null;
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            pStatement = conn.prepareStatement("select team_id,team_name from squad where team_id in(select team_id from athletes where ath_id = ?)");
            pStatement.setString(1,result.getAth_id());
            resultSet = pStatement.executeQuery();
            if(resultSet.next()){
                result.setTeam_id(resultSet.getString("team_id"));
                result.setTeam_name(resultSet.getString("team_name"));
            }
            conn.commit();
        }catch (SQLException e){
            try {
                if(conn!=null) conn.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }finally {
            }
        }finally {
            try {
                if(resultSet!=null) resultSet.close();
                if(pStatement!=null) pStatement.close();
                if(conn!=null) conn.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
    }

    public List<ResultBean> GetResultByTeam(){
        if(bean==null||page==null){
            return null;
        }
        String team_name = bean.getTeam_name();
        int curPage = page.getCurPage();
        int pageSize = page.getPageSize();
        List<ResultBean> results = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            pStatement = conn.prepareStatement("select ath_id,athname,result,finals,rank,team_id from competition natural join participation natural join athletes where team_id in(select team_id from squad where team_name = ?)");
            pStatement.setString(1,team_name);
            resultSet = pStatement.executeQuery();
            ResultBean result;
            int index = 0,size = 0;
            while(resultSet.next()&&size<pageSize){
                index++;
                if(index<pageSize*(curPage-1))
                {
                    continue;
                }
                size++;
                result = new ResultBean();
                result.setAth_name(resultSet.getString("athname"));
                result.setAth_id(resultSet.getString("ath_id"));
                result.setTeam_name(team_name);
                result.setTeam_id(resultSet.getString("team_id"));
                String isFinal = resultSet.getString("finals");
                if(isFinal=="Y"){
                    result.setFinal_result(resultSet.getString("result"));
                    result.setFinal_rank(resultSet.getString("rank"));
                }else{
                    result.setPri_result(resultSet.getString("result"));
                    result.setPri_rank(resultSet.getString("rank"));
                }
                results.add(result);
            }
            conn.commit();
            return results;
        }catch (SQLException e){
            try {
                if(conn!=null) conn.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }finally {
                return null;
            }
        }finally {
            try {
                if(resultSet!=null) resultSet.close();
                if(pStatement!=null) pStatement.close();
                if(conn!=null) conn.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
    }


    public String GetTeamRank(){
        //todo:查询代表队成绩
        return null;
    }
}
