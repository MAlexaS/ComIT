<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
 <meta name="description" content="Application used to schedule dental appointments administer patients and doctors.">
    <meta name="author" content= "Mireya Salazar">
    <link rel="icon" href="xmlhttp/images/un.png">

<title>::: Muelitas Web App - By Mireya Salazar :::</title>
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

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   
  </head>



<body class="bg-ligth text-center">

 <div class="container">            
            <form action="/Person.do" method="post"  role="form" data-toggle="validator" class="form-signin" class="form-center" >
          
                <c:if test ="${empty action}">                        	
                    <c:set var="action" value="guardar"/>
                </c:if>
                <input type="hidden" id="action" name="action" value="${action}">
                <input type="hidden" id="id" name="id" value="${Person.id}">
                <h2><img class="mb-4" src="xmlhttp/images/muelita.png" alt="" width="72" height="72" class="img-thumbnail" alt="Cinque Terre">Person</h2>
                
                <br>
                
                    <div class="form-group">
                    <div class="form-row">
                    <div class="col-md-6">
                    <label for="name" class="control-label col-xs-4">Name:</label>                   
                    <input type="text" name="name" id="name" class="form-control" value="${Person.name}" required="true"/> 
                    </div>
                    </div>
                    
                    <div class="form-group">
                    <div class="form-row">
                    <div class="col-md-6">
                    <label for="lastName" class="control-label col-xs-4">LastName:</label>                   
                    <input type="text" name="lastName" id="lastName" class="form-control" value="${Person.lastname}" required="true"/> 
                     </div>
                     </div>
                     
                   
                      
                      
                      
                    <div class="form-group">
                    <div class="form-row">
                    <div class="col-md-6">
                    <label for="address" class="control-label col-xs-4">Address:</label>                   
                    <input type="text" name="address" id="address" class="form-control" value="${Person.address}" required="true"/> 
                    </div>
                    </div>
                    </div>
                    <div class="form-group">
                    <div class="form-row">
                    <div class="col-md-6">
                    <label for="zipcode" class="control-label col-xs-4">ZIPCODE:</label>                   
                    <input type="text" name="zipcode" id="zipcode" class="form-control" value="${Person.zipcode}" required="true"/> 
                     </div>
                     </div>
                     </div>
                      <br>
                
                
                <div class="form-group">  
                    <label for="dateBirth" class="control-label col-xs-4">DateBirth:</label>                          
                    <p><input type="text" class="form-control" id="campofecha" value="${Person.dateBirth}" required="true"/></p>
                      </div>
                                           
                  
                      
                    <div class="form-group">
                    <div class="form-row">
                    <div class="col-md-6">
                    <label for="phone" class="control-label col-xs-4">Phone:</label>                   
                    <input type="text" name="phone" id="phone" class="form-control" value="${Person.phone}" required="true"/> 
                    </div>
                    </div>
                    </div>
                    <div class="form-group">
                    <div class="form-row">
                    <div class="col-md-6">
                    <label for="cellphone" class="control-label col-xs-4">Cellphone:</label>                   
                    <input type="text" name="cellphone" id="cellphone" class="form-control" value="${Person.cellphone}" required="true"/> 
                     </div>
                     </div>
                     </div>
                      <br>             
                    
                     
                     
                     <div class="form-group">
                    <div class="form-row">
                    <div class="col-md-6">
                    <label for="email" class="control-label col-xs-4">Email:</label>                   
                    <input type="email" name="email" class="form-control" value="${Person.phone}" required="true"/> 
                    </div>
                    </div>
                    </div>
                    <div class="form-group">
                    <div class="form-row">
                    <div class="col-md-6">
                    <div class="form-group">
                     <label for="type" class="control-label col-xs-4">Type:</label>
                     <select name="type" class="form-control" value="${Person.type}" required="true"/>
                     <option value="C01">type1</option>
                     <option value="C02">type2</option>
            		<option value="C03">type3</option>
           			 </select>
           			</div> </div>
                     </div>
                     
                      <br>             
                     <div class="form-group">
                           <button type="submit" class="btn btn-sm btn-primary">Register</button>
                           &nbsp;&nbsp; <a href="/admin.do" class="btn btn-sm btn-primary">Cancel</a> 
                     </div> </div> 
                                            
            </form>
 </div> 
       
    </body>
</html>
