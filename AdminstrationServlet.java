package com.palletech;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.palletech.acess.regDao;
import com.palletech.acess.studentformDao;
import com.palletech.model.Bean;
import com.palletech.model.lbean;

public class AdminstrationServlet  extends HttpServlet{

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		
		String path=req.getServletPath();
		
		switch(path) {
		
		case "/reg": userregister(req,res);
			
			break;
			
		case "/login": userlogin(req,res);
			break;
			
		case "/signup":  
			break;
		
		case"/showstudentdatatoupdate":	showStudentdataToUpdate(req,res);
			break;
		case"/updatedsucess":updatedsucess(req,res);	
		break;
			
		case "/studenthome":
			
			String action=req.getParameter("action");
			
			if(action!=null) {
			switch(action) {
			
			case "addstudent": addstudent(req,res);
				break;
			case "display": displaystudent(req,res);
				
				break;	
			case "update":update(req,res);
				break;					
				
			case "delete": delete(req,res);
				break;
			
			case "savestudent":	savestudent(req,res);
				break;
			}
			
			}
			
			
		}
		
       
		
	}

	
	
private void updatedsucess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	String name=req.getParameter("txtname");
	
	int age=  Integer.parseInt(req.getParameter("txtage"));
	
	long mobile=Long.parseLong(req.getParameter("txtnumber"));
	
	String address=req.getParameter("txtaddress");
	
	String email=req.getParameter("txtemail");

	String course=req.getParameter("txtcourse");
	
	Bean b= new Bean(name,age,mobile,address,email,course);
	
	studentformDao sd= new studentformDao();
	
	Boolean b1=sd.updatesucessfully(b);
	
	if(b1==true) {
		
		req.setAttribute("message1", "sucessfully updated");
	}
	
else {
	req.setAttribute("message1", "enter data to update");
		
	}
		RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
		rd.forward(req, res);
	
	
	}

private void showStudentdataToUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	
	 long mobile=Long.parseLong( req.getParameter("mob"));
	
     Bean b= new Bean(mobile);
     
     studentformDao sd= new studentformDao();
     
    Bean b1= sd.showdataToUpdate(b);
    
    if(b1!=null) {
    	
    	req.setAttribute("studentdata", b1);
    }
    else if(b1==null) {
    	req.setAttribute("message", "invalid number");
    	}
    
    	RequestDispatcher rd= req.getRequestDispatcher("update.jsp");
    	rd.forward(req, res);
    	
    
     
     

		
	}

private void update(HttpServletRequest req, HttpServletResponse res) throws IOException{
		// TODO Auto-generated method stub
		
	   res.sendRedirect("update.jsp");
	
	}


	private void delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, NumberFormatException {
		// TODO Auto-generated method stub
		
		
		 
		 String num=req.getParameter("delete");
		 
		 if(num==null || num.isEmpty()) {
			res.sendRedirect("delete.jsp");
			return; //it stop method excution
		 }
		 
		 long number = Long.parseLong(num);
		 
		 Bean b= new Bean(number);
		
		 studentformDao d= new studentformDao();
		 
	     boolean respns=d.delete(b);
		 
		
		
			
			if(respns==true) { 
			req.setAttribute("message", "sucessfully deleted");
			}
			
			else {
				  req.setAttribute("message", "NO User found at this number");
			   }
			RequestDispatcher rd=req.getRequestDispatcher("delete.jsp");
			
			rd.forward(req, res);
		     
		
		
	
	}
	
	
	

	private void displaystudent(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		studentformDao d= new studentformDao();
		
		 ArrayList<Bean>  al= d.getdata();
		 
		 req.setAttribute("studentdata", al);
		 
		 RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
		 rd.forward(req, res);
		//here we donot want bean bcs we did not sent any input we only retreving 
		
		
		
		
		
	}

	private void savestudent(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		// TODO Auto-generated method stub
		
		    String name=req.getParameter("txtname");
			Integer age= Integer.parseInt(req.getParameter("txtAge"));
		
			Long mobile= Long.parseLong(  req.getParameter("txtmobile"));
			
			String address=req.getParameter("txtaddress");
			
			String email=req.getParameter("txtemail");
			
			String course=req.getParameter("txtcourse");
			
				
			
			
			
			Bean b= new Bean(name,age,mobile,address,email,course);
			
			studentformDao sd= new studentformDao();
			
			
			
			PrintWriter out=res.getWriter();
			
		   boolean x=sd.isdatainserted(b);
		   res.setContentType("text/html");
		   if(x) {
			   
			  
			  req.setAttribute("message", "<h3 id="+"s"+">sucessfully data inserted</h3>");
		   }
		   else {
			   req.setAttribute("message", "<h4 id="+"f"+">email / phone is already exist</h4>");
			   }
			   RequestDispatcher rdd= req.getRequestDispatcher("studentform.jsp");
			   rdd.forward(req, res);
		   
			
		  
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		
	}

	private void addstudent(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		try {
			res.sendRedirect("studentform.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void userlogin(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String email=req.getParameter("txtemail");
		
		String password=req.getParameter("txtpassword");
		
		lbean b=new lbean(email,password);
		
		regDao rd= new regDao();
		
  boolean	isinserted=	rd.check(b);
  
     if(isinserted==true) {
  	  
    	res.sendRedirect("home.jsp"); 
    	 
      }
     else {
    	 
    	 res.setContentType("text/html");
    	 req.setAttribute("message", "<h4> wrong email/password</h4>");
    	 RequestDispatcher rd1= req.getRequestDispatcher("login.jsp");
    	 
    	 rd1.forward(req, res);
    	 
     }
		

		
		
	}

	private void userregister(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
		
		    String name=req.getParameter("txtname");
			
			String email=req.getParameter("txtemail");
			
			String password=req.getParameter("txtpassword");
			
			lbean b= new lbean(name,email,password);
			
			regDao rd=new regDao();
			
			   boolean isinserted=rd.insert(b);  
			  
			   PrintWriter out;
			   
			try {
				out = res.getWriter();
				  res.setContentType("text/html");
				  if(isinserted) {
					   
					   res.sendRedirect("login.jsp");
					   
				   }
				   else {
					   out.println("<h1>email is already exist</h1>");
				   }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
			 
			   
			//imporant why know data stored but servlet handle request so directly lbean not sent data to regDao thats ehy created a object  
			
			
			   
			 
		
	}
	
	
	
}
