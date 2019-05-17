package com.dao;

import com.DBUtil.DBUtil;
import com.bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InputRefereeDao {
    private InputReferee_GroupBean bean;
    public InputRefereeDao(InputReferee_GroupBean b)
    {
        bean = b;
    }
    public int setRef_id()
    {
        Connection conn = DBUtil.getConnection();
        PreparedStatement state;
        try{
            conn.setAutoCommit(false);
            String sql="SELECT COUNT(*) FROM referee";
            state = conn.prepareStatement(sql);
            ResultSet set = state.executeQuery();
            if(set.next()){
                int i = set.getInt(1);
                return i;
            }
            else
            {
                return 0;
            }
        }catch (SQLException e){
            e.printStackTrace();
            DBUtil.rollback(conn);
            return 0;
        }finally {
            DBUtil.closeConn(conn);
        }
    }
    public int setRef_group_id()
    {
        Connection conn = DBUtil.getConnection();
        PreparedStatement state;
        try{
            conn.setAutoCommit(false);
            String sql="SELECT COUNT(*) FROM refgroup";
            state = conn.prepareStatement(sql);
            ResultSet set = state.executeQuery();
            if(set.next()){
                int i = set.getInt(1);
                return i;
            }
            else
            {
                return 0;
            }
        }catch (SQLException e){
            e.printStackTrace();
            DBUtil.rollback(conn);
            return 0;
        }finally {
            DBUtil.closeConn(conn);
        }
    }
    public void inputreferee()
    {
        Connection conn=null;
        PreparedStatement state1,state2,state3,state4,state5;
        String ref_masterName = bean.getRef_masterName();
        String id_card = bean.getId_card();
        String tel = bean.getTel();
        String account = bean.getAccount();
        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            String a = String.valueOf(setRef_id());
            String b = String.valueOf(setRef_group_id());
            int c = setRef_id();
            state1=conn.prepareStatement("insert into referee values (?,?,?,?,?)");
            state1.setString(1,a);
            state1.setString(2,ref_masterName);
            state1.setString(3,tel);
            state1.setString(4,id_card);
            state1.setString(5,b);
            int x = state1.executeUpdate();
            state2 = conn.prepareStatement("insert into refgroup values(?,?)");
            state2.setString(1,b);
            state2.setString(2,a);
            int y = state2.executeUpdate();
            state4 = conn.prepareStatement("insert into account values(?,'12345','总裁判',?)");
            state4.setString(1,account);
            state4.setString(2,a);
            int z = state4.executeUpdate();
            if(x<1||y<1||z<1)
            {
                System.err.println(a);
            }
            if(bean.getRef_lists()==null){
                return;
            }
            for (Ref_List ref:
                    bean.getRef_lists()) {
                c++;
                String d = String.valueOf(a+c);
                state3 = conn.prepareStatement("insert into referee values (?,?,?,?,?)");
                state3.setString(1,d);
                String s = ref.getName();
                state3.setString(2,s);
                state3.setString(3,ref.getTel());
                state3.setString(4,ref.getId_card());
                state3.setString(5,b);
                int u = state3.executeUpdate();
                state5 = conn.prepareStatement("insert into account values(?,'12345','裁判',?)");
                state5.setString(1,ref.getAccount());
                state5.setString(2,d);
                int w = state5.executeUpdate();
                if(u<1||w<1)
                {
                    System.err.println(d);
                }
            }
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
            DBUtil.rollback(conn);
        }finally {
            DBUtil.closeConn(conn);
        }
    }
}
