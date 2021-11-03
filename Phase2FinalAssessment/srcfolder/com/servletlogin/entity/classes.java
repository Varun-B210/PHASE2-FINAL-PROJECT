package com.servletlogin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class classes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int classess;
	private String section;
	private String student_names;
	private String subjectComb;
	
	public classes() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClassess() {
		return classess;
	}

	public void setClassess(int classess) {
		this.classess = classess;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getStudent_names() {
		return student_names;
	}

	public void setStudent_names(String student_names) {
		this.student_names = student_names;
	}

	public String getSubjectComb() {
		return subjectComb;
	}

	public void setSubjectComb(String subjectComb) {
		this.subjectComb = subjectComb;
	}
	
	
}
