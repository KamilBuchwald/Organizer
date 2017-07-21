<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/dashboard.css" />

  </head>

  <body>
   <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/organizer"
        user="root" password=""
    />
     <sql:query var="postsr"   dataSource="${myDS}">
        SELECT * FROM posts WHERE UserID = ${sessionScope.id};
    </sql:query>

      <nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="container-fluid  navbar-form navbar-right">
				
				<form class="form-inline" method="GET" action="./logout">
       			 <button class="btn btn-warning " type="submit">Wyloguj</button>
     			 </form>
     			 
     			
				
			</div>
		</div>
    </nav>
    </br>
    </br>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="./hours">Menu <span class="sr-only">(current)</span></a></li>
            <li><a href="./set">Ustawienia</a></li>
            
          </ul>
          
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Twój zarobek: ${name}</h1>

          <div class="row placeholders">
            <div class="col-xs-6 col-sm-6 placeholder">
              <h1>${requestScope.sum} </h1>
              <span class="text-muted">EUR</span>
            </div>
            <div class="col-xs-6 col-sm-6 placeholder">
              <form class="form-inline" method="GET" action="./calc">
       			 <button class="btn btn-lg btn-danger" type="submit">Przelicz</button>
     			 </form>
            </div>
            
          </div>
          </br>
          </br>
           <form class="form-inline" method="GET" action="./day">
       			 <button class="btn btn-lg btn-primary" type="submit">Dodaj dzień+</button>
     			 </form>
			</br>
          <h2 class="sub-header">Przepracowane godziny:</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Data</th>
                  <th>Godzina rozpoczecia</th>
                  <th>Minuta rozpoczecia</th>
                  <th>Godzina zakończenia</th>
                  <th>Minuta zakończenia</th>
                  <th>Ilość godzin</th>
                  <th>Miejsce</th>
                </tr>
                
              </thead>
              <tbody>
              <c:forEach var="posts" items="${postsr.rows}">
                <tr>
                  <td><c:out value="${posts.Date}"/></td>
                  <td><c:out value="${posts.StartHour}"/></td>
                  <td><c:out value="${posts.StartMin}"/></td>
                  <td><c:out value="${posts.StopHour}"/></td>
                  <td><c:out value="${posts.StopMin}"/></td>
                  <td><c:out value="${posts.Hours}"/></td>
                  <td><c:out value="${posts.Description}"/></td>
                </tr>
                </c:forEach>
               
               
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
   integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" 
    crossorigin="anonymous"></script>
  </body>
</html>