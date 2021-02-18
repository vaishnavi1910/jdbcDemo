package com.vam.training.jdbcdemo;

 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 

public class scrollableDemo {

 

    public static void main(String[] args) {
        // TODO Auto-generated method stub

 

        Connection con;
          Statement stmt;
          ResultSet rs;              //virtual table
          try
          {
              
            // Class.forName("com.mysql.jdbc.Driver");
              
              //step 2: Open a connection
              
                    System.out.println( "Connecting to database.." );
                    
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Vam@1999");
                    // step 3: creating statement object using connection object 
                    stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    rs=stmt.executeQuery("Select * from skills");
                    
                    rs.afterLast();
                    while(rs.previous()) {
                        System.out.println(rs.getInt(1)+" "+rs.getString(2));
                        
                    }
                    System.out.println("*****************************");
                    //move the cursor to 3rd record
                    rs.absolute(3);
                    System.out.println(rs.getInt(1)+" "+rs.getString(2));
                     System.out.println("*****************************");
               //move the cursor to 2nd record using relative()
                     rs.relative(-1);
                    System.out.println(rs.getInt(1)+" "+rs.getString(2));
                     System.out.println("*****************************");
               
                     int i=rs.getRow(); 
                     System.out.println("Cursor poition=" +i);
                     //get cursor position
                     
                     //cleanup
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
 
          
    
