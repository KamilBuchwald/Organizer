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

    <title>Dodaj dzień pracy</title>

    <!-- Bootstrap core CSS -->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" type="text/css" href="style/signin.css" />

  </head>

  <body>

    <div class="container">

      <form class="form-signin" method="POST" action="./day">
        <h2 class="form-signin-heading">Dodaj dzień:</h2>
        <label for="inputDate" class="sr-only"></label>
        <input type="date" name="inDate" id="inputDate" class="form-control" onblur="(this.type='text')" onfocus="(this.type='date')" placeholder="Podaj date:"  required autofocus>
		<p class="h4">Godzina rozpoczęcia pracy:</p>
		<div class="row">
		
		   <div class="col-lg-6">
			<div class="input-group">
				<span class="input-group-addon">
			  <label for="inputStartHour" class="sr-only">Dodaj godzine rozpoczęcia pracy:</label>
				<input type="number" id="inputStartHour" min="0" max="23" name="inStartHour" class="form-control " placeholder="HH (0-23) :" required>
				</span>
			</div>
		  </div>
		  <div class="col-lg-6">
			<div class="input-group">
			  <span class="input-group-addon">
			   <label for="inputStartMin" class="sr-only"> </label>
				<input type="number" id="inputStartMin" name="inStartMin" min="0" max="60" class="form-control"  placeholder="mm (0-60):" required>
			  </span>
			 
			</div>
		  </div>
		</div>
		<p class="h4">Godzina zakończenia pracy:</p>
		<div class="row">
		
		  <div class="col-lg-6">
			<div class="input-group">
				<span class="input-group-addon">
			  <label for="inputStopHour" class="sr-only">Dodaj godzine rozpoczęcia pracy:</label>
				<input type="number" id="inputStopHour" min="0" max="23" name="inStopHour" class="form-control " placeholder="HH (0-23) :" required>
				</span>
			</div>
		  </div>
		  <div class="col-lg-6">
			<div class="input-group">
			  <span class="input-group-addon">
			   <label for="inputStopMin" class="sr-only"> </label>
				<input type="number" id="inputStopMin" name="inStopMin" min="0" max="60" class="form-control"  placeholder="mm (0-60):" required>
			  </span>
			 
			</div>
		  </div>
		</div>
		
		<label for="inputHours" class="sr-only"></label>
        <input type="number" min="0" max="24" id="inputHours" name="inHours" class="form-control" placeholder="Przepracowane godziny:" required>
		
		<label for="comment"></label>
		<textarea class="form-control" rows="3" id="comment" name="inDescription" placeholder="Miejsce pracy"></textarea>
        </br>
        <button class="btn btn-lg btn-warning btn-block" type="submit">Dodaj</button>
       		 <p>*Stawka godzinowa wynosi 8.50 a domyślna waluta wymiany to PLN. 
       		 Możesz to zmienić w zakładce ustawienia w menu głównym</p>
      </form>
    
     
      <form class="form-signin" method="GET" action="./earn">
       		<button class="btn btn-lg btn-primary btn-block" type="submit">Wróc do menu</button>
       		
      </form>
      
     

    </div> <!-- /container -->


   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
   integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>

