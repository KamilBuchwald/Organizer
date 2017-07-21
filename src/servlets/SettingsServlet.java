package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SettingsServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		HttpSession session = req.getSession();
		if(session.getAttribute("id")!=null){
		RequestDispatcher rd = req.getRequestDispatcher("/settings.jsp");
		rd.forward(req,res);
		}else{
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req,res);
		} 
		 
		
		
	} 
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		
		PreparedStatement preparedStatement = null;
		String currency = null;
		HttpSession session = req.getSession();
		int id = (int)session.getAttribute("id");
		currency = req.getParameter("currency");
		String SQLstatement = "UPDATE users SET currency= ? WHERE id = ?";
		
					try {
						Driver driv = new com.mysql.jdbc.Driver();
						DriverManager.registerDriver(driv);
						Connection conn = driv.connect("jdbc:mysql://localhost/organizer?user=root&amp;password=&characterEncoding=utf8", null);
						preparedStatement = conn.prepareStatement(SQLstatement);
						preparedStatement.setString(1, currency);
						preparedStatement.setInt(2, id);
						preparedStatement.executeUpdate();
						
						RequestDispatcher rd = req.getRequestDispatcher("/earn");
						rd.forward(req,res);
					
								
						
						}
						catch(SQLException e){
							System.out.println(e.getMessage());
					
						} 
		
		
		
		
			
		} 

}
