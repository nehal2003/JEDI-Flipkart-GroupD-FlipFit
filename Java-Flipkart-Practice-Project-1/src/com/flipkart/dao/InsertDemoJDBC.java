/**
 * 
 */
package com.flipkart.dao;
import java.sql.*;

/**
 * 
 */
public class InsertDemoJDBC{
    public static void main(String [] args) {
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		  
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/flipfit_schema","root","password");   
		  
		PreparedStatement stmt=con.prepareStatement("insert into Employee values(?,?)");  
		stmt.setInt(1,101);//1 specifies the first parameter in the query  
		stmt.setString(2,"Ratan");  
		  
		int i=stmt.executeUpdate();  
		System.out.println(i+" records inserted");  
		  
		con.close();  
		  
		}catch(Exception e){ System.out.println(e);}  

}
}
