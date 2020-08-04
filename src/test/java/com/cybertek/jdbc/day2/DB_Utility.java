package com.cybertek.jdbc.day2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Utility {
   private static Connection conn;
   private static ResultSet rs;

   // WE want to store certain row data as a map
   // entire row number map<string,string>


   /*
   getting singke column cell value at certain row
   row 2 column 3
    */
   public static String getColumnDataAtRow(int rowNum,int columnIndex){

       String result = "" ;
       try {
           rs.absolute( rowNum ) ;
           result = rs.getString( columnIndex ) ;
       } catch (SQLException e) {
           System.out.println("ERROR WHILE getColumnDataAtRow ");
           e.printStackTrace();
       }
       return result ;
   }

    public static String getColumnDataAtRow(int rowNum,String columnName){

        String result = "" ;
        try {
            rs.absolute( rowNum ) ;
            result = rs.getString( columnName ) ;
        } catch (SQLException e) {
            System.out.println("ERROR WHILE getColumnDataAtRow ");
            e.printStackTrace();
        }
        return result ;
    }
    /*
    a ststic method create connection
    with valid url username and password
     */
    public static List<String> getRowDataAsList(int rowNum){

        List<String> rowDataList=new ArrayList<>();

        try {
            rs.absolute(rowNum);
            for(int i=1;i<=getColumnCNT();i++){
               rowDataList.add(rs.getString(i));
            }
            rs.beforeFirst();
        } catch (SQLException e) {
            System.out.println(" error getdataList");
            e.printStackTrace();
        }


        return rowDataList;
    }
    public static List<String> getColumnDataAsList(int columnIndex){
        List<String> columnDataList=new ArrayList<>();

        try {
            rs.beforeFirst();
           while( rs.next()){
               columnDataList.add(rs.getString(columnIndex));
           }
            rs.beforeFirst();
        } catch (SQLException e) {
            System.out.println(" error column number");
            e.printStackTrace();
        }


        return columnDataList;
    }
    public static List<String> getColumnDataAsList(String columnName){
        List<String> columnDataList=new ArrayList<>();

        try {
            rs.beforeFirst();
            while( rs.next()){
                String data=rs.getString(columnName);
                columnDataList.add(data);
            }
            rs.beforeFirst();
        } catch (SQLException e) {
            System.out.println(" error column number");
            e.printStackTrace();
        }


        return columnDataList;
    }
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
  public static int getRowCount(){
      int rowCount=0;

      try {
          rs.last();
          rowCount=rs.getRow();

          rs.beforeFirst();
      } catch (SQLException e) {
          System.out.println("error while counting the row count ");
          e.printStackTrace();
      }

      return rowCount;
  }
/*
a method to display all the data in the result set
 */
 public static void displayAllData(){
     int colcount=DB_Utility.getColumnCNT();


         try {
             //in order the start from begining
             rs.beforeFirst();
             while(rs.next()==true) {
                 for (int i = 1; i <= colcount; i++) {
                     System.out.println(rs.getString(i) );
                 }
             }
             //now the cursor is the after last location
             rs.beforeFirst();

         } catch (SQLException e) {
             System.out.println(" error whilw getting all data");
             e.printStackTrace();
         }
     }
 }


