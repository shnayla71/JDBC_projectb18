package com.cybertek.jdbc.day1;

import java.sql.*;

public class IteratingResultset {

    public static void main(String[] args) throws SQLException {
        String connectionStr="jdbc:oracle:thin:@54.152.243.99:1521:XE";
        String username="hr";
        String password="hr";
        Connection conn= DriverManager.getConnection(connectionStr,username,password) ;

        Statement stmnt=conn.createStatement();

        ResultSet rs=stmnt.executeQuery("SELECT * FROM REGIONS");

     /*   rs.next();
        System.out.println(rs.getString(1)+" "+rs.getString(2));

        rs.next();
        System.out.println(rs.getString(1)+" "+rs.getString(2));

        rs.next();
        System.out.println(rs.getString(1)+" "+rs.getString(2));

        rs.next();
        System.out.println(rs.getString(1)+" "+rs.getString(2));
        System.out.println(rs.next()); // false doner baska bi row olmadigi icin
 */
     // we will keep looping as long as rs.next return true
      while(rs.next()==true){

          System.out.println(rs.getString("REGION_ID")+" "+rs.getString("REGION_NAME"));

      }



    }
}
