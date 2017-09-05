package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountBean;
import model.ServiceBean;

/**
 * Servlet implementation class ServiceEditServlet
 */
public class ServiceEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceEditServlet() {
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
		ServiceBean st= DAO.UserDao.getServiceDetails(id);
        out.println("<html>");
	    out.println("<head>");
	    out.println("<body>");
        out.print("<form action='ServiceEditServlet2' method='get'>");  
       
 	    out.println("<center><h1>Welcome "+id+"</h1></center><br/>");
        out.print("<table>"); 
        out.print("<tr><td>Service id:</td><td><input type='text' name='id' value='"+st.getId()+"'/></td></tr>");  
        out.print("<tr><td>Title:</td><td><input type='text' name='title' value='"+st.getTitle()+"'/></td></tr>");
        out.print("<tr><td>Account id:</td><td><input type='text' name='aid' value='"+st.getAccountid()+"'/></td></tr>");  
        out.print("<tr><td>Contact id:</td><td><input type='text' name='cid' value='"+st.getContactid()+"'/></td></tr>");  
        out.print("<tr><td>Status:</td><td><input type='text' name='status' value='"+st.getStatus()+"'/></td></tr>");  
        out.print("<tr><td>Open date:</td><td><input type='text' name='odate' value='"+st.getOpendate()+"'/></td></tr>"); 
      
        out.print("<tr><td>Close Date</td><td><input type='text' name='cdate' value='"+st.getClosedate()+"'/></td></tr>"); 
        
        out.print("<tr><td>Description:</td><td><input type='text' name='desc' value='"+st.getDescription()+"'/></td></tr>");
       
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
