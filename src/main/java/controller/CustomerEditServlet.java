package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountBean;
import DAO.UserDao;

/**
 * Servlet implementation class EditServlet
 */
public class CustomerEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerEditServlet() {
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
        out.println("<h1>Update </h1>");  
       
        String id=request.getParameter("id"); 
        try{ 
        	HttpSession hs= request.getSession(false);
      
        System.out.println("id is"+id);
		AccountBean st= DAO.UserDao.getDetails(id);
        out.println("<html>");
	    out.println("<head>");
	    out.println("<body>");
        out.print("<form action='CustomerEditServlet2' method='get'>");  
       
 	    out.println("<center><h1>Welcome "+id+"</h1></center><br/>");
        out.print("<table>"); 
        out.print("<tr><td>Account id:</td><td><input type='text' name='aid' value='"+st.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+st.getName()+"'/></td></tr>");  
        out.print("<tr><td>HouseNo:</td><td><input type='text' name='hno' value='"+st.getHouseNo()+"'/></td></tr>");  
        out.print("<tr><td>Street:</td><td><input type='text' name='street' value='"+st.getStreet()+"'/></td></tr>");  
        out.print("<tr><td>City:</td><td><input type='text' name='city' value='"+st.getCity()+"'/></td></tr>");  
        out.print("<tr><td>State</td><td><input type='text' name='state' value='"+st.getState()+"'/></td></tr>");  
        out.print("<tr><td>Zipcode:</td><td><input type='text' name='zipcode' value='"+st.getZipCode()+"'/></td></tr>");
        out.print("<tr><td>Role:</td><td><input type='text' name='role' value='"+st.getRole()+"'/></td></tr>");
        out.print("<tr><td>Email:</td><td><input type='text' name='email' value='"+st.getEmail()+"'/></td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='save'></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
	    out.println("</body>");
	    out.println("</html>");
        }
        catch (NullPointerException e) {
        	//System.out.println("hiee");
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