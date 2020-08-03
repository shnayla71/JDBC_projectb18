package com.cybertek.jdbc.day1;

import java.sql.*;

public class IteratingResultsetBackWard {

    public static void main(String[] args) throws SQLException {
        String connectionStr="jdbc:oracle:thin:@54.152.243.99:1521:XE";
        String username="hr";
        String password="hr";
        Connection conn= DriverManager.getConnection(connectionStr,username,password) ;
        Statement stmnt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=stmnt.executeQuery("SELECT * FROM COUNTRIES");


    }
}
