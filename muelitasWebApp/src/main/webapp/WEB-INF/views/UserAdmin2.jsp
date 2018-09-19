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
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: #fff;">
  <!-- Navbar content -->
   <img class="mb-4" src="xmlhttp/images/muelita.png" alt="" width="72" height="72">

  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0"> 
      <li class="nav-item" >
        <a class="btn btn-primary btn-sm" href="/admin.do">System Configuration <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="btn btn-primary btn-sm" href="/admin.do">Users Management</a>
      </li>
      <!--  
      <li class="nav-item">
        <a class="btn btn-primary btn-sm" href="/secretary.do">Appointment Management</a>
      </li>
      -->
       <li class="nav-item" ALIGN=RIGHT )>
        <a class="btn btn-primary btn-sm"  href="/logout.do">Logout</a>
      </li>
    </ul>
    
  </div>
</nav>
        <!-- Page Content -->
         
        <div id="page-content-wrapper">
            
<div class="container-fluid" class="form-signin">
 <div class="row-fluid">
  <div class="col-md-6">
   <img class="mb-4" src="xmlhttp/images/muelita.png" alt="" width="72" height="72" class="img-thumbnail" alt="Cinque Terre">
     <h2>Users Admin</h2>           
             
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
      <td><a href="/UserUpdate.do?user=${User.id}" class="btn btn-info btn-xs"> Update</a></td>
      <td><a href="/UserDelete.do?user=${User.id}" class="btn btn-danger btn-xs"> Delete</a></td>
     </tr>
    </c:forEach>    
    </tbody>
   </table>
   <br />
   <a href="UserRegister.jsp" class="btn btn-lg btn-primary btn-block"> New User</a>
  </div>
 </div>
</div>
            
            
        </div>
        <!-- /#page-content-wrapper -->
        

</body>
</html>


