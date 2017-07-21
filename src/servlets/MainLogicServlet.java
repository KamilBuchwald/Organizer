package servlets;

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

public class MainLogicServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		

		String name = (String)req.getAttribute("name");
		if(name==null){
		RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
		rd.forward(req,res);
		}else{
			RequestDispatcher rd = req.getRequestDispatcher("/hours");
			rd.forward(req,res);
		} 
		 
		
		
	} 
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
	 
		
		HttpSession session = req.getSession();
		String name = (String)session.getAttribute("name");
		PreparedStatement preparedStatement = null;
		String SQLstatement = "SELECT ID FROM users WHERE name = ?";
		
					try {
						Driver driv = new com.mysql.jdbc.Driver();
						DriverManager.registerDriver(driv);
						Connection conn = driv.connect("jdbc:mysql://localhost/organizer?user=root&amp;password=&characterEncoding=utf8", null);
						preparedStatement = conn.prepareStatement(SQLstatement);
						preparedStatement.setString(1, name);
						ResultSet zbior = preparedStatement.executeQuery();
						while(zbior.next()) {
							
							int Userid;
							Userid =zbior.getInt("id");
							session.setAttribute("id",Userid);
							RequestDispatcher rd = req.getRequestDispatcher("/earn");
							rd.forward(req,res);
							} 
				
							conn.close();
							
					
					}
					catch(SQLException e){
				
						System.out.println(e.getMessage());
					}
					
				
		
		
			
		} 
}

