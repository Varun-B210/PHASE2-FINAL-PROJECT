package com.servletlogin;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;

import com.servletlogin.entity.students;
import com.util.HibernateUtil;

public class ReadStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReadStudents() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		@SuppressWarnings("unchecked")
		List<students> studentsList = session.createQuery("select _students from students _students").getResultList();
		PrintWriter out = response.getWriter();
		out.println("studentsList" + studentsList);

		List<HashMap<Object, Object>> studentsMapList = new ArrayList<>();
		for (students student : studentsList) {
			HashMap<Object, Object> studentMap = new HashMap<>();
			studentMap.put("student_name", student.getStudent_name());
			studentMap.put("id", student.getId());
			studentMap.put("age", student.getAge());
			studentsMapList.add(studentMap);
		}
		JSONArray jsonArray = new JSONArray(studentsMapList);
		request.getRequestDispatcher("dashboard.jsp?students=" + jsonArray.toString()).forward(request, response);

	} catch (Exception ex) {
		ex.printStackTrace();
	}
	}
	
	
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
