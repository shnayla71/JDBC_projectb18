package com.cybertek.jdbc.day1;

import java.sql.*;

public class CountryTable {
    public static void main(String[] args) throws SQLException {
        String connectionStr="jdbc:oracle:thin:@54.152.243.99:1521:XE";
        String username="hr";
        String password="hr";
        Connection conn= DriverManager.getConnection(connectionStr,username,password) ;

        Statement stmnt=conn.createStatement();

        ResultSet rs=stmnt.executeQuery("SELECT * FROM COUNTRIES");

        while(rs.next()==true) {

            System.out.println(rs.getString("country_id") + " "
                    + rs.getString("country_name") + " "
                    + rs.getInt(3));//BU SEKILDE DE yazabiliriz
            //    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
        }
           // rs.previous();


    }
}
