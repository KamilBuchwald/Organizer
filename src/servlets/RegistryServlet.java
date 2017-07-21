package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistryServlet extends HttpServlet {
	
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
	
	RequestDispatcher rd = req.getRequestDispatcher("/valid");
		rd.forward(req,res);
		}
}