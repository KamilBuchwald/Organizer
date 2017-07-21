package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DayAddServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		HttpSession session = req.getSession();
		if(session.getAttribute("id")==null){
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req,res);
		}else{
		RequestDispatcher rd = req.getRequestDispatcher("/dayadd.jsp");
		rd.forward(req,res);
		}
		}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		//int id = 8;
		String Date = req.getParameter("inDate"); 
		String StartHour  = req.getParameter("inStartHour");
		String StartMin  = req.getParameter("inStartMin");
		String StopHour  = req.getParameter("inStopHour");
		String StopMin  = req.getParameter("inStopMin");
		String Hours = req.getParameter("inHours");
		String Description  = req.getParameter("inDescription");
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("id");
		
		
		PreparedStatement preparedStatement = null;
		String SQLstatement = "INSERT INTO posts (UserID, Date, StartHour,StartMin, StopHour, StopMin,Hours,Description) VALUES (?,?,?,?,?,?,?,?)";
		
					try {
						Driver driv = new com.mysql.jdbc.Driver();
						DriverManager.registerDriver(driv);
						Connection conn = driv.connect("jdbc:mysql://localhost/organizer?user=root&amp;password=&characterEncoding=utf8", null);
						preparedStatement = conn.prepareStatement(SQLstatement);
						preparedStatement.setInt(1, id);
						preparedStatement.setDate(2, java.sql.Date.valueOf(Date));
						preparedStatement.setString(3, StartHour);
						preparedStatement.setString(4, StartMin);
						preparedStatement.setString(5, StopHour);
						preparedStatement.setString(6, StopMin);
						preparedStatement.setString(7, Hours);
						preparedStatement.setString(8, Description);
						
						preparedStatement.executeUpdate();
						
						RequestDispatcher rd = req.getRequestDispatcher("/added.jsp");
						rd.forward(req,res);
					
								
						
						}
						catch(SQLException e){
							System.out.println(e.getMessage());
					
						} 
	
		}

}
