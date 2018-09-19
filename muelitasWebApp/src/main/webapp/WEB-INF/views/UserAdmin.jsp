<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="xmlhttp/css/signin.css" type="text/css" rel="stylesheet">
   <link href="xmlhttp/css/bootstrap.min.css" type="text/css" rel="stylesheet">
 
 <meta name="description" content="Application used to schedule dental appointments administer patients and doctors.">
    <meta name="author" content= "Mireya Salazar">
    <link rel="icon" href="xmlhttp/images/un.png">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::: Muelitas Web App - By Mireya Salazar :::</title>
</head>
<body class="text-center">
<div class="container-fluid" class="form-signin">
 <div class="row-fluid">
  <div class="col-md-6">
   <img class="mb-4" src="xmlhttp/images/muelita.png" alt="" width="72" height="72" class="img-thumbnail" alt="Cinque Terre">
     <h2>Users Admin</h2>
     <a href="UserRegister.do" class="btn btn-sm btn-primary"> New User</a>

     &nbsp;&nbsp;
     <a href="logout.do" class="btn btn-sm btn-primary">Logout</a>           
             
   <hr>
   <table class="table table-bordered table-striped">
    <thead>
    <tr>
     <th>Id</th>
     <th>Name</th>
     <th>LastName</th>
     <th>Username</th>
     <th>Rol</th>
     <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="User" items="${list}">
     <tr>
      <td> </td>
      <td>${User.name}</td>
      <td>${User.lastName}</td>
      <td>${User.userName}</td>
      <td>${User.role.getDesc()}</td>
      <td>.. password</td>
      <td><a href="/UserUpdate.do?user=${User.id}" class="btn btn-info btn-sm"> Update</a></td>
      <td><a href="/UserDelete.do?user=${User.id}" class="btn btn-danger btn-sm"> Delete</a></td>
     </tr>
    </c:forEach>    
    </tbody>
   </table>
  </div>
 </div>
</div>
            
            
</body>
</html>


