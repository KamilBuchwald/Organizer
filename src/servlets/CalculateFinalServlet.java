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

public class CalculateFinalServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		
		
		HttpSession session = req.getSession();
		if(session.getAttribute("id")!=null){
			
			if(req.getAttribute("Rate")!=null){
	
		PreparedStatement preparedStatement = null;
		String SQLstatement = "SELECT SUM(Hours) as Suma FROM posts WHERE UserID = ?";
		
					try {
						Driver driv = new com.mysql.jdbc.Driver();
						DriverManager.registerDriver(driv);
						Connection conn = driv.connect("jdbc:mysql://localhost/organizer?user=root&amp;password=&characterEncoding=utf8", null);
						int UserID = (int)session.getAttribute("id");
						double Rate = (double)req.getAttribute("Rate");
						preparedStatement = conn.prepareStatement(SQLstatement);
						preparedStatement.setInt(1, UserID);
						ResultSet zbior = preparedStatement.executeQuery();
						while(zbior.next()) {
							
							int Suma;
							Suma =zbior.getInt("Suma");
							double sum = Suma*Rate;
							req.setAttribute("sum", sum);
							RequestDispatcher rd = req.getRequestDispatcher("/check");
							rd.forward(req,res);
							} 
				
							conn.close();
							
					
					}
					catch(SQLException e){
				
						System.out.println(e.getMessage());
					}
			}else{
				RequestDispatcher rd = req.getRequestDispatcher("/calc");
				rd.forward(req,res);
			}
		}else{
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req,res);
		} 
					
		
	
		
		
	} 
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		 
		
		
		
		PreparedStatement preparedStatement = null;
		String SQLstatement = "SELECT SUM(Hours) as Suma FROM posts WHERE UserID = ?";
		
					try {
						Driver driv = new com.mysql.jdbc.Driver();
						DriverManager.registerDriver(driv);
						Connection conn = driv.connect("jdbc:mysql://localhost/organizer?user=root&amp;password=&characterEncoding=utf8", null);
						HttpSession session = req.getSession();
						int UserID=(int)session.getAttribute("id");
						double Rate = (double)req.getAttribute("Rate");
						preparedStatement = conn.prepareStatement(SQLstatement);
						preparedStatement.setInt(1, UserID);
						ResultSet zbior = preparedStatement.executeQuery();
						while(zbior.next()) {
							
							int Suma;
							Suma =zbior.getInt("Suma");
							double sum = Rate*Suma;
							req.setAttribute("sum", sum);
							RequestDispatcher rd = req.getRequestDispatcher("/menu.jsp");
							rd.forward(req,res);
							} 
				
							conn.close();
							
					
					}
					catch(SQLException e){
				
						System.out.println(e.getMessage());
					}
		
					
								
		
		
			
		} 
}



