<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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

    
    <link rel="stylesheet" type="text/css" href="dashboard.css" />

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
      
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Twoj zarobek w wybranej walucie:</h1>
          </br>
          </br>
		  
		   <div class="row placeholders">
            <div class="col-xs-6 col-sm-6 placeholder">
              
	 <h1> ${requestScope.CalculateValue} ${requestScope.CurrencyValue} </h1>
     </div>
		</div>
		</br>
		</br>
		</br>
		</br>
            <form class="form-signin" method="GET" action="./earn">
       		<button class="btn btn-lg btn-primary btn-block" type="submit">Wróc do menu</button>
      		</form>
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