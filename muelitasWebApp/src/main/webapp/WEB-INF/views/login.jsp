<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!doctype html>
<html lang="en">
 <link href="xmlhttp/css/signin.css" type="text/css" rel="stylesheet">
   <link href="xmlhttp/css/bootstrap.min.css" type="text/css" rel="stylesheet">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Application used to schedule dental appointments administer patients and doctors.">
    <meta name="author" content= "Mireya Salazar">
    <link rel="icon" href="xmlhttp/images/un.png">

<title>::: Muelitas App - By Mireya Salazar :::</title>
     <% 
	Date date = new Date();  
     %>
  </head>

  <body class="text-center">

   <form class="form-signin" class="form-center"  action="/login.do"  method="post">
      <img class="mb-4" src="xmlhttp/images/muelita.png" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <h3 class="h3 mb-3 ">${errorMessage} </h3>
      <!--  
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="email" id="emailname"  class="form-control" placeholder="Email address" required autofocus>
      -->
        <label for="inputUsername" class="sr-only">Username</label>
      <input type="text" id="username" name="username" class="form-control" value="${username}"  required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
      <!--  
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>  
        </div>
      -->
      <button class="btn btn-lg btn-primary btn-block" value=login type="submit">Sign in</button>
      <p class="mt-5 mb-3 text-muted">&copy; comIT 2018</p>
      <p class="mt-5 mb-3 text-muted">&copy; Current date from Java: <%= date %></p>
    </form>
  </body>
</html>





