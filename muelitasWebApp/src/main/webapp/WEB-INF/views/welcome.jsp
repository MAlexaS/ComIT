<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::: Muelitas App - By Mireya Salazar :::</title>
</head>
<% 
	Date date = new Date();  
%>
<body>
	<h1>Welcome to Muelitas App ${username} </h1>
	<h2>Current date from Java: <%= date %></h2>

</body>
</html>