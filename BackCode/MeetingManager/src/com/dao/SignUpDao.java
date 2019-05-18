package com.dao;

import com.DBUtil.DBUtil;
import com.bean.Item_list;
import com.bean.PersonBean;
import com.bean.RequestBean;
import com.bean.SignUpBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<PersonBean> getTeamPersonInfo(String team_id){
        List<PersonBean> list = new ArrayList<>();
        Connection conn = null;
        PersonBean bean;
        try{
            conn = DBUtil.getConnection();
            PreparedStatement state = conn.prepareStatement("select ath_id,athname,identification,athage,athsex,cul_goal,tel from athletes where team_id = ?");
            state.setString(1,team_id);
            ResultSet set = state.executeQuery();
            while(set.next()){
                bean = new PersonBean();
                bean.setId(set.getString(1));
                bean.setName(set.getString(2));
                bean.setId_card(set.getString(3));
                bean.setAge(set.getString(4));
                bean.setSex(set.getString(5));
                bean.setCulScore(set.getString(6));
                bean.setTel(set.getString(7));
                bean.setPosition("运动员");
                getItemList(bean);
                list.add(bean);
            }
            PreparedStatement state2 = conn.prepareStatement("select c_name,tel,identification from captain where team_id = ?");
            state2.setString(1,team_id);
            ResultSet set2 = state2.executeQuery();
            if(set2.next()){
                bean = new PersonBean();
                bean.setName(set2.getString(1));
                bean.setTel(set2.getString(2));
                bean.setId_card(set2.getString(3));
                bean.setPosition("领队");
                list.add(bean);
            }
            PreparedStatement state3 = conn.prepareStatement("select d_name,tel,identification from doctor where team_id = ?");
            state3.setString(1,team_id);
            ResultSet set3 = state3.executeQuery();
            while(set3.next()){
                bean = new PersonBean();
                bean.setName(set3.getString(1));
                bean.setTel(set3.getString(2));
                bean.setId_card(set3.getString(3));
                bean.setPosition("队医");
                list.add(bean);
            }
            PreparedStatement state4 = conn.prepareStatement("select co_name,tel,identification,sex from coach where team_id = ?");
            state4.setString(1,team_id);
            ResultSet set4 = state4.executeQuery();
            while(set4.next()){
                bean = new PersonBean();
                bean.setName(set4.getString(1));
                bean.setTel(set4.getString(2));
                bean.setId_card(set4.getString(3));
                bean.setSex(set4.getString(4));
                bean.setPosition("教练");
                list.add(bean);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
            return list;
        }
    }

    private void getItemList(PersonBean bean){
        List<Item_list> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement state;
        try{
            conn = DBUtil.getConnection();
            state = conn.prepareStatement("select item_name from enrollment natural join m_item where ath_id = ?");
            state.setString(1,bean.getId());
            ResultSet set = state.executeQuery();
            Item_list item;
            while(set.next()){
                item = new Item_list();
                item.setItem(set.getString(1));
                list.add(item);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            bean.setItems(list);
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
            String sql2 ="INSERT INTO team (TEAM_ID,TEAM_NAME, PASSWORD,host) VALUES (?,?,'12345',?)";
            state2 = conn.prepareStatement(sql2);
            state2.setString(1,setID());
            state2.setString(2,bean.getName());
            state2.setBoolean(3,bean.isHost());
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
