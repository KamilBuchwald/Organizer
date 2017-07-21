  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pl">
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
  

      <nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="container-fluid  navbar-form navbar-right">
				
				<form class="form-inline" method="GET" action="./logout">
       			 <button class="btn btn-warning" type="submit">Wyloguj</button>
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
            <li><a href="./earn">Menu <span class="sr-only">(current)</span></a></li>
            <li class="active"><a href="./day">Ustawienia</a></li>
            
          </ul>
          
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Ustawienia:</h1>
		  
		   <div class="row placeholders">
            <div class="col-xs-6 col-sm-6 placeholder">
              
	<form method="POST" action="./set" novalidate>
    
      <label for="sel1"><h3>Ustaw walute na jaka chcesz przeliczyc zarobek</h3></label>
	  <input list="browsers" class="form-control"  name="currency" placeholder="PLN" >
	  <datalist id="browsers">
      <select class="form-control" id="sel1">
        <option value="PLN">PLN</option>
        <option value="USD">USD</option>
        <option value="CHF">CHF</option>
        <option value="GBP">GBP</option>
       	<option value="UAH">UAH</option>      
      </select>
	  </datalist>
	  </br>
	  <button class="btn btn-lg btn-info btn-block" type="submit">Ustaw</button>
	  </input>
	  </form>
      <br>
	  </br>
	  </br>
	  </br>
	  <form method="POST" action="./set" novalidate>
	  <h3 class="title">Ustaw stawke godzinowa  </h3>
	  <label for="inputRate" class="sr-only"></label>
        <input type="number" min="1" step="0.01" id="inputRate" name="inRate" class="form-control" placeholder="Stawka godzinowa:" required>
        </br>
        <button class="btn btn-lg btn-info btn-block" type="submit">Ustaw</button>
        </form>  
       
  
     </div>

		</div>
            
          </div>
			</br>
          
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