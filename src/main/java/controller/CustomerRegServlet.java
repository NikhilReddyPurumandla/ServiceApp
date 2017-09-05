package controller;

import java.io.IOException;
import util.DbConnection;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDao;
import model.AccountBean;


import java.sql.*;
/**
 * Servlet implementation class SignupServlet
 */
public class CustomerRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		response.setHeader("Cache-Control","no-cache");
		  response.setHeader("Cache-Control","no-store");
		  response.setHeader("Pragma","no-cache");
		  response.setDateHeader ("Expires", 0);
	
		/*  HttpSession session1=request.getSession(false);
		  if(session1.getAttribute("user")==null){
		      response.sendRedirect("login.jsp");
		  }*/

		
		String Name=request.getParameter("name");
		String houseNo=request.getParameter("hno");
		String street=request.getParameter("street");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String  zipCode=request.getParameter("zipcode");
		String email=request.getParameter("email");
		AccountBean ob=new AccountBean();
		ob.setName(Name);
		ob.setHouseNo(houseNo);
		ob.setStreet(street);
		ob.setCity(city);
		ob.setState(state);
		ob.setZipCode(zipCode);
		ob.setRole("USER");
		ob.setEmail(email);


		try {

        	con = util.DbConnection.getConnection();
          PreparedStatement  ps = con.prepareStatement("insert into Account values(?,?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,ob.getId());
            ps.setString(2,ob.getName());
            ps.setString(3,ob.getHouseNo());
            ps.setString(4,ob.getStreet());
            ps.setString(5,ob.getCity());
            ps.setString(6,ob.getState());
            ps.setString(7,ob.getZipCode());
            ps.setString(8,ob.getRole());
            ps.setString(9, ob.getEmail());
          
           
            int generatedkey=0;
            int a = ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
               generatedkey=rs.getInt(1);   
                       System.out.println("Auto Generated Primary Key " + generatedkey);
                      
            }
			if(a!=0)
				 
				   out.println("<!DOCTYPE html>");
		    out.println("<html>");
		    out.println("<head>");
		    out.println("<title>Success</title>");
		    out.println("<body>");

		    out.println("<legend align='center'>Success</legend><br/>");
		
		    out.println("<h1>Enter Customer Contact details!</h1>");
		    
		    
		    
		       out.print("<form action='ContactServlet' method='post'>");  
		        out.print("<table>"+ 
		        
		    	"<div class=\"navbar\"> \n" + 
        		"<a href=\"index.jsp\"><button class=\"dropbtn\">Home</button></a>\n" + 
        		"<a href=\"ViewCustomerServlet\"><button class=\"dropbtn\">View Customers</button></a>\n" + 
        		"<a href=AddCustomer.jsp ><button class=\"dropbtn\">Add Customers</button></a>"+
        		"<a href=\"ContactServlet\"><button class=\"dropbtn\">add service request</button></a>"+
        		"<a href=\"ViewServiceServlet\"><button class=\"dropbtn\">view customers</button></a>\n" );  
		        out.print("<tr><td>Account id:</td><td><input type='text' name='aid' value='"+generatedkey+"'/></td></tr>");  
		        out.print("<tr><td>Last Name:</td><td><input type='text' name='lname'/></td></tr>");  
		        out.print("<tr><td>First Name:</td><td><input type='text' name='fname'/></td></tr>");  
		        out.print("<tr><td>Phone:</td><td><input type='text' name='phone' /></td></tr>");  
		        out.print("<tr><td>Email:</td><td><input type='text' name='email'/></td></tr>");  
		        out.print("<tr><td colspan='2'><input type='submit' value='save'></td></tr>");  
		        out.print("</table>");  
		        out.print("</form>");  
		    out.println("</body>");
		    out.println("</html>"); 
			// RequestDispatcher rd=request.getRequestDispatcher("ServiceRequest.jsp");
			//rd.forward(request, response); 
		
		
	}
		catch(Exception e) {
			 
			System.out.println(e);
			System.out.println("failed to store details!!! \n try again");
			
			/*RequestDispatcher rd=request.getRequestDispatcher("Signup.html");
			rd.forward(request, response);
			
*/
			out.print("<head>");
			out.print("<body>");
			out.print("<h5>Failed to store data</h5>");
			out.print("<a href=AddCustomer.jsp>Click here to register again</a>");
			out.print("<br><br><a href=index.jsp>go to home page</a>");
			out.print("</body>");
			out.print("</html>");
		}
	}

}
