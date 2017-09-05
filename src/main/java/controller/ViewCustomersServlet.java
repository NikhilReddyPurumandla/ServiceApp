package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDao;
import model.AccountBean;



/**
 * Servlet implementation class ViewServlet
 */
public class ViewCustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCustomersServlet() {
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
        AccountBean ab=new AccountBean();
       
        try {
			UserDao ud = new UserDao();
			  ResultSet rs = ud.selectCustomer(ab);
			HttpSession hs= request.getSession(false);
           
        out.print("<html>");
        
        out.print("<head>");
        out.print("<body background=https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGp25MOfvTKpR18RKfSx7vbF4A3HayFaPrEBatJCZi5skpdR9FSQ>");
        out.print("<style>\n" + 
        		".navbar\n" + 
        		"{\n" + 
        		"width:100%; background-color:skyblue; height:55px;\n" + 
        		"}\n" + 
        		".dropbtn {\n" + 
        		"    background-color:grey;\n" + 
        		"    color: white;\n" + 
        		"    padding: 16px;\n" + 
        		"    font-size: 16px;\n" + 
        		"}\n" + 
        		"body{\n" + 
        		"background-repeat:repeat;\n" + 
        		"\n" + 
        		"background-size:100%;\n" + 
        		"}"+
        		"</style>\n" + 
        		"<div class=\"navbar\"> \n" + 
        		"<a href=\"index.jsp\"><button class=\"dropbtn\">Home</button></a>\n" + 
         
        		"<a href=AddCustomer.jsp ><button class=\"dropbtn\">Add Customers</button></a>"+
        	
        		"<a href=\"ViewServiceServlet\"><button class=\"dropbtn\">view Service</button></a>\n"  + 
        		"</div>");
        out.print("<table width=25% border=1>");
        out.print("<center><h1>Result:</h1></center>");
      
        out.println("<tr><td> ID </td> <td>Name</td> <td>HouseNo</td><td>Street</td><td>City</td><td>State</td><td>Zipcode</td><td>Role</td><td>Email</td>");
        while(rs.next())
           {
           out.print("<tr>");
           
           out.print("<tr>");
           out.print("<td>"+rs.getString(1)+"</td>");
          
           out.print("<td>"+rs.getString(2)+"</td>");
         
           out.print("<td>"+rs.getString(3)+"</td>");
           
           out.print("<td>"+rs.getString(4)+"</td>");   
    
           out.print("<td>"+rs.getString(5)+"</td>");  
        
           out.print("<td>"+rs.getString(6)+"</td>");  
           
           out.print("<td>"+rs.getString(7)+"</td>");  

           out.print("<td>"+rs.getString(8)+"</td>");  
         
           out.print("<td>"+rs.getString(9)+"</td>"); 
           
           out.println("<td> <a href='CustomerEditServlet?id="+rs.getString(1)+"'>edit</a></td>");
        
           out.print("</tr>");

        }

        out.print("</table>");
        out.print("</body>");
        
        out.print("</html>");
  

        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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