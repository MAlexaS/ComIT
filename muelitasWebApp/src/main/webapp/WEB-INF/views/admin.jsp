<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
 <link rel="icon" href="xmlhttp/images/un.png">
 
<link href="xmlhttp/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="xmlhttp/css/bootstrap.css" type="text/css" rel="stylesheet"> 
<link href="xmlhttp/css/fullcalendar.min.css" rel='stylesheet' />
<link href="xmlhttp/css/fullcalendar.print.min.css" rel='stylesheet' media='print' />
<link href="xmlhttp/css/scheduler.min.css" rel='stylesheet' />
<script src="xmlhttp/js/moment.min.js"></script>
<script src="xmlhttp/js/jquery.min.js"></script>
<script src="xmlhttp/js/fullcalendar.min.js"></script>
<script src="xmlhttp/js/scheduler.min.js"></script>
<% 
	Date date = new Date();  
     %>

 

<title>::: Muelitas Web App - By Mireya Salazar :::</title>

    <!-- Bootstrap core CSS -->
    <link href="xmlhttp/css/bootstrap.min.css" type="text/css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="xmlhttp/css/simple-sidebar.css" rel="stylesheet">
    
<script>

  $(function() { // document ready

    $('#calendar').fullCalendar({
      now: ' <%= date %>',
      editable: true,
      aspectRatio: 1.8,
      scrollTime: '00:00',
      header: {
        left: 'today prev,next',
        center: 'title',
        right: 'timelineDay,timelineThreeDays,agendaWeek,month'
      },
      defaultView: 'timelineDay',
      views: {
        timelineThreeDays: {
          type: 'timeline',
          duration: { days: 3 }
        }
      },
      resourceAreaWidth: '30%',
      resourceColumns: [
        {
          labelText: 'Specialities',
          field: 'title'
        }
      ],
      resources: [
          { id: 'a', title: 'Speciality A', occupancy: 40 },
          { id: 'b', title: 'Speciality B', occupancy: 40, eventColor: 'green' },
          { id: 'c', title: 'Speciality C', occupancy: 40, eventColor: 'orange' },
          { id: 'd', title: 'Speciality D', occupancy: 40, children: [
            { id: 'd1', title: 'Doctor D1', occupancy: 10 },
            { id: 'd2', title: 'Doctor D2', occupancy: 10 }
          ] },
        
        ],
        events: [
          { id: '1', resourceId: 'b', start: '2018-09-12T02:00:00', end: '2018-09-12T07:00:00', title: 'event 1' },
          { id: '2', resourceId: 'c', start: '2018-09-12T05:00:00', end: '2018-09-12T22:00:00', title: 'event 2' },
          { id: '3', resourceId: 'd', start: '2018-09-12', end: '2018-09-12', title: 'event 3' },
          { id: '4', resourceId: 'e', start: '2018-09-12T03:00:00', end: '2018-09-12T08:00:00', title: 'event 4' },
          { id: '5', resourceId: 'f', start: '2018-09-12T00:30:00', end: '2018-09-12T02:30:00', title: 'event 5' }
        ]
      });
    
    });
</script>
<style>

  body {
    margin: 0;
    padding: 0;
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 900px;
    margin: 50px auto;
  }

</style>
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
            <div class="container-fluid">               
                <a href="#menu-toggle" class="btn btn-lg btn-primary btn-block" id="menu-toggle">Make an Appointment</a>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
     
<div id='calendar'></div>

    
    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>

</body>

</html>
