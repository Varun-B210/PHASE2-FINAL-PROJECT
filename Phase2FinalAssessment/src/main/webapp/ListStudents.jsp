<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.Objects"%>
<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Students</title>
</head>
<body>

<% 
			String students = request.getParameter("students");
			if (Objects.nonNull(students)) {
						%>
		<h3 align="center">List of Students</h3>				
		<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Age</th>
						</tr>
					</thead>
					<tbody>
						<%
						@SuppressWarnings("unchecked")
						List<HashMap<Object, Object>> studentsList = new ObjectMapper().readValue(students, List.class);
								
												for (HashMap<Object, Object> eachMap : studentsList) {
													int id = (Integer) eachMap.get("id");
													String studentName = (String) eachMap.get("student_name");
													int age=(Integer) eachMap.get("age");
						%>
									<tr>
										<td><%=id%></td>
										<td><%=studentName%></td>
										<td><%=age %></td>
									</tr>
							
							<%	}%>
							<%	}%>
					
					</tbody>
				</table>
		


</body>
</html>