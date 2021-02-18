package com.vam.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 

public class InsertDemo {

 


    public static void main(String[] args) {
        // TODO Auto-generated method stub

 


        Connection con;
        Statement stmt;
        ResultSet rs;
        int cnt = 0;

 

        try {
            //Register JDBC driver    
            Class.forName("com.mysql.cj.jdbc.Driver");

 

            //Open a connection
            System.out.println("Connecting to database..");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Shetty@19");

 

            String str = "INSERT INTO skills(name)" + "VALUES('Spring Boot')";

 

            stmt = con.createStatement();
            int rowcount = stmt.executeUpdate(str);
            if(rowcount > 0)
            {
                System.out.println("Record Inserted Successfully");
            }

 

            String str1 = "select count(id) from skills";
            rs = stmt.executeQuery(str1);
            
            while(rs.next())
            {
                cnt = rs.getInt(1);
            }
            System.out.println("Total no. of record is :"+cnt);
            con.close();
        }
        catch(Exception ce)
        {
            System.out.println(ce);
        }

 

    }
}










