package com.dao;

import com.DBUtil.DBUtil;
import com.bean.CaptainBean;
import com.bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationDao {
    private ApplicationBean bean;
    public ApplicationDao(ApplicationBean b)
    {
        bean = b;
    }
    public void inputCaptain(String id)
    {
        Connection conn=null;
        PreparedStatement state1;

        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            for (CaptainBean cap:
                 bean.getCaptain()) {
                state1 = conn.prepareStatement("insert into captain values(?,?,?,?)");
                state1.setString(1,cap.getName());
                state1.setString(2,cap.getTel());
                state1.setString(3,cap.getidCard());
                state1.setString(4,id);
                int x = state1.executeUpdate();
                if(x<1){
                    System.err.println(cap.getName());
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
    public void inputDoctor(String id)
    {
        Connection conn=null;
        PreparedStatement state2;

        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            for (DoctorBean doc:
                    bean.getDoctor()) {
                state2 = conn.prepareStatement("insert into doctor values(?,?,?,?)");
                state2.setString(1,doc.getName());
                state2.setString(2,doc.getTel());
                state2.setString(3,doc.getidCard());
                state2.setString(4,id);
                int x = state2.executeUpdate();
                if(x<1){
                    System.err.println(doc.getName());
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
    public void inputCoach(String id)
    {
        Connection conn=null;
        PreparedStatement state3;

        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            for (CoachBean coa:
                    bean.getCoach()) {
                state3 = conn.prepareStatement("insert into coach values(?,?,?,?,?)");
                state3.setString(1,coa.getName());
                state3.setString(2,coa.getSex());
                state3.setString(3,coa.getTel());
                state3.setString(4,coa.getidCard());
                state3.setString(5,id);
                int x = state3.executeUpdate();
                if(x<1){
                    System.err.println(coa.getName());
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
    public String judgeAge(int age)
    {
        if(age==7||age==8)
        {
            return "7-8";
        }
        else if(age==9||age==10)
        {
            return "9-10";
        }
        else if(age==11||age==12)
        {
            return "11-12";
        }
        else
        {
            return "0-100";
        }
    }
    public void inputAthlete(String id)
    {
        Connection conn=null;
        PreparedStatement state4,state5,state6,s1,s2,s3,s4,s5;

        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            s1 = conn.prepareStatement("select count(*) from team natural join athletes where host = 0 group by athsex having athsex='男'");
            ResultSet set1 = s1.executeQuery();
            int c1 ;
            int d1 ;
            if(set1.next())
            {
                c1 = set1.getInt(1);
                d1 = 0;
            }
            else
            {
                c1 = 0;
                d1 = 0;
            }
            s2 = conn.prepareStatement("select count(*) from team natural join athletes where host = 0 group by athsex having athsex='女'");
            ResultSet set2 = s2.executeQuery();
            int c2 ;
            int d2 ;
            if(set2.next())
            {
                c2 = set2.getInt(1);
                d2 = 0;
            }
            else
            {
                c2 = 0;
                d2 = 0;
            }
            s3 = conn.prepareStatement("select count(*) from team natural join athletes where host > 0 group by athsex having athsex='男'");
            ResultSet set3 = s3.executeQuery();
            int c3 ;
            int d3 ;
            if(set3.next())
            {
                c3 = set3.getInt(1);
                d3 = 0;
            }
            else
            {
                c3 = 0;
                d3 = 0;
            }
            s4 = conn.prepareStatement("select count(*) from team natural join athletes where host > 0 group by athsex having athsex='女'");
            ResultSet set4 = s4.executeQuery();
            int c4 ;
            int d4 ;
            if(set4.next())
            {
                c4 = set4.getInt(1);
                d4 = 0;
            }
            else
            {
                c4 = 0;
                d4 = 0;
            }
            s5 = conn.prepareStatement("select host from team natural join athletes where team_id = ?");
            s5.setString(1,id);
            ResultSet set5 = s5.executeQuery();
            int host = 0;
            if(set5.next()) {
                host = set5.getInt("host");
            }
            for (AthleteBean ath:
                    bean.getAthlete()) {
                state4 = conn.prepareStatement("insert into athletes values(?,?,?,?,?,?,?,?)");
                String athlete_id;
                if(host==0)
                {
                    if(ath.getSex()=="男")
                    {
                        int i = (c1 + d1) * 2 + 1;
                        d1++;
                        if(i>99){
                            athlete_id = String.valueOf(i);
                        }else if(i>9){
                            athlete_id = "0"+ i;
                        }else{
                            athlete_id = "00" + i;
                        }
                    }
                    else if(ath.getSex()=="女")
                    {
                        int i = (c2 + d2) * 2;
                        d2++;
                        if(i>99){
                            athlete_id = String.valueOf(i);
                        }else if(i>9){
                            athlete_id = "0"+ i;
                        }else{
                            athlete_id = "00" + i;
                        }
                    }
                    else
                    {
                        athlete_id = "xxxx";
                    }
                }
                else
                {
                    if(ath.getSex()=="男")
                    {
                        int i = 999 - (c3 + d3) * 2;
                        d3++;
                        if(i>99){
                            athlete_id = String.valueOf(i);
                        }else if(i>9){
                            athlete_id = "0"+ i;
                        }else{
                            athlete_id = "00" + i;
                        }
                    }
                    else if(ath.getSex()=="女")
                    {
                        int i = 999 - (c4 + d4) * 2 - 1;
                        d4++;
                        if(i>99){
                            athlete_id = String.valueOf(i);
                        }else if(i>9){
                            athlete_id = "0"+ i;
                        }else{
                            athlete_id = "00" + i;
                        }
                    }
                    else
                    {
                        athlete_id = "xxxx";
                    }
                }
                state4.setString(1,athlete_id);
                state4.setString(2,ath.getName());
                state4.setString(3,ath.getidCard());
                state4.setInt(4,ath.getAge());
                state4.setString(5,ath.getSex());
                state4.setString(6,ath.getGrade());
                state4.setString(7,id);
                state4.setString(8,ath.getTel());
                int x = state4.executeUpdate();
                if(x<1){
                    System.err.println(ath.getName());
                }
                for (Item_list item:
                     ath.getItem_lists()) {
                    state6=conn.prepareStatement("select item_id from m_item where item_name = ? and age= ? and sex= ?");
                    String judgeAge = judgeAge(ath.getAge());
                    state6.setString(1,item.getItem());
                    state6.setString(2,judgeAge);
                    state6.setString(3,ath.getSex());
                    ResultSet set = state6.executeQuery();
                    String item_id;
                    if(set.next())
                    {
                        item_id = set.getString("item_id");
                    }
                    else
                    {
                        return;
                    }
                    state5 = conn.prepareStatement("insert into enrollment (ATH_ID,ITEM_ID,TEAM_ID) values (?,?,?)");
                    state5.setString(1,athlete_id);
                    state5.setString(2,item_id);
                    state5.setString(3,id);
                    int y = state5.executeUpdate();
                    if(y<1){
                        System.err.println(item_id);
                    }
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
    public void application(String id)
    {
        inputCaptain(id);
        inputDoctor(id);
        inputCoach(id);
        inputAthlete(id);
    }
}
