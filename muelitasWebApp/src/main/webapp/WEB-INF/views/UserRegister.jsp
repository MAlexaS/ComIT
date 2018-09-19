<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
 <meta name="description" content="Application used to schedule dental appointments administer patients and doctors.">
    <meta name="author" content= "Mireya Salazar">
    <link rel="icon" href="xmlhttp/images/un.png">

<title>::: Muelitas Web App - By Mireya Salazar :::</title>
 <link href="xmlhttp/css/signin.css" type="text/css" rel="stylesheet">
   <link href="xmlhttp/css/bootstrap.min.css" type="text/css" rel="stylesheet">
  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Muelitas Admin</title>

  </head>

  <body class="bg-ligth text-center">

 <div class="container">            
            <form action="/admin.do" method="post"  role="form" data-toggle="validator" class="form-signin" class="form-center" >
          
                <c:if test ="${empty action}">                        	
                    <c:set var="action" value="guardar"/>
                </c:if>
                <input type="hidden" id="action" name="action" value="${action}">
                <input type="hidden" id="id" name="id" value="${User.id}">
                <h2><img class="mb-4" src="xmlhttp/images/muelita.png" alt="" width="72" height="72" class="img-thumbnail" alt="Cinque Terre">Users</h2>
                
                <br>
                <div class="form-group">
                    <label for="name" class="control-label col-xs-4">Name:</label>
                    <input type="text" name="name" id="name" class="form-control" value="${User.name}" required="true" />                                   
 
                    <label for="lastName" class="control-label col-xs-4">LastName:</label>                   
                    <input type="text" name="lastName" id="apellido" class="form-control" value="${User.lastname}" required="true"/> 
 
                  
                    <label for="username" class="control-label col-xs-4">Username:</label>                    
                    <input type="text" name="username" id="username" class="form-control" value="${User.username}" required="true"/> 
 
                    <label for="role" class="control-label col-xs-4">Role:</label>
                     <select name="roleUser" class="form-control" value="${User.role}" required="true"/>
                     <option value="14">Admin</option>
                     <option value="13">Doctor</option>
            		<option value="12">Secretary</option>
           			 </select>
           			 
                     <label for="password" class="control-label col-xs-4">Password:</label>                   
                    <input type="password" name="password" id="password" class="form-control" value="${User.password}"  required="true"/>
 
                    <br></br>
                    <button type="submit" class="btn btn-sm btn-primary">Register</button>
                    &nbsp;&nbsp; <a href="/admin.do" class="btn btn-sm btn-primary">Cancel</a> 
                </div>                                                      
            </form>
        </div>
    </body>
</html>



