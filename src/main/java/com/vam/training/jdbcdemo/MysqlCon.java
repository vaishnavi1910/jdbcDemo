package com.vam.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 

public class MysqlCon 
{

 

    public static void main(String[] args)
    {
              Connection con;
              Statement stmt;
              ResultSet rs;
              
              try
              {
                  //step 1: Register JDBC driver
                  Class.forName("com.mysql.jdbc.Driver");
                  
                  //step 2: Open a connection
                  
                        System.out.println( "Connecting to database.." );
                        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","Shetty@19");
                    
                        // step 3: Execute a query
                       stmt=con.createStatement();
                       rs=stmt.executeQuery("Select employeeNumber,firstName,jobTitle from employees");
                        //  step 4:  Extract data from result set
                        while(rs.next())
                        
                             {
                                    System.out.println( rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)); //+" "+rs.getString(4)+" "+rs.getString("email")+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8) );
                                }
                             rs.close();
                             stmt.close();
                             con.close();
                             
                        }
              catch(Exception e)
              {
                   System.out.println(e);
              }
              }
}
              
