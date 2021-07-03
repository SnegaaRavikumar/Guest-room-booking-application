package pac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class usersigup
 */
@WebServlet("/usersigup")
public class usersigup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usersigup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try
		{
		String name,phone,email,pass;
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3309/booking","root","");
		Statement st=con.createStatement();
		name=request.getParameter("name");
		phone=request.getParameter("phone");
		email=request.getParameter("email");
		pass=request.getParameter("pass");
	    int rs=st.executeUpdate("insert into userdetails(u_name,u_phone,u_mail,u_pass)values('"+name+"','"+phone+"','"+email+"','"+pass+"')");
	    ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/login.html").forward(request, response);
	}
		catch (Exception e)
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
