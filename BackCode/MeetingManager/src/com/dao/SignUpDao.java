package com.dao;

import com.DBUtil.DBUtil;
import com.bean.RequestBean;
import com.bean.SignUpBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpDao {
    public String setID()
    {
        Connection conn = DBUtil.getConnection();
        PreparedStatement state;
        try{
            conn.setAutoCommit(false);
            String sql="SELECT COUNT(*) FROM account";
            state = conn.prepareStatement(sql);
            ResultSet set = state.executeQuery();
            if(set.next()){
                int i = set.getInt(1);
                if(i>99){
                    return String.valueOf(i);
                }else if(i>9){
                    String id = "0"+i;
                    return id;
                }else{
                    String id = "00" + i;
                    return id;
                }
            }
            else
            {
                return "xxxx";
            }
        }catch (SQLException e){
            e.printStackTrace();
            DBUtil.rollback(conn);
            return "xxxx";
        }finally {
            DBUtil.closeConn(conn);
        }
    }

    public void signup(RequestBean<SignUpBean> signupbean)
    {
        Connection conn = DBUtil.getConnection();
        PreparedStatement state;
        PreparedStatement state2;
        SignUpBean bean = signupbean.getReqParam();
        try{
            conn.setAutoCommit(false);
            String sql ="INSERT INTO account VALUES (?,'12345','代表队',?)";
            state = conn.prepareStatement(sql);
            state.setString(1,bean.getAccount());
            state.setString(2,String.valueOf(setID()));
            state.executeUpdate();
            String sql2 ="INSERT INTO team (TEAM_ID,TEAM_NAME, PASSWORD) VALUES (?,?,'12345')";
            state2 = conn.prepareStatement(sql2);
            state2.setString(1,setID());
            state2.setString(2,bean.getName());
            state2.executeUpdate();
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
            DBUtil.rollback(conn);
        }finally {
            DBUtil.closeConn(conn);
        }
    }
}
