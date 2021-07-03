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
 * Servlet implementation class booking
 */
@WebServlet("/booking")
public class booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public booking() {
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
	//getting the inputs from the client side 
		String fname,address,email,arrival,dept,adhar,phone;
		int rno,nights,persons,count=0;
		rno=Integer.parseInt(request.getParameter("rno"));
		fname=request.getParameter("fname");
		address=request.getParameter("address");
		email=request.getParameter("email");
	    arrival=request.getParameter("arrival_day").trim()+"-"+request.getParameter("arrival_month").trim()+"-"+request.getParameter("arrival_year").trim();
	    dept=request.getParameter("dept_day").trim()+"-"+request.getParameter("dept_month").trim()+"-"+request.getParameter("dept_year").trim();
		nights=Integer.parseInt(request.getParameter("nights"));
		persons=Integer.parseInt(request.getParameter("persons"));
		adhar=request.getParameter("adhar");
		phone=request.getParameter("phone");
	//connection with the database
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3309/booking","root", "");
		 Statement stmt=con.createStatement();  
		 ResultSet rs=stmt.executeQuery("select * from booking"); 
		 while(rs.next())
		 {
	//checking whether rooms are already booked for particular dates
		 if(arrival.compareTo(rs.getString(7))==0 || dept.compareTo(rs.getString(8))==0)
			 {
				 Statement stm2=con.createStatement();  
				 ResultSet rs2=stmt.executeQuery("select * from booking"); 
					out.println("<html>");
					 out.println("<head>");
					 out.println("<style>");
					 out.println(".border1{");
                    out.println("height: 45px;");
                    out.println("width: 90.9%;");
                    out.println("background-color: black;");
                    out.println("padding: 20px 20px 10px 120px;");
                    out.println("position: absolute;top:0px;left:0px}");
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
                    out.println("<div class=border1><header><b>BookingRooms.com</div>");
                    out.println("<div class=border2></div>");
                    
                    out.println("<br><br><br><br>");
                    out.println("<h3>Your dates are already booked please select other dates");
                    out.println("<h3>Already booked dates are:");
                    out.println("<table>");
                    while(rs2.next())
    				{
    					
                    if(rs2.getString(7)==rs2.getString(8))
                    {
                    out.println("<tr><td>");
                    out.println(rs.getString(7));
                    out.println("</td></tr>");
                    }
                    else
                    {
                    	out.println("<tr><td>");
                        out.println(rs2.getString(7));
                        out.println("</td>");
                        out.println("<td>");
                        out.println(rs2.getString(8));
                        out.println("</td></tr>");
                        
                    }
				}
				count=1;
				break;
			 }
		//checking whether booking rooms satisfy the maximum stay days
		 else if((rno==1 && nights>30) || (rno==2 && nights>30))
		 {
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
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=border1><header><b>BookingRooms.com</header></div>");
            out.println("<br><br><br><br><br><br><br><br><br>");
           
            out.println("<h2>Your stay is restricted only to maximum of 30 days,so please book accordingly</h3>");
            count=1;
            break;
		 }
		 else if((rno==3 &&  nights>14)|| (rno==4 &&  nights>14) || (rno==5 && nights>14))
		 {
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
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=border1><header><b>BookingRooms.com");
            out.println("<br><br><br>");
            out.println("<h3>Your stay is restricted only to maximum of 14 days,so please book accordingly");
            count=1;
            break;
		 }
		 }
		//After fullfilling all constraints the data are put it into an database
		 if(count==0)
		 {
			 
			 Statement stmt1=con.createStatement();  
			 int rs1=stmt1.executeUpdate("insert into booking(roomno,fullname,address,email,phonenumber,adharnumber,arrival,departure,no_of_persons,no_of_nights)values('"+rno+"','"+fname+"','"+address+"','"+email+"','"+phone+"','"+adhar+"','"+arrival+"','"+dept+"','"+persons+"','"+nights+"')");
			 ServletContext sc = getServletContext();
	         sc.getRequestDispatcher("/success.html").forward(request, response);
		 }
		}
	catch (Exception e)
		 {
		// TODO Auto-generated catch block
		out.println("error");
		 out.print(e.getMessage());
	}}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
