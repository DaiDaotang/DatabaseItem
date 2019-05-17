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
        String authority = loginBean.getAuthority();
        try{
            connection = DBUtil.getConnection();
            connection.setAutoCommit(false);
            prestatement = connection.prepareStatement("select * from account where account = ?");
            prestatement.setString(1,account);
            resultSet = prestatement.executeQuery();
            if(resultSet.next()){
               if(password.equals(resultSet.getString("password"))&& authority.equals(resultSet.getString("authority"))){
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
        String authority = loginResp.getResData().getAuthority();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "";
            switch (authority){
                case "代表队":
                    sql = "select team_name from team where team_id = ?";
                    LoginBean loginBean = loginResp.getResData();
                    boolean isSignUp = isSignUp(id,loginBean);
                    loginBean.setSignUp(isSignUp);
                    break;
                case "裁判":
                    sql = "select ref_name from referee where ref_id = ?";
                    break;
                case "管理员":
                    loginResp.getResData().setName("管理员");
                    return;
            }
            prestatement = conn.prepareStatement(sql);
            prestatement.setString(1,id);
            resultSet = prestatement.executeQuery();
            if(resultSet.next()){
                String name = resultSet.getString(1);
                loginResp.getResData().setName(name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
        }
    }

    public boolean isSignUp(String id, LoginBean loginBean){

            try{
                Connection connection = DBUtil.getConnection();
                connection.setAutoCommit(false);
                PreparedStatement statement = connection.prepareStatement("select c_name from captain where team_id = ?");
                statement.setString(1,id);
                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()){
                    return true;
                }
                return false;
            }catch (SQLException e){
                try{
                    if(connection!=null) connection.rollback();
                    return false;
                }catch (SQLException e1){
                    e1.printStackTrace();
                }finally {
                    return false;
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

}
