package com.cybertek.jdbc.day2;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DB_Practice3 {
    public static void main(String[] args) throws SQLException {
        DB_Utility.createConnection();
        ResultSet rs=DB_Utility.runQuery("SELECT * FROM EMPLOYEES");
        rs.next();
        // store first row data as a map <string,string>
        // the key of column name, value of map column data
        Map<String,String> rowMap=new HashMap<>();
        //rowMap.put("REGION_ID","1");
        //rowMap.put("REGION_NAME","Europe");
     //   rowMap.put("REGION_ID",rs.getString(1));
     //   rowMap.put("REGION_NAME",rs.getString(2));
        ResultSetMetaData rsmd=rs.getMetaData();
        for(int i=1;i<=rsmd.getColumnCount();i++){

            rowMap.put(rsmd.getColumnName(i),rs.getString(i));

         //   System.out.println(rsmd.getColumnName(i));
        }
        System.out.println("rowMap= "+rowMap);


    }
}
