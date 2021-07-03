package pac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleterooms
 */
@WebServlet("/deleterooms")
public class deleterooms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleterooms() {
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
		int rno=Integer.parseInt(request.getParameter("rno")); 
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3309/booking","root", "");
		 Statement stmt=con.createStatement();  
		 int rs=stmt.executeUpdate("delete from addrooms where roomno='"+rno+"'");  
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<style>");
		 out.println(".border1{");
        out.println("height: 45px;");
        out.println("width: 90.9%;");
        out.println("background-color: black;");
        out.println("padding: 20px 20px 10px 120px;");
        out.println("position: absolute;}");
        out.println("border2{");
        out.println("height: 45px;");
        out.println("width: 90.9%;");
        out.println("background-color:#2CC185");
        out.println("padding: 20px 20px 10px 120px;");
        out.println("position: absolute;}");
        out.println("header{");
        out.println("font-family: 'Satisfy', cursive;");
        out.println("font-size: 35px;");
        out.println("letter-spacing: 2px;");
        out.println("color: white;}");
        out.println("table,th,td{");
        out.println("border:1px solid black;}");
        out.println("table {");
        out.println("border-collapse: collapse;}");
        out.println("td {");
        out.println("padding: 10px;}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=border1><header><b>BookingRooms.com");
        out.println("<br><br><br><br><br><br><br><br><br><br>");
        out.println("<h3>The respective room is deleted");
		  
	}
		catch(Exception e)
				{
					System.out.println(e);
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
