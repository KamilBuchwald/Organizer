package servlets;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		HttpSession session = req.getSession();
		if(session.getAttribute("id")!=null){
		RequestDispatcher rd = req.getRequestDispatcher("/earn");
		rd.forward(req,res);
		}else{
			RequestDispatcher rd = req.getRequestDispatcher("/registry.jsp");
			rd.forward(req,res);
		} 
		
	} 
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
	
		String login = req.getParameter("inLogin"); 
		String pass  = req.getParameter("pwd");
		String passCheck  = req.getParameter("passwordCheck");
		
		PreparedStatement preparedStatement = null;
		String SQLstatement = "SELECT name FROM users WHERE name = ?";
		
					try {
						Driver driv = new com.mysql.jdbc.Driver();
						DriverManager.registerDriver(driv);
						Connection conn = driv.connect("jdbc:mysql://localhost/organizer?user=root&amp;password=&characterEncoding=utf8", null);
						preparedStatement = conn.prepareStatement(SQLstatement);
						preparedStatement.setString(1, login);
						
						
							ResultSet zbior = preparedStatement.executeQuery();
							while(zbior.next()) {
						
								String id = null;
								id = zbior.getString("name");
								if(id!=null) {
								String ErrorLogin ="Uzytkownik o podanym loginie już istnieje";
								req.setAttribute("errorLogin", ErrorLogin);
								RequestDispatcher rd = req.getRequestDispatcher("/registry.jsp");
								rd.forward(req,res);
								}
					
								conn.close();
						
							}
					}
					
						catch(SQLException e){
							
					
					
						} 
					if(pass.equals(passCheck)){
						
						RequestDispatcher rd = req.getRequestDispatcher("/add");
						rd.forward(req,res);
					
						}else {
							String ErrorLogin ="Podane Hasla nie są takie same";
							req.setAttribute("errorLogin", ErrorLogin);
							RequestDispatcher rd = req.getRequestDispatcher("/registry.jsp");
							rd.forward(req,res);
						}
				
	}
}
					
		
	
		
		
		
	





