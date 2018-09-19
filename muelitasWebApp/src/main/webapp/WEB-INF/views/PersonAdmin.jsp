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
<div class="container-fluid" class="form-signin">
 <div class="row-fluid">
  <div class="col-md-6">
   <img class="mb-4" src="xmlhttp/images/muelita.png" alt="" width="72" height="72" class="img-thumbnail" alt="Cinque Terre">
     <h2>Person Admin</h2>           
	 <a href="PersonRegister.do" class="btn btn-sm btn-primary"> New Person</a>
     &nbsp;&nbsp;
     <a href="admin.do" class="btn btn-sm btn-primary"> User Admin</a>
     &nbsp;&nbsp;
     <a href="logout.do" class="btn btn-sm btn-primary">Logout</a>             
   <hr>
   <table class="table table-bordered table-striped">
    <thead>
    <tr>
    <th>Name</th>
     <th>LastName</th>
     <th>Address</th>
     <th>ZipCode</th>
     <th>Date Birth</th>
      <th>Phone</th>
     <th>Cellphone</th>
     <th>Email</th>
     <th>Type</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="Person" items="${list}">
     <tr>
      <td>${Person.name}</td>
      <td>${Person.lastName}</td>
      <td>${Person.address}</td>
      <td>${Person.zipcode}</td>
      <td>${Person.dateBirth}</td>
      <td>${Person.Phone}</td>
      <td>${Person.Cellphone}</td>
      <td>${Person.Email}</td>
      <td>${Person.Type}</td>
      <td><a href="/PersonUpdate.do?person=${Person.id}" class="btn btn-info btn-xs"> Update</a></td>
      <td><a href="/PersonDelete.do?person=${Person.id}" class="btn btn-danger btn-xs"> Delete</a></td>
     </tr>
    </c:forEach>    
    </tbody>
   </table>
   <br />
   <a href="PersonRegister.jsp" class="btn btn-lg btn-primary btn-block"> New Person</a>
  </div>
 </div>
</div>
</body>
</html>


