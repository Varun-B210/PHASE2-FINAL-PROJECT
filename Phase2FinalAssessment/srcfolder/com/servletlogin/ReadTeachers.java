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

import com.servletlogin.entity.teachers;
import com.util.HibernateUtil;


public class ReadTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public ReadTeachers() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			@SuppressWarnings("unchecked")
			List<teachers> teachersList = session.createQuery("select _teachers from teachers _teachers").getResultList();
			PrintWriter out = response.getWriter();
			out.println("teachersList" + teachersList);

			List<HashMap<Object, Object>> teachersMapList = new ArrayList<>();
			for (teachers teacher : teachersList) {
				HashMap<Object, Object> teacherMap = new HashMap<>();
				teacherMap.put("id", teacher.getId());
				teacherMap.put("name", teacher.getName());
				teacherMap.put("age", teacher.getAge());
				teacherMap.put("subjects", teacher.getSubjects());

				teachersMapList.add(teacherMap);
			}
			JSONArray jsonArray = new JSONArray(teachersMapList);
			request.getRequestDispatcher("dashboard.jsp?teachers=" + jsonArray.toString()).forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
