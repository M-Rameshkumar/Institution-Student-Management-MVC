package com.palletech.acess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.palletech.model.Bean;

public class studentformDao {

    String Driver="com.mysql.cj.jdbc.Driver";
	
	String url="jdbc:mysql://localhost:3306/project";
	
	String password="ramesh123";
	
	String user="root";
	
	Connection con=null;
	
	PreparedStatement ps=null;
	
	Statement s=null;
	
	boolean ischeck=true;
	
	String query="insert into studentformdao (name,age,mobile,address,email,course) values(?,?,?,?,?,?)";
	
	
	
	String delquery="delete from studentformdao where mobile=?;";
	

	

	public Boolean updatesucessfully(Bean b) {
	
	  boolean b1=false;
		try {
			Class.forName(Driver);
			con=DriverManager.getConnection(url, user, password);
			ps=con.prepareStatement("update studentformdao set name=?, age=?, mobile=?, address=?, email=?,course=? where mobile=? ");
			
		ps.setString(1, b.getName());
		ps.setInt(2, b.getAge());
		ps.setLong(3, b.getMobile());
		ps.setString(4, b.getAddress());
		ps.setString(5,  b.getEmail());
		ps.setString(6, b.getCourse());
		ps.setLong(7, b.getMobile());
		
		ps.executeUpdate();
		
		b1=true;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			
	        if(ps!=null && con!=null) {
			
			try {
				
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		}	
		
		return b1;
	
	}
	
public Bean showdataToUpdate(Bean b) { //here we are returning bean object
	
	
	Bean b1=null;
	try {
		Class.forName(Driver);
		
		con=DriverManager.getConnection(url, user, password);
		
		ps=con.prepareStatement("select * from studentformdao  where mobile=? ");
		
		
		ps.setLong(1,b.getMobile() );
		
		ResultSet rs=ps.executeQuery();
		
		
		if(rs.next()) {
			
			String name=rs.getString("name");
			int age=rs.getInt("age");
			long  number=rs.getLong("mobile");
			String address=rs.getString("address");
			
			String email=rs.getString("email");
			String course=rs.getString("course");
		
			 b1= new Bean(name,age,number,address,email,course);
			
			
			
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	finally {
		
        if(ps!=null && con!=null) {
		
		try {
			
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
	return b1;

	
	
}
	
	

	
	
	
	public boolean delete(Bean b) {
		
		boolean val= false;
		try {
		
			
			Class.forName(Driver);
			
			con=DriverManager.getConnection(url, user, password);
			

				
				s=con.createStatement();
				
			   ResultSet rs=s.executeQuery("select * from studentformdao where mobile="+b.getMobile()+"");
			  
			   
				
				while(rs.next()) {
					if(b.getMobile()==rs.getLong("mobile")) {
						val=true;
					}
					
				
				}
				
				
				if(val) {
					ps=con.prepareStatement(delquery);
					ps.setLong(1, b.getMobile());
				    ps.executeUpdate();
						
				 }
						
		}
				
				
				
				

					
				
				
			
			
		
			
			
			
		
		catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
                if(ps!=null && con!=null) {
				
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
		

		return val;
		
	}
	
	public boolean isdatainserted(Bean b) {
		
		
		try {
			
           Class.forName(Driver);
			
			con=DriverManager.getConnection(url, user, password);
			
			
			if(ischeck) {
				
				s=con.createStatement();
			  
				ResultSet rs=s.executeQuery("select * from studentformdao");
				
				while(rs.next()) {
					
					if(b.getEmail().equals(rs.getString("email")) || b.getMobile()==rs.getLong("mobile")) {
						
						ischeck=false;
						break;
						
					}
				}
					
				
			}
			
			if(ischeck) {
			ps=con.prepareStatement(query);
			
			
			ps.setString(1, b.getName());
			ps.setInt(2, b.getAge());
			ps.setLong(3, b.getMobile());
			ps.setString(4, b.getAddress());
			ps.setString(5, b.getEmail());
			ps.setString(6, b.getCourse());
			ps.executeUpdate();
			}	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
                 if(s!=null && ps!=null && con!=null && s!=null) {
				
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
		
		
		
		
		
		
		
		return ischeck;
		
		
		
		
		
	}
	
	
	public ArrayList<Bean> getdata() {
		
		
		 ArrayList<Bean> al= new ArrayList<Bean>();
		 
		try {
			Class.forName(Driver);
			con=DriverManager.getConnection(url, user, password);
			
			s=con.createStatement();
		    ResultSet rs=	s.executeQuery("select * from studentformdao");
		 
		    while(rs.next()) {
		    	
		    int sid=rs.getInt("sid"); //for retrieve use  'get' method
		    
		    String name=rs.getString("name");
		    
		    int age=rs.getInt("age");
		    
		    long mobile=rs.getLong("mobile");
		    
		    String address=rs.getString("address");
		    
		    String email=rs.getString("email");
		    
		    String course=rs.getString("course");
		    
		    
		    // 1st column data retrieved is done then .how to stores this??
		    //we sent this data as object
		    
		    Bean b= new Bean(sid, name, age, mobile, address, email, course);
		    
		     al.add(b);
		   
		     
		    
		   
		    
		         
		    
		    }
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
		      if(s!=null && con!=null ) {
					
					try {
						s.close();
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
		}
		return al;
		
	}






}
