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

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/signin.css" />

  </head>

  <body>

    <div class="container">

      <form class="form-signin" method="POST" action="./valid">
        <h2 class="form-signin-heading">Zarejestruj się</h2>
        <label for="inputLogin" class="sr-only">Login</label>
        <input type="text" name="inLogin" id="inputLogin" class="form-control" placeholder="Login" required autofocus>
		<label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="pwd" class="form-control" placeholder="Hasło" required>
		<label for="inputPasswordCheck" class="sr-only">Password</label>
        <input type="password" id="inputPasswordCheck" name="passwordCheck" class="form-control" placeholder="Powtórz Hasło" required>
       
        <button class="btn btn-lg btn-warning btn-block" type="submit">Rejestracja</button>
      </form>
      <form class="form-signin" method="GET" action="./main">
       <button class="btn btn-lg btn-primary btn-block" type="submit">Wróc do logowania</button>
      </form>
      <h3>${requestScope.errorLogin}</h3>

    </div> <!-- /container -->


   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
   integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>
