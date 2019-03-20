package com.dao;
import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginDao {
    Connection connection = null;
    Driver driver = null;
    public boolean loginCheck(String account,String password) throws SQLException{
        try{
            //driver = new OracleDriver();
            //DriverManager.deregisterDriver(driver);
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:@thin:@localhost:1521:XE","practiser","practiser");
            //System.out.println(connection);

        }catch (ClassNotFoundException e){

        }
        return true;
    }

}
