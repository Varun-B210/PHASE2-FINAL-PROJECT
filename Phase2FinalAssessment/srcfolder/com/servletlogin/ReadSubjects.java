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

import com.util.HibernateUtil;
import com.servletlogin.entity.subjects;


public class ReadSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReadSubjects() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		
		@SuppressWarnings("unchecked")
		List<subjects> subjectsList=session.createQuery("select _subjects from subjects _subjects").getResultList();
		PrintWriter out=response.getWriter();
		out.println("subjectsList"+ subjectsList);
		
		List<HashMap<Object, Object>> subjectsMapList = new ArrayList<>();
		for (subjects subject : subjectsList) {
			HashMap<Object, Object> subjectMap = new HashMap<>();
			subjectMap.put("id", subject.getId());
			subjectMap.put("subject_name", subject.getSubject_name());
			subjectMap.put("code", subject.getCode());
			subjectsMapList.add(subjectMap);
		}
		JSONArray jsonArray = new JSONArray(subjectsMapList);
		request.getRequestDispatcher("dashboard.jsp?subjects=" + jsonArray.toString()).forward(request, response);

	} catch (Exception ex) {
		ex.printStackTrace();
	}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
