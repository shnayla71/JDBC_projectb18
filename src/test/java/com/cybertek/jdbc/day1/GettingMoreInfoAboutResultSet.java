package com.cybertek.jdbc.day1;

import java.sql.*;

public class GettingMoreInfoAboutResultSet {

    public static void main(String[] args) throws SQLException {
        String connectionStr="jdbc:oracle:thin:@54.152.243.99:1521:XE";
        String username="hr";
        String password="hr";
        Connection conn= DriverManager.getConnection(connectionStr,username,password) ;
        Statement stmnt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=stmnt.executeQuery("SELECT * FROM EMPLOYEES");

     //RESULTSETMETADATA is data about ResultSet like column count column name

        ResultSetMetaData rsmd=rs.getMetaData();

        // counting how many columns we have in our ResultSet
       int columnCount=rsmd.getColumnCount();
        System.out.println(columnCount);

        //find out column name acccording to index
        System.out.println(rsmd.getColumnName(2));

        // how to list all column name from the ResultSet
        for(int i=1;i<=columnCount;i++){
            System.out.println(rsmd.getColumnName(i)+" ");
        }



    }
}
