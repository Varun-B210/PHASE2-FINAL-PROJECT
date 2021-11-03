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
<title>List of Classes</title>
</head>
<body>
<% 
String cl = request.getParameter("classes");
			if (Objects.nonNull(cl)) {
						%>

		<h3 align="center">List of Classes</h3>
					
		<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Class</th>
							<th>Section</th>
								<th>Students</th>
									<th>Subjects</th>
						</tr>
					</thead>
					<tbody>
						<%
						@SuppressWarnings("unchecked")
						List<HashMap<Object, Object>> classList = new ObjectMapper().readValue(cl, List.class);
								
												for (HashMap<Object, Object> eachMap : classList) {
													int id = (Integer) eachMap.get("id");
													int classess = (Integer) eachMap.get("classess");
													String section=(String) eachMap.get("section");
													String student_names=(String) eachMap.get("student_names");
													String subjectComb=(String) eachMap.get("subjectComb");
													
						%>
									<tr>
										<td><%=id%></td>
										<td><%=classess%></td>
										<td><%= section %></td>
											<td><%= student_names %></td>
												<td><%= subjectComb %></td>
									</tr>
							
							<%	}%>
							<%	}%>
					
					</tbody>
				</table>
		


</body>
</html>