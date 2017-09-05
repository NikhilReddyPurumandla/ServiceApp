package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;
import model.AccountBean;
import model.ServiceBean;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class ServiceEditServlet2
 */
public class ServiceEditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceEditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String id=request.getParameter("id");
        String title=request.getParameter("title");  
        String accountid=request.getParameter("aid");  
        String contactid=request.getParameter("cid");  
        String status1=request.getParameter("status");  
         String opendate=request.getParameter("odate");
        Timestamp closedate=timestamp; 
        String description=request.getParameter("desc"); 

          
        ServiceBean ab=new ServiceBean();
        ab.setId(id);
        ab.setTitle(title);  
        ab.setAccountid(accountid);  
        ab.setContactid(contactid);  
        ab.setStatus(status1);
        //ab.setOpendate(opendate);
        ab.setClosedate(closedate); 
        ab.setDescription(description);
       
     
        int status;
      
		try {
	
			status= UserDao.updateService(ab);
		   
		 
			if(status>0){  
	            response.sendRedirect("ViewServiceServlet");  
	        }else{  
	            out.println("Sorry! unable to update record");  
	        } 
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
