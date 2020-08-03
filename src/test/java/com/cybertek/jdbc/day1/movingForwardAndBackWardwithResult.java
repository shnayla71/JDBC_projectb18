package com.cybertek.jdbc.day1;

import java.sql.*;

public class movingForwardAndBackWardwithResult {
    public static void main(String[] args) throws SQLException {
        String connectionStr="jdbc:oracle:thin:@54.152.243.99:1521:XE";
        String username="hr";
        String password="hr";
        Connection conn= DriverManager.getConnection(connectionStr,username,password) ;

        Statement stmnt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
      //  TYPE_SCROLL_INSENSITIVE make the resultset created from this statement move forward and back
      //  CONCUR_READ_ONLY) make resultset read only that what we need
        ResultSet rs=stmnt.executeQuery("SELECT * FROM COUNTRIES");

      rs.next();
        System.out.println(rs.getString("country_id")+" "+rs.getString("country_name"));

        rs.next();
        System.out.println(rs.getString("country_id")+" "+rs.getString("country_name"));

        rs.previous();// bir oncekine tekrar doner yani 1.ye
        System.out.println(rs.getString("country_id")+" "+rs.getString("country_name"));






    }
}
