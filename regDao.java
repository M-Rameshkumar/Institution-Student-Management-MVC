package com.palletech.acess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.palletech.model.lbean;

public class regDao {

	
	String Driver="com.mysql.cj.jdbc.Driver";
	
	String url="jdbc:mysql://localhost:3306/project";
	
	String password="ramesh123";
	
	String user="root";
	
	Connection con=null;
	Statement s=null;
	
	PreparedStatement ps=null;
	
	
	
	String Query="insert into userl (name,email,password) values (?,?,?);";
	String cury="select * from userl";
	
	
	boolean isinserted=true;
	
	
	
	
	public boolean check(lbean bs) {
		
		boolean isdatapresent=false;
		try {
			Class.forName(Driver);
			con=DriverManager.getConnection(url, user, password);
			s=con.createStatement();
			
			
			
			ResultSet rs=s.executeQuery("select * from userl");
			
			while(rs.next()) {
				
				if(bs.getEmail().equals(rs.getString("email")) && bs.getPassword().equals(rs.getString("password"))){
					isdatapresent=true;
					break;
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
       finally {
			
			if(con!=null && s!=null) {
				
				try {
					
					s.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
       }
		return isdatapresent;
	}
	
	
	
	
	
	
	public boolean insert(lbean bs) {
	
		try {
			Class.forName(Driver);
			
			con=DriverManager.getConnection(url, user, password);
			
			
			
			s=con.createStatement();
			
			ResultSet rs= s.executeQuery(cury);
			
			while(rs.next()) {
				
				if(bs.getEmail().equals(rs.getString("email"))) {
					
					isinserted =false;
					break;
				}
				
			}
			
			if(isinserted) {
				
			
			ps=con.prepareStatement(Query);
			
			ps.setString(1, bs.getName() );
			ps.setString(2, bs.getEmail());
			ps.setString(3, bs.getPassword());
			
			
			ps.executeUpdate();
			}
					
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			isinserted=false;
			e.printStackTrace();
		}
		
		finally {
			
			if(ps!=null && con!=null && s!=null) {
				
				try {
					ps.close();
					s.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		return isinserted;
		
		
		
		
	}
	
	
}
