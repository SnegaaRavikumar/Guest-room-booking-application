package pac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminlogin
 */
@WebServlet("/adminlogin")
public class adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try
		{
		String name,phone,email,pass;
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3309/booking","root","");
		Statement stmt=con.createStatement();  
		email=request.getParameter("email");
		pass=request.getParameter("pass");
		ResultSet rs=stmt.executeQuery("select * from admindetails"); 
		while(rs.next())
		{
			if(email.compareTo(rs.getString(3))>0 && pass.compareTo(rs.getString(4))>0)
			{
				 ServletContext sc = getServletContext();
			        sc.getRequestDispatcher("/admin.html ").forward(request, response);
			}
		}
		}catch (Exception e)
		 {
		// TODO Auto-generated catch block
		 out.print(e.getMessage());
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
