package com.cybertek.jdbc.day2;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DB_Practice {
    public static void main(String[] args) throws SQLException {
        //print out all data job table
        DB_Utility.createConnection();
        ResultSet rs = DB_Utility.runQuery("SELECT * FROM JOBS ");

      rs.next();
        System.out.println(rs.getString(1));

      while(rs.next()){
          System.out.println(rs.getString(1));
      }

        System.out.println("Column count: "+  DB_Utility.getColumnCNT());






   // what if we want to print out everthing in the resultSEt
    //without knowing the column names



    }
}