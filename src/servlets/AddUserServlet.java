package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddUserServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		

		HttpSession session = req.getSession();
		if(session.getAttribute("id")==null){
			RequestDispatcher rd = req.getRequestDispatcher("/main");
			rd.forward(req,res);
		}
		else{
			RequestDispatcher rd = req.getRequestDispatcher("/earn");
			rd.forward(req,res);
		}
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		String login = req.getParameter("inLogin"); 
		String password  = req.getParameter("pwd");
		
		
		PreparedStatement preparedStatement = null;
		String SQLstatement = "INSERT INTO users (name, password,Rate,currency) VALUES (?,?,8.50,'PLN')";
		
					try {
						Driver driv = new com.mysql.jdbc.Driver();
						DriverManager.registerDriver(driv);
						Connection conn = driv.connect("jdbc:mysql://localhost/organizer?user=root&amp;password=&characterEncoding=utf8", null);
						preparedStatement = conn.prepareStatement(SQLstatement);
						preparedStatement.setString(1, login);
						preparedStatement.setString(2, password);
						preparedStatement.executeUpdate();
						
						RequestDispatcher rd = req.getRequestDispatcher("/added.jsp");
						rd.forward(req,res);
					
								
						
						}
						catch(SQLException e){
							System.out.println(e.getMessage());
					
						} 
		}

}
