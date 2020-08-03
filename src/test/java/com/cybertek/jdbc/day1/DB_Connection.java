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
      // next() method is used to move the cursor and return the result as boolean
      rs.next();//row da ilerler yukardan asagi
      //getting the column data we use multiple get methods
        System.out.println("first column value: " + rs.getString(1));
        System.out.println("first column name value: " + rs.getString("REGION_ID"));
        System.out.println();
        System.out.println("second column value: " + rs.getString(2));
        System.out.println("second column value: " + rs.getString("REGION_NAME"));
        System.out.println("========================================");
      rs.next(); // bir diger rowa gecmek icin
        System.out.println("first column value: " + rs.getString(1));
        System.out.println("first column name value: " + rs.getString("REGION_ID"));
        System.out.println();
        System.out.println("second column value: " + rs.getString(2));
        System.out.println("second column value: " + rs.getString("REGION_NAME"));

        rs.close();
        stmnt.close();
        conn.close();








    }
}
