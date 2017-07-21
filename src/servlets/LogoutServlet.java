package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		HttpSession session = req.getSession();
		if(session.getAttribute("id")!=null){
			
			if (session != null) {
			    session.invalidate();
			    RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.forward(req,res);
			}
			
		}else{
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req,res);
		} 
		 
		
		
	} 
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		RequestDispatcher rd = req.getRequestDispatcher("/log");
		rd.forward(req,res); 
		
		
		
		
			
		} 
}



