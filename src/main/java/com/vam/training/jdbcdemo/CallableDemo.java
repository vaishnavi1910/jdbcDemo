package com.vam.training.jdbcdemo;

import java.sql.*;
public class CallableDemo {

 

    Connection con ;
    CallableStatement cstmt;
     ResultSet rs;
     
     public CallableDemo()
     {
    
    
    }
    
    void createConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
              con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Shetty@19");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void getSkills(int candidateId)
    {
        try
        {
            String query = "{ call get_candidate_skill(?) }";
            cstmt = con.prepareCall(query);
            cstmt.setInt(1, candidateId);
            
            rs = cstmt.executeQuery();
            while(rs.next())
            {
                System.out.println(String.format("%s- %s", rs.getString("first_name")
                        +" " + rs.getString("last_name"),
                        rs.getString("skill")));
                
                
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

 

 

    public static void main(String[] args) {
    CallableDemo cd1=new CallableDemo();
    cd1.createConnection();
    cd1.getSkills(133);
    
    
    }

 

}
 
       
       
