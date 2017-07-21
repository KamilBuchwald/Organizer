<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pl">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Logowanies</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    

    <!-- Custom styles for this template -->
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/signin.css" />

   
  </head>

  <body>

    <div class="container">
    
   
      	
	
      <form method="POST" action="./main" class="form-signin">
        <h2 class="form-signin-heading">Zaloguj się</h2>
        <label for="inputEmail" class="sr-only">Login</label>
        <input type="text" id="login" name="login" class="form-control" placeholder="Login" required autofocus>
        <label for="inputPassword" class="sr-only">Hasło</label>
        <input type="password" id="pass" name="pass" class="form-control" placeholder="Hasło" required>
        
       
        <button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj</button>
        <div class="alert alert-danger">
        <strong>${requestScope.error} </strong>
        </div>
        
      </form>
      
      </br>
      <form class="form-signin" method="GET" action="./registry">
       		<button class="btn btn-lg btn-warning btn-bloc " type="submit">Zarejestruj się</button>
      </form>
      </br>
     
    
     
   
	
    </div> <!-- /container -->


    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" 
    crossorigin="anonymous"></script>
  </body>
</html>
