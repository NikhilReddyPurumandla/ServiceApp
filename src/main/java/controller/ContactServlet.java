package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDao;
import model.ContactBean;


/**
 * Servlet implementation class ContactServlet
 */
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
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
		response.setHeader("Cache-Control","no-cache");
		  response.setHeader("Cache-Control","no-store");
		  response.setHeader("Pragma","no-cache");
		  response.setDateHeader ("Expires", 0);
	
		/*  HttpSession session1=request.getSession(false);
		  if(session1.getAttribute("user")==null){
		      response.sendRedirect("login.jsp");
		  }*/
		String accountId=request.getParameter("aid");
		String lname=request.getParameter("lname");
		String fname=request.getParameter("fname");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
	
		ContactBean ob=new ContactBean();
		
		ob.setAccountId(accountId);
	
		ob.setLname(lname);
		ob.setFname(fname);
		ob.setPhone(phone);
		ob.setEmail(email);
		try {
			 
Connection con = util.DbConnection.getConnection();
        	
           PreparedStatement ps = con.prepareStatement("insert into Contact values(?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,ob.getContactId());
            ps.setString(2,ob.getAccountId());
            ps.setString(3,ob.getLname());
            ps.setString(4,ob.getFname());
            ps.setString(5,ob.getPhone());
            ps.setString(6,ob.getEmail());
   
            int a = ps.executeUpdate();
            int generatedkey=0;
            //int a = ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
               generatedkey=rs.getInt(1);   
                       System.out.println("Auto Generated Primary Key " + generatedkey);
                      
            }
            if(a!=0) {
			out.println("<html><head><meta charset=UTF-8");
			out.println("</head>");
			out.println("<body background=https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSE8z9A8rc2btClO0QKpSWmS-TZnlMZuSTz9KS5g2WNt5VWnc87>");
			out.println("<form action='ServiceRequestServlet' method='post'>");
			out.println("<h2>Request Details</h2>");
			out.println("<br><h3> Title</h3>");
			out.println("<br><input class=box type=text name=title placeholder=Title>");
			out.println("<br><h3>Account Id</h3>");
            out.println("<br><input class=box type=text name=aid placeholder=Account Id value="+accountId);
			out.println("<br><h3>Contact Id</h3>");
		    out.println("<br><input class=box type=text name=cid placeholder=Contact Id  value="+generatedkey);
	
			out.println("<br><h3>Status</h3>");

			out.println("<br><select name=status>");

			out.println("<option value=Request recieved>Request recieved</option>");

			out.println("<option value=Request verified>Request verified</option>");

			out.println("<option value=Service provided>Service provided</option>");
			out.println("</select>");
			out.println("<h3>Description</h3>");
			out.println("<br><input class=box type=text name=desc placeholder=Description>");
			out.println("</div>");
			out.println("<br><input type='submit' value='save'>");
			out.println("</form></center></body></html>");
            }
			
		
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
