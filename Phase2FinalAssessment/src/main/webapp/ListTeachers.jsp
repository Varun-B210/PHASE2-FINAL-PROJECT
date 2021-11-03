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
<title>List of Teachers</title>
</head>
<body>

 <%
			String teachers = request.getParameter("teachers");
			if (Objects.nonNull(teachers)) {
				%>
				<h3 align="center">List of Teachers</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Age</th>
							<th>Subjects</th>
						</tr>
					</thead>
					<tbody>
						<%
						@SuppressWarnings("unchecked")
						List<HashMap<Object, Object>> teachersList = new ObjectMapper().readValue(teachers, List.class);
								
												for (HashMap<Object, Object> eachMap : teachersList) {
													int id = (Integer) eachMap.get("id");
													String name = (String) eachMap.get("name");
													int age=(Integer) eachMap.get("age");
													String subjects=(String) eachMap.get("subjects");
						%>
									<tr>
										<td><%=id%></td>
										<td><%=name%></td>
										<td><%=age %></td>
										<td><%=subjects %></td>
									</tr>
									<%	}%>
									<%	}%>
					</tbody>
				</table>


</body>
</html>