package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		

		HttpSession session = req.getSession();
		if(session.getAttribute("id")!=null){
		RequestDispatcher rd = req.getRequestDispatcher("/earn");
		rd.forward(req,res);
		}else{
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req,res);
		} 
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		
		
		String login = req.getParameter("login"); 
		String pass  = req.getParameter("pass");
		PreparedStatement preparedStatement = null;
		String SQLstatement = "SELECT name FROM users WHERE name = ? AND password = ?";
		
					try {
						Driver driv = new com.mysql.jdbc.Driver();
						DriverManager.registerDriver(driv);
						Connection conn = driv.connect("jdbc:mysql://localhost/organizer?user=root&amp;password=&characterEncoding=utf8", null);
						preparedStatement = conn.prepareStatement(SQLstatement);
						preparedStatement.setString(1, login);
						preparedStatement.setString(2, pass);
						
							ResultSet zbior = preparedStatement.executeQuery();
							while(zbior.next()) {
						
								String name = null;
								name = zbior.getString("name");
								HttpSession session = req.getSession();
								session.setAttribute("name",name);
								RequestDispatcher rd = req.getRequestDispatcher("/logic");
								rd.forward(req,res);
								} 
							
					
								conn.close();
						
						}
						catch(SQLException e){
					
							System.out.println(e.getMessage());
							
						}
					String error = null;
					error = "Bledne login lub haslo";
					req.setAttribute("error", error);
					RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
					rd.forward(req,res); 
		
		
	 
			
		}
		
	}

