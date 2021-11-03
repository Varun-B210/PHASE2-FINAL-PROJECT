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

import com.servletlogin.entity.classes;
import com.util.HibernateUtil;


public class ReadClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReadClass() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			@SuppressWarnings("unchecked")
			List<classes> classList = session.createQuery("select _classes from classes _classes").getResultList();
			PrintWriter out = response.getWriter();
			out.println("classList" + classList);

			List<HashMap<Object, Object>> classMapList = new ArrayList<>();
			for (classes classes : classList) {
				HashMap<Object, Object> classMap = new HashMap<>();
				classMap.put("id", classes.getId());
				classMap.put("classess",classes.getClassess());
				classMap.put("section", classes.getSection());
				classMap.put("student_names", classes.getStudent_names());
				classMap.put("subjectComb", classes.getSubjectComb());

				classMapList.add(classMap);
			}
			JSONArray jsonArray = new JSONArray(classMapList);
			request.getRequestDispatcher("dashboard.jsp?classes=" + jsonArray.toString()).forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		}
		
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
