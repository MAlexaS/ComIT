<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
     <h2>Patient Admin</h2>           
             
   <hr>
   <table class="table table-bordered table-striped">
    <thead>
    <tr>
     <th>Id</th>
     <th>Healh Card</th>
     <th>Name</th>
     <th>LastName</th>
     <th>Date Birth</th>
     <th>Gender</th>
     <th>Occupation</th>
     <th>Contact Name</th>
     <th>Contact Phone</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="Patient" items="${list}">
     <tr>
      <td>${Patient.id}</td>
       <td>${Patient.healthNumber}</td>
      <td>${Patient.name}</td>
      <td>${Patient.lastName}</td>
      <td>${Patient.dateBirth}</td>
      <td>${Patient.Gender}</td>
      <td>${Patient.Occupation}</td>
      <td>${Patient.ContactName}</td>
      <td>${Patient.ContactPhone}</td>
      <td><a href="editemp/${Patient.id}" class="btn btn-info btn-xs"> Update</a></td>
      <td><a href="deleteemp/${Patient.id}" class="btn btn-danger btn-xs"> Delete</a></td>
     </tr>
    </c:forEach>    
    </tbody>
   </table>
   <br />
   <a href="PatientRegister.jsp" class="btn btn-lg btn-primary btn-block"> New Patient</a>
  </div>
 </div>
</div>
</body>
</html>


