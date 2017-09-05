package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateActivityServlet1
 */
public class UpdateActivityServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateActivityServlet1() {
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
        String id=request.getParameter("userid");
        out.println("<h1>Update Activity status </h1>"); 
		out.println("<html><head><meta charset=UTF-8");
		out.println("</head>");
		out.println("<body background=https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSE8z9A8rc2btClO0QKpSWmS-TZnlMZuSTz9KS5g2WNt5VWnc87>");
		out.println("<form action='UpdateActivityServlet2' method='post'>");
		out.println("<h2>Request Details</h2>");
		out.println("<br><h3>Service Request Id</h3>");
		out.println("<br><input class=box type=text name='srid' placeholder=Title value="+id+">");
		

		out.println("<br><h3>Update</h3>");

		out.println("<br><select name='update'>");

		out.println("<option value=recieved>recieved</option>");

		out.println("<option value=closed>closed</option>");
		out.println("</select>");
		out.println("</div>");
		out.println("<br><input type='submit' value='save'>");
		out.println("</form></center></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
