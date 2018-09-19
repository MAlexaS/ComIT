<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<link href="xmlhttp/css/signin.css" type="text/css" rel="stylesheet">
<link href="xmlhttp/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-timepicker/0.5.2/css/bootstrap-timepicker.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-timepicker/0.5.2/js/bootstrap-timepicker.min.js"></script>

<script>
$(document).ready(function() {
	  $('#campotime').timepicker({
	    useCurrent: false,
	    format: 'HH:mm:ss',
	    minuteStep: 1,
	    showSeconds: true,
	    showMeridian: false,
	    disableFocus: true,
	    icons: {
	      up: 'fa fa-chevron-up',
	      down: 'fa fa-chevron-down'
	    }
	  }).on('focus', function() {
	    $('#campotime').timepicker('showWidget');
	  });

	});
</script>
   
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
  $( function() {
    $( "#campofecha" ).datepicker({
      numberOfMonths: 1,
      showButtonPanel: true
    });
  } );

  </script>
  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta name="description" content="Application used to schedule dental appointments administer patients and doctors.">
    <meta name="author" content= "Mireya Salazar">
    <link rel="icon" href="xmlhttp/images/un.png">

  </head>

  <body class="bg-dark">

      <div class="card card-register mx-auto mt-5">
        <div class="card-header">Update an Appointment</div>
         <img class="mb-4" src="xmlhttp/images/muelita.png" alt="" width="72" height="72" class="img-thumbnail" alt="Cinque Terre">
        <div class="card-body">
          <form  action="post" >
          <div class="container">
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                    <label for="HealthCard">Health Card</label>
                    <input type="text" name="HealthCard" class="form-control"  readonly="readonly" placeholder="Health Card" required="required" autofocus="autofocus">
                    
                  </div>
                    
                  </div>
                </div>
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                  <input type="text" id="firstName" class="form-control"  readonly="readonly" placeholder="First name">
                        </div>
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
             <input type="text" id="lastName" class="form-control"  readonly="readonly" placeholder="Last name">
                  </div>
                </div>
                   </div>
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                           <label for="Date">Date</label>
                  <input type="text" class="form-control" id="campofecha">
                        </div>
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                   <label for="Time">Time</label>
                  <select name="time" class="form-control">
              <option value="0800">8:00</option>
             <option value="0815">8:15</option>
            <option value="0830">8:45</option>
             <option value="0845">9:00</option>
              <option value="0900">9:15</option>
               <option value="0915">9:30</option>
                <option value="0930">9:45</option>
                 <option value="1000">10:00</option>
                  <option value="1015">10:15</option>
                   <option value="1030">10:30</option>
                    <option value="1045">10:45</option>
                     <option value="1100">11:00</option>
                      <option value="1115">11:15</option>
                       <option value="1130">11:30</option>
                        <option value="1145">11:45</option>
                         <option value="1200">12:00</option>
                          <option value="1215">12:15</option>
                           <option value="1230">12:30</option>
                           <option value="1245">12:45</option>
                            <option value="1400">14:00</option>
                             <option value="1415">14:15</option>
                              <option value="1430">14:30</option>
                               <option value="1445">14:45</option>
                                <option value="1500">15:00</option>
                                 <option value="1515">15:15</option>
                                  <option value="1530">15:30</option>
                                   <option value="1545">15:45</option>
                                    <option value="1600">16:00</option>
                                     <option value="1615">16:15</option>
                                      <option value="1630">16:30</option>
                                       <option value="1645">16:45</option>
                                        <option value="1700">17:00</option>
                                         <option value="1715">17:15</option>
                                          <option value="1730">17:30</option>
                                           <option value="1745">17:45</option>                                  
            </select> 
   
                </div>
                </div>
                 </div>
                <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
              <label for="Speciality">Speciality</label>
               <input type="text" id="Speciality" class="form-control"  readonly="readonly" placeholder="speciality">
              
              </div>  
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                     <label for="Doctor">Doctor</label>
               <input type="text" id="doctor" class="form-control"  readonly="readonly" placeholder="doctor">
              
         
     </div>    
     </div>
            
             <div class="col-md-6">
                  <div class="form-label-group">
                     <label for="Status">Status</label>
              <select name="Status" class="form-control">
              <option value="C01">Not Confirmed</option>
             <option value="C02">Confirmed</option>
            <option value="C03">Canceled</option>
            </select>
         
     </div>    
     </div>
     
      <div class="col-md-6">
                  <div class="form-label-group">
                     <label for="duration">Duration</label>
               <input type="text" id="duration" class="form-control" readonly="readonly" placeholder="duration">
     </div>    
     </div>
     
              
            </div>
                 </div>    
            <a class="btn btn-primary btn-block" href="index.jsp">Save</a>
                
            </div>
                 </div>
          </form>

  </body>

</html>