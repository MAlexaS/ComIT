<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <link rel="icon" href="xmlhttp/images/un.png">


 <link href="xmlhttp/css/signin.css" type="text/css" rel="stylesheet">
   <link href="xmlhttp/css/bootstrap.min.css" type="text/css" rel="stylesheet">
   
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#campofecha" ).datepicker({
      numberOfMonths: 2,
      showButtonPanel: true
    });
  } );
  </script>
  <head>

  <meta name="description" content="Application used to schedule dental appointments administer patients and doctors.">
    <meta name="author" content= "Mireya Salazar">
 
  <title>::: Muelitas Web App - By Mireya Salazar :::</title>
 
  </head>



<body class="bg-dark" class="text-center">

 <div class="container">            
            <form action="/Patient.do" method="post"  role="form" data-toggle="validator" class="form-signin" class="form-center" >
          
                <c:if test ="${empty action}">                        	
                    <c:set var="action" value="guardar"/>
                </c:if>
                <input type="hidden" id="action" name="action" value="${action}">
                <input type="hidden" id="id" name="id" value="${Patient.id}">
                <h2><img class="mb-4" src="xmlhttp/images/muelita.png" alt="" width="72" height="72" class="img-thumbnail" alt="Cinque Terre">Patient Update</h2>
                
                <br>
                <div class="form-group">
                    <label for="healthCard" class="control-label col-xs-4">HealthCard:</label>
                    <input type="text" name="healthCard" id="healthCard" class="form-control"  readonly="readonly" value="${Patient.healthCard}" />                                   
              </div>
                    <div class="form-group">
                    <div class="form-row">
                    <div class="col-md-6">
                    <label for="name" class="control-label col-xs-4">Name:</label>                   
                    <input type="text" name="name" id="name" class="form-control"  readonly="readonly" value="${Patient.name}" > 
                    </div>
                    </div>
                    </div>
                    <div class="form-group">
                    <div class="form-row">
                    <div class="col-md-6">
                    <label for="lastName" class="control-label col-xs-4">LastName:</label>                   
                    <input type="text" name="lastName" id="lastName" class="form-control"  readonly="readonly" value="${Patient.lastname}"> 
                     </div>
                     </div>
                     </div>
                      <br>
                      
                <div class="form-group">  
                    <label for="dateBirth" class="control-label col-xs-4">DateBirth:</label>                          
                    <input type="text" name="dateBirth" id="dateBirth" class="form-control"  readonly="readonly" value="${Patient.dateBirth}">
                      </div>
                        <br>
                        <div class="form-group">
                     <label for="occupation" class="control-label col-xs-4">Occupation:</label>
                        <input type="text" name="occupation" id="occupation" class="form-control"  readonly="readonly" value="${Patient.occupation}"> 
                 
           			</div>

                      
                    <div class="form-group">
                  <div class="form-row">
                    <div class="col-md-6">
                      <label>ContactEmergency:</label> 
                      <br>
                     
                    <label for="nameEmergency" class="control-label col-xs-4">Name:</label>                   
                    <input type="text" name="nameEmergency" id="nameEmergency"  class="form-control" value="${Patient.contactEmergency}" required="true"/> 
                    </div>
                    </div>
                    </div>
                    <div class="form-group">
                    <div class="form-row">
                    <div class="col-md-6">
                     <br>
                    
                    
                     <label for="phoneEmergency" class="control-label col-xs-4">Phone:</label>                   
                    <input type="text" name="phone" id="phone" class="form-control" value="${Patient.phone}" required="true"/> 
                     </div>
                     </div>
                     </div>
                     <br>
                     
                     <div class="form-group">
                     
                     
                                        <button type="submit" class="btn btn-sm btn-primary">Save</button> 
                                         &nbsp;&nbsp; <a href="/admin.do" class="btn btn-sm btn-primary">Cancel</a>
                     </div> </div> 
                                            
            </form>
 </div> 
       
    </body>
</html>
