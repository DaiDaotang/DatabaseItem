package com.dao;

import com.DBUtil.DBUtil;
import java.sql.*;

public class LoginDao {
    private Connection connection = null;
    private PreparedStatement prestatement = null;
    private ResultSet resultSet = null;
    public boolean loginCheck(String account,String password,String athority){
        try{
            connection = DBUtil.getConnection();
            connection.setAutoCommit(false);
            prestatement = connection.prepareStatement("select * from account where account = ?");
            prestatement.setString(1,account);
            resultSet = prestatement.executeQuery();
            if(resultSet.next()){
               if(password == resultSet.getString("password")&& athority==resultSet.getString("athority")){
                   connection.commit();
                   return true;
               }
            }
            return false;
        }catch (SQLException e){
            try {
                if (connection != null) connection.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }finally {
                return false;
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

    public static void main(String[] args){
        LoginDao textDao = new LoginDao();
        //textDao.loginCheck(" "," ");
    }

}
