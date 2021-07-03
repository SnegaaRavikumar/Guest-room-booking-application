package pac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addrooms
 */
@WebServlet("/addrooms")
public class addrooms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addrooms() {
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
		int rno,beds,min,max;
		String fsize,ac,facility,rent;
	// Connecting with the mysql driver
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3309/booking","root","");
		Statement st=con.createStatement();
	//Getting input from the clients
		rno=Integer.parseInt(request.getParameter("rno"));
		fsize=request.getParameter("fsize");
		beds=Integer.parseInt(request.getParameter("beds"));
		min=Integer.parseInt(request.getParameter("min"));
		max=Integer.parseInt(request.getParameter("max"));
		ac=request.getParameter("ac");
		rent=request.getParameter("rent");
		facility=request.getParameter("facility");
	//Inserting the data into the database
	    int rs=st.executeUpdate("insert into addrooms(roomno,floorsize,nobeds,AC,rent,minimum,maximum,facility)values('"+rno+"','"+fsize+"','"+beds+"','"+ac+"','"+rent+"','"+min+"','"+max+"','"+facility+"')");
		
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
