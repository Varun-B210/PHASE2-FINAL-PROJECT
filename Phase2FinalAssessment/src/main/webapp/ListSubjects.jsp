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
<title>List of Subjects</title>
</head>
<body>
<% 
String subjects = request.getParameter("subjects");
			if (Objects.nonNull(subjects)) {
						%>

		<h3 align="center">List of Subjects</h3>
					
		<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Subject</th>
							<th>Code</th>
						</tr>
					</thead>
					<tbody>
						<%
						@SuppressWarnings("unchecked")
						List<HashMap<Object, Object>> subjectsList = new ObjectMapper().readValue(subjects, List.class);
								
												for (HashMap<Object, Object> eachMap : subjectsList) {
													int id = (Integer) eachMap.get("id");
													String subject = (String) eachMap.get("subject_name");
													String code=(String) eachMap.get("code");
						%>
									<tr>
										<td><%=id%></td>
										<td><%=subject%></td>
										<td><%= code %></td>
									</tr>
							
							<%	}%>
							<%	}%>
					
					</tbody>
				</table>
		


</body>
</html>