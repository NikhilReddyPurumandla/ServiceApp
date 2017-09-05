package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;
import model.ActivityBean;
import model.ServiceBean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class UpdateServiceServlet
 */
public class UpdateActivityServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateActivityServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String srid=request.getParameter("srid");
		String id=request.getParameter("userid");
	
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Timestamp updatedate=timestamp;
		String update=request.getParameter("update");
		ActivityBean ab=new ActivityBean();
		ab.setSrid(srid);
		ab.setUpdateddate(updatedate);
		ab.setUpdate(update);
		  try {
	    	   
				UserDao ud=new UserDao();
				
				if(ud.insertActivity(ab)) {
					System.out.println("updated");
					ServiceBean sb=new ServiceBean();
					Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
					Timestamp closedate=timestamp1;
					sb.setClosedate(closedate);
					sb.setId(srid);
		if(update.equals("closed")) {
			  int status;
		      
				try {
					   System.out.println("hello");
					status= UserDao.updateCloseDate(sb);
				   System.out.println("hiii");
				 
					if(status>0){  
			            response.sendRedirect("ViewServiceServlet");
			            out.println("<html>");
			            out.println("<body>");
			            out.println("<a href=ViewServiceServlet>failed to update status...try again</a>");
			            out.println("</body>");
			            out.println("</html>");
					}
				}
				catch(Exception e) {
			        	System.out.println(e);
			        }
		}
				RequestDispatcher rd=request.getRequestDispatcher("ViewServiceServlet");
				rd.forward(request, response);
		
				
			}
		  }
			catch(Exception e) {
				 
				System.out.println(e);
				System.out.println("failed to store details!!! \n try again");
				
	
				out.print("<head>");
				out.print("<body>");
				out.print("<h5>Failed to store data</h5>");
				out.print("<a href=ViewServiceServlet.jsp>Click here to add details again</a>");
				
				out.print("</body>");
				out.print("</html>");
			}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
