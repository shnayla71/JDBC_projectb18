package com.cybertek.jdbc.day1;

import java.sql.*;

public class IteratingResultsetBackWard {

    public static void main(String[] args) throws SQLException {
        String connectionStr="jdbc:oracle:thin:@54.152.243.99:1521:XE";
        String username="hr";
        String password="hr";
        Connection conn= DriverManager.getConnection(connectionStr,username,password) ;
        Statement stmnt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=stmnt.executeQuery("SELECT * FROM REGIONS");

        rs.afterLast();//sondan basa dogru siralar

        while(rs.previous()==true){
            System.out.println(rs.getString(1)+" "+rs.getString(2));
        }

        System.out.println("=====================");
       rs.absolute(2);
        System.out.println(rs.getString(1)+" "+rs.getString(2));

        rs.first();
        System.out.println(rs.getString(1)+" "+rs.getString(2));

        rs.last();
        System.out.println(rs.getString(1)+" "+rs.getString(2));

       //how do I know which row number i am right now at this location
        System.out.println("rs.getRow() = "+ rs.getRow());



    }
}
