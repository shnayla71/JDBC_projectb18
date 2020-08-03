package com.cybertek.jdbc.day1;

import java.sql.*;


public class DB_Connection {

    public static void main(String[] args) throws SQLException {
      //connection--->statement-->resultset

      //Driver manager for get the connection
        //jdbc making jdbc connection
        //oracle the database vendor RDBMS name we are trying to connect
        //thin 1 type of oracle driver we are using(download pom dependency)
        //XE sid name unique identifier for the database we are connecting

        String connectionStr="jdbc:oracle:thin:@54.152.243.99:1521:XE";
        String username="hr";
        String password="hr";
        Connection conn= DriverManager.getConnection(connectionStr,username,password) ;

        Statement stmnt=conn.createStatement();

        //resultset object is what we use to store the actual result we get from query
        ResultSet rs=stmnt.executeQuery("SELECT * FROM REGIONS");



    }
}
