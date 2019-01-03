package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration {
    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com/sql11229223?" + "user=sql11229223&password=UltAjcZkqM");
        }catch(Exception e){
            e.printStackTrace();
        }

        return con;
    }
}
