package com.vam.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionsDemo {
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Shetty@19");
		Statement stmt=con.createStatement();
		con.setAutoCommit(false);
		try {
			int i1=stmt.executeUpdate("insert into candidate_skills values(57,3)");
			int i2 =stmt.executeUpdate("update skills set name= 'Ruby'where id=1");
			int i3=stmt.executeUpdate("delete from candidates where id=24");
			con.commit();
			System.out.println("transaction is success");
		}//end of try 
		catch(Exception e)
		{
			try
			{
				con.rollback();
				System.out.println("transaction is failed");
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}//end of catch 
		stmt.close();
		con.close();
		System.out.println("connection is closed ");
}
}
