package com.cybertek.jdbc.day2;

import java.sql.*;

public class DB_Practice2 {
    public static void main(String[] args) throws SQLException {
        DB_Utility.createConnection();
        ResultSet rs = DB_Utility.runQuery("SELECT * FROM REGIONS");
        //THIS METHOD call is displaying the data of resultset
          DB_Utility.displayAllData();

     //getting a random data
     //move resultset to second row
    // rs.absolute(2);

   //  DB_Utility.runQuery("SELECT * FROM EMPLOYEES WHERE SALARY > 19000");
     DB_Utility.displayAllData();
      //  int colcount = DB_Utility.getColumnCNT();
      //  rs.first();// yazarsak alttaki dongu ikinciden baslar
       /* while (rs.next() == true) {

            for (int i = 1; i <= colcount; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }*/
        System.out.println(DB_Utility.getColumnDataAtRow(3,2));
        System.out.println(DB_Utility.getColumnDataAtRow(3,"REGION_NAME"));

        System.out.println(DB_Utility.getRowDataAsList(4));
        DB_Utility.runQuery("SELECT * FROM EMPLOYEES");
        System.out.println(DB_Utility.getRowCount());

        System.out.println(DB_Utility.getColumnDataAsList(4));
        System.out.println(DB_Utility.getColumnDataAsList("FIRST_NAME"));






    }
}