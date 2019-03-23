package com.dao;

import com.DBUtil.DBUtil;
import java.sql.*;
import com.bean.LoginBean;
import com.bean.RequestBean;
import com.bean.ResponseBean;

public class LoginDao {
    private Connection connection = null;
    private PreparedStatement prestatement = null;
    private ResultSet resultSet = null;
    public String loginCheck(LoginBean loginBean){
        String account = loginBean.getAccount();
        String password = loginBean.getPassword();
        String athority = loginBean.getAthority();
        try{
            connection = DBUtil.getConnection();
            connection.setAutoCommit(false);
            prestatement = connection.prepareStatement("select * from account where account = ?");
            prestatement.setString(1,account);
            resultSet = prestatement.executeQuery();
            if(resultSet.next()){
               if(password == resultSet.getString("password")&& athority==resultSet.getString("athority")){
                   String id = resultSet.getString("id");
                   connection.commit();
                   return id;
               }
            }
            return null;
        }catch (SQLException e){
            try {
                if (connection != null) connection.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }finally {
                return null;
            }
        }finally {
            try {
                if(resultSet!=null) resultSet.close();
                if(prestatement!=null) prestatement.close();
                if(connection!=null) connection.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
    }

    public void getName(ResponseBean<LoginBean> loginResp){
        String id = loginResp.getReqId();
        String athority = loginResp.getResData().getAthority();
        try {
            connection = DBUtil.getConnection();
            connection.setAutoCommit(false);
            String sql = "";
            switch (athority){
                case "代表队":
                    sql = "select team_name from squad where team_id = ?";
                    break;
                case "裁判":
                    sql = "select ref_name from referee where ref_id = ?";
                    break;
                case "管理员":
                    loginResp.getResData().setName("管理员");
                    return;
            }
            prestatement = connection.prepareStatement(sql);
            prestatement.setString(1,id);
            resultSet = prestatement.executeQuery();
            if(resultSet.next()){
                String name = resultSet.getString(1);
                connection.commit();
                loginResp.getResData().setName(name);
            }
        }catch (SQLException e){
            try{
                if(connection!=null) connection.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        }finally {
            try {
                if (resultSet != null) resultSet.close();
                if (prestatement != null) prestatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        LoginDao textDao = new LoginDao();

        //textDao.loginCheck(" "," ");
    }

}
