package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.ServiceBean;

/**
 * Servlet implementation class ServiceRequest
 */
public class ServiceRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		/* HttpSession session1=request.getSession(false);
		  if(session1.getAttribute("user")==null){
		      response.sendRedirect("login.jsp");
		  }*/
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String title=request.getParameter("title");
		String accountid=request.getParameter("aid");
		String contactid=request.getParameter("cid");
		String status=request.getParameter("status");
	
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Timestamp opendate=timestamp;
		Timestamp closedate = null;
		
		String desc=request.getParameter("desc");
		ServiceBean ob=new ServiceBean();
		ob.setTitle(title);
        ob.setAccountid(accountid);	
        ob.setContactid(contactid);
        ob.setStatus(status);
        ob.setOpendate(opendate);
        ob.setClosedate(closedate);
       ob.setDescription(desc);
      
       try {
    	   
			UserDao ud=new UserDao();
			
			if(ud.insertService(ob))
				
			request.setAttribute("aid",accountid);
			//request.setAttribute("cid",contactid);
			
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response); 

			
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
			out.print("<a href=ContactServlet>Click here to register again</a>");
			
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
