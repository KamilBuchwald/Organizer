
package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class CurrencyCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		HttpSession session = req.getSession();
		if(session.getAttribute("id")!=null){
		
			if(req.getAttribute("sum")!=null){
				
			
		
		String Currency = null;
		PreparedStatement preparedStatement = null;
		String SQLstatement = "SELECT currency FROM users WHERE id = ?";
		
					try {
						Driver driv = new com.mysql.jdbc.Driver();
						DriverManager.registerDriver(driv);
						Connection conn = driv.connect("jdbc:mysql://localhost/organizer?user=root&amp;password=&characterEncoding=utf8", null);
						int UserID = (int)session.getAttribute("id");
						double sum = (double)req.getAttribute("sum");
						preparedStatement = conn.prepareStatement(SQLstatement);
						preparedStatement.setInt(1, UserID);
						ResultSet zbior = preparedStatement.executeQuery();
						while(zbior.next()) {
							
							
							Currency =zbior.getString("currency");
							} 
				
							conn.close();
							
				
				switch(Currency){
				
				case "PLN":
					
					String url = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
     				
     				URL obj = new URL(url);
     				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     				con.setRequestMethod("GET");
     				BufferedReader in = new BufferedReader(
     				        new InputStreamReader(con.getInputStream()));
     				String inputLine;
     				StringBuffer response = new StringBuffer();

     				while ((inputLine = in.readLine()) != null) {
     					response.append(inputLine);
     				}
     				in.close();

     				 try
     				    {
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(url).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         double Multipler = 0;
     				         double NewValue = 0;
     				         
     				        Multipler = kurs;
 				        	NewValue= sum*Multipler;
 				        	
     				       java.text.DecimalFormat df=new java.text.DecimalFormat();
     				      df.setMaximumFractionDigits(2);
     				      df.setMinimumFractionDigits(2);
     				      String NW = df.format(NewValue);
     				      
     				      req.setAttribute("CalculateValue", NW);
     				      req.setAttribute("CurrencyValue", Currency);
    	     				RequestDispatcher rd = req.getRequestDispatcher("/calculated.jsp");
    	     				 rd.forward(req,res); 
     				         
     				  
     				    }
     				        
     				   	 catch (Exception e)
     				   	    {
     				   	        e.printStackTrace();
     				   	    }
					
					
					break;
					
					
				
				case "USD":
					
String urlD = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=xml";
     				
     				URL objD = new URL(urlD);
     				HttpURLConnection conD = (HttpURLConnection) objD.openConnection();
     				conD.setRequestMethod("GET");
     				BufferedReader inD = new BufferedReader(
     				        new InputStreamReader(conD.getInputStream()));
     				String inputLineD;
     				StringBuffer responseD = new StringBuffer();

     				while ((inputLineD = inD.readLine()) != null) {
     					responseD.append(inputLineD);
     				}
     				inD.close();

     				 try
     				    {
     					String url2 = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
         				
         				URL obj2 = new URL(url2);
         				HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
         				con2.setRequestMethod("GET");
         				BufferedReader in2 = new BufferedReader(
         				        new InputStreamReader(con2.getInputStream()));
         				String inputLine2;
         				StringBuffer response2 = new StringBuffer();

         				while ((inputLine2 = in2.readLine()) != null) {
         					response2.append(inputLine2);
         				}
         				inD.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(url2).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(urlD).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	
     				        	 double Multipler = 0;
         				         double NewValue = 0;
         				         
         				        Multipler = KursPodst/kurs;
     				        	NewValue= sum*Multipler;
     				        	
         				       java.text.DecimalFormat df=new java.text.DecimalFormat();
         				      df.setMaximumFractionDigits(2);
         				      df.setMinimumFractionDigits(2);
         				      String NW = df.format(NewValue);
         				      
         				      req.setAttribute("CalculateValue", NW);
         				      req.setAttribute("CurrencyValue", Currency);
        	     				RequestDispatcher rd = req.getRequestDispatcher("/calculated.jsp");
        	     				 rd.forward(req,res); 
     				         
     				  
     				    }
     				        
     				   	 catch (Exception e)
     				   	    {
     				   	        e.printStackTrace();
     				   	    }
					
					break;
				
				
				case "CHF":
					
String urlC = "http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml";
     				
     				URL objC = new URL(urlC);
     				HttpURLConnection conC = (HttpURLConnection) objC.openConnection();
     				conC.setRequestMethod("GET");
     				BufferedReader inC = new BufferedReader(
     				        new InputStreamReader(conC.getInputStream()));
     				String inputLineC;
     				StringBuffer responseC = new StringBuffer();

     				while ((inputLineC = inC.readLine()) != null) {
     					responseC.append(inputLineC);
     				}
     				inC.close();

     				 try
     				    {
     					String url2 = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
         				
         				URL obj2 = new URL(url2);
         				HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
         				con2.setRequestMethod("GET");
         				BufferedReader in2 = new BufferedReader(
         				        new InputStreamReader(con2.getInputStream()));
         				String inputLine2;
         				StringBuffer response2 = new StringBuffer();

         				while ((inputLine2 = in2.readLine()) != null) {
         					response2.append(inputLine2);
         				}
         				inC.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(url2).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(urlC).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	
     				        	 double Multipler = 0;
         				         double NewValue = 0;
         				         
         				        Multipler = KursPodst/kurs;
     				        	NewValue= sum*Multipler;
     				        	
         				       java.text.DecimalFormat df=new java.text.DecimalFormat();
         				      df.setMaximumFractionDigits(2);
         				      df.setMinimumFractionDigits(2);
         				      String NW = df.format(NewValue);
         				      
         				      req.setAttribute("CalculateValue", NW);
         				      req.setAttribute("CurrencyValue", Currency);
        	     				RequestDispatcher rd = req.getRequestDispatcher("/calculated.jsp");
        	     				 rd.forward(req,res); 
     				         
     				  
     				    }
     				        
     				   	 catch (Exception e)
     				   	    {
     				   	        e.printStackTrace();
     				   	    }
					
					
					break;
					
				
				case "GBP":
					
String urlG = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=xml";
     				
     				URL objG = new URL(urlG);
     				HttpURLConnection conG = (HttpURLConnection) objG.openConnection();
     				conG.setRequestMethod("GET");
     				BufferedReader inG = new BufferedReader(
     				        new InputStreamReader(conG.getInputStream()));
     				String inputLineG;
     				StringBuffer responseG = new StringBuffer();

     				while ((inputLineG = inG.readLine()) != null) {
     					responseG.append(inputLineG);
     				}
     				inG.close();

     				 try
     				    {
     					String url2 = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
         				
         				URL obj2 = new URL(url2);
         				HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
         				con2.setRequestMethod("GET");
         				BufferedReader in2 = new BufferedReader(
         				        new InputStreamReader(con2.getInputStream()));
         				String inputLine2;
         				StringBuffer response2 = new StringBuffer();

         				while ((inputLine2 = in2.readLine()) != null) {
         					response2.append(inputLine2);
         				}
         				inG.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(url2).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(urlG).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	
     				        	 double Multipler = 0;
         				         double NewValue = 0;
         				         
         				        Multipler = KursPodst/kurs;
     				        	NewValue= sum*Multipler;
     				        	
         				       java.text.DecimalFormat df=new java.text.DecimalFormat();
         				      df.setMaximumFractionDigits(2);
         				      df.setMinimumFractionDigits(2);
         				      String NW = df.format(NewValue);
         				      
         				      req.setAttribute("CalculateValue", NW);
         				      req.setAttribute("CurrencyValue", Currency);
        	     				RequestDispatcher rd = req.getRequestDispatcher("/calculated.jsp");
        	     				 rd.forward(req,res); 
     				         
     				  
     				    }
     				        
     				   	 catch (Exception e)
     				   	    {
     				   	        e.printStackTrace();
     				   	    }
					
					
					break;
				
				
				case "UAH":
					
String urlU = "http://api.nbp.pl/api/exchangerates/rates/a/uah/?format=xml";
     				
     				URL objU = new URL(urlU);
     				HttpURLConnection conU = (HttpURLConnection) objU.openConnection();
     				conU.setRequestMethod("GET");
     				BufferedReader inU = new BufferedReader(
     				        new InputStreamReader(conU.getInputStream()));
     				String inputLineU;
     				StringBuffer responseU = new StringBuffer();

     				while ((inputLineU = inU.readLine()) != null) {
     					responseU.append(inputLineU);
     				}
     				inU.close();

     				 try
     				    {
     					String url2 = "http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=xml";
         				
         				URL obj2 = new URL(url2);
         				HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
         				con2.setRequestMethod("GET");
         				BufferedReader in2 = new BufferedReader(
         				        new InputStreamReader(con2.getInputStream()));
         				String inputLine2;
         				StringBuffer response2 = new StringBuffer();

         				while ((inputLine2 = in2.readLine()) != null) {
         					response2.append(inputLine2);
         				}
         				inU.close();
         				
         				DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
 				        DocumentBuilder db2 = dbf2.newDocumentBuilder();
 				        org.w3c.dom.Document doc2 = db2.parse(new URL(url2).openStream());

 				        doc2.getDocumentElement().normalize();
 				        
 				         String wartoscs2 = doc2.getDocumentElement().getLastChild().
 				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
 				         double KursPodst = Double.parseDouble(wartoscs2);
         				
     					 
     				        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     				        DocumentBuilder db = dbf.newDocumentBuilder();
     				        org.w3c.dom.Document doc = db.parse(new URL(urlU).openStream());

     				        doc.getDocumentElement().normalize();
     				        
     				         String wartoscs = doc.getDocumentElement().getLastChild().
     				                    getFirstChild().getFirstChild().getNextSibling().getNextSibling().getTextContent();
     				         double kurs = Double.parseDouble(wartoscs);
     				         
     				         
     				        
     				        	
     				        	 double Multipler = 0;
         				         double NewValue = 0;
         				         
         				        Multipler = KursPodst/kurs;
     				        	NewValue= sum*Multipler;
     				        	
         				       java.text.DecimalFormat df=new java.text.DecimalFormat();
         				      df.setMaximumFractionDigits(2);
         				      df.setMinimumFractionDigits(2);
         				      String NW = df.format(NewValue);
         				      
         				      req.setAttribute("CalculateValue", NW);
         				      req.setAttribute("CurrencyValue", Currency);
        	     				RequestDispatcher rd = req.getRequestDispatcher("/calculated.jsp");
        	     				 rd.forward(req,res); 
     				         
     				  
     				    }
     				        
     				   	 catch (Exception e)
     				   	    {
     				   	        e.printStackTrace();
     				   	    }
					
					
					break;
				}
						
		     
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
		
		 
			
		} 
}



