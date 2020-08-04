package com.cybertek.jdbc.day2;

import java.sql.*;

public class DB_Utility {
   private static Connection conn;
   private static ResultSet rs;
    /*
    a ststic method create connection
    with valid url username and password
     */
 public static void createConnection(){
     String connectionStr="jdbc:oracle:thin:@54.152.243.99:1521:XE";
     String username="hr";
     String password="hr";

     try {
         conn = DriverManager.getConnection(connectionStr,username,password);
         System.out.println(" connection succesfull");
     } catch (SQLException e) {
         System.out.println(" connection has failed");
         e.printStackTrace();
     }

 }
  public static ResultSet runQuery(String query){

      try {
          Statement stmnt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs=stmnt.executeQuery(query);
      } catch (SQLException e) {
          e.printStackTrace();
      }
    return rs;
  }
/*
 A method for column count
 */
  public static int getColumnCNT(){
      int countColumn=0;

      try {
          ResultSetMetaData   rsmd = rs.getMetaData();
           countColumn=rsmd.getColumnCount();
      } catch (SQLException e) {
          System.out.println("error while counting the columns ");
          e.printStackTrace();
      }

      return countColumn;
  }



}
