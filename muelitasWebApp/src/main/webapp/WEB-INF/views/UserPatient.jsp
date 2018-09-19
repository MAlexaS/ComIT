<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
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
    <meta name="description" content="">
    <meta name="author" content="">

    <title>File Patient</title>


  </head>

  <body class="bg-dark">

    <div class="container">
      <div class="card card-register mx-auto mt-5">
        <div class="card-header">Register a Patient</div>
          <img class="mb-4" src="xmlhttp/images/muelita.png" alt="" width="72" height="72" class="img-thumbnail" alt="Cinque Terre">
        <div class="card-body">
          <form>
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="text" id="id" class="form-control" placeholder="Patient ID" required="required" autofocus="autofocus">
                    <label for="Patient ID">Patient ID</label>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="text" id="healthCard" class="form-control" placeholder="Health Card" required="required"  autofocus="autofocus">
                    <label for="Health Card">Health Card</label>
                  </div>
                </div>
             
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="text" id="namePatient" class="form-control" placeholder="Name Patient" required="required">
                    <label for="Name">Name</label>
                  </div>
                  </div>
                  
                   <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="text" id="lastPatient" class="form-control" placeholder="LastName Patient" required="required">
                    <label for="LastName">LastName</label>
                  </div>
                  </div>
                   <div class="col-md-6">
                  <div class="form-label-group">
               
                  <p>Date of birth:<input type="text" class="form-control" id="campofecha"></p>
                    </div>
                    </div>
                  
                   <div class="col-md-6">
                  <div class="form-label-group">
                     <input type="radio" name="gender" value="male"> Male
                       <input type="radio" name="gender" value="female"> Female
                        </div>
                        </div> 
                                 <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="text" id="Ocupation" class="form-control" placeholder="Ocupation" required="required">
                    <label for="Ocupation">Occupation</label>
                  </div>
                  </div>
                   </div>
                         <div class="form-row">
                   <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="text" id="ContactNameEmergency" class="form-control" placeholder="Contact Name Emergency" required="required">
                    <label for="ContactNameEmergenc">Contact Name Emergency</label>
                  </div>
                     </div>
                   <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="text" id="ContactPhoneEmergency" class="form-control" placeholder="Contact Phone Emergency" required="required">
                    <label for="ContactPhoneEmergency">Contact Phone Emergency</label>
                  </div>
                  </div>
            

            </div>
            <a class="btn btn-primary btn-block" href="/WEB-INF/views/login.jsp">Register</a>
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="login.jsp">Login Page</a>
            <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  </body>

</html>