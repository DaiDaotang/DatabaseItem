package com.dao;

import com.DBUtil.DBUtil;
import com.bean.ChangePasswordBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangePasswordDao {
    private ChangePasswordBean bean;
    public ChangePasswordDao(ChangePasswordBean b)
    {
        bean=b;
    }

    public void change()
    {
        Connection conn=null;
        PreparedStatement state;
        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            String account=bean.getAccount();
            String old_password=bean.getOld_password();
            String new_password=bean.getNew_password();
            state=conn.prepareStatement("UPDATE ACCOUNT SET PASSWORD = ? WHERE ACCOUNT=?AND PASSWORD=?");
            state.setString(1,new_password);
            state.setString(2,account);
            state.setString(3,old_password);
            state.executeUpdate();
            conn.commit();

        }catch (SQLException e){
            e.printStackTrace();
            DBUtil.rollback(conn);
        }finally {
            DBUtil.closeConn(conn);
        }
    }
}
