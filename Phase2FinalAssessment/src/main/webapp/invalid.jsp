<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
</head>
<body>
	<%
		Integer errorCode = Integer.parseInt(request.getParameter("error"));
		if (errorCode == 1) {
	%>
	<script>
		alert("Error occurred. Enter valid credentials");
	</script>
	
	<%
	    
		} 
		
		else if (errorCode == 2) {
			
	%>
	<script>
		alert("Error occurred. Enter valid credentials");
	</script>

	<%
	
		} 
		
		else if (errorCode == 3) {
			
	%>
	<script>
		alert("Error occurred. Enter valid credentials");
	</script>
<%} %>

	<a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span>
		Login</a>
</body>
</html> 