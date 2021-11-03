<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.Objects"%>
<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<%-- STUDENT TABLE --%>
	<%
		String usernameSession = (String) session.getAttribute("username");
		if (session.getAttribute("username") == null) {
			response.sendRedirect("invalid.jsp?error=1");
		}
	%>
	<div align="center" container mt-3">
		<h2>Welcome to Learners Academy</h2>
		<h5><div class="alert alert-success">
		 <b><%
		out.println("Welcome "+ session.getAttribute("username"));
		%></b><br/><br/>
  <strong>Login Successful!</strong></h5>
 
</div>
		 
		  <div align="center"><a href="students"> <button class="btn btn-primary">View Students Info</button></a>
		  <a href="teachers"> <button class="btn btn-primary">View Teachers Info</button></a><br/><br/></div>
		   <div align="center"><a href="subjects"> <button class="btn btn-primary">View Subjects Info</button></a>
		  <a href="Class"> <button class="btn btn-primary">View Classes Info</button></a><br/><br/></div>
		  <a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
		
		<jsp:include page="ListStudents.jsp"/>
		<jsp:include page="ListTeachers.jsp"/>
		<jsp:include page="ListSubjects.jsp"/>
		<jsp:include page="ListClass.jsp"/>
		
				
	</div>
		

</body>
</html>