package com.me.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "EDUCATION")
public class Education implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private User user;
	private String schoolName;
	private String major;
	private String degreeLevel;
	private String gpa;
	private String startDate;
	private String endDate;
	private String isGraduated;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="USER_EDUCATION_FK")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name = "SCHOOLNAME")
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	@Column(name = "MAJOR")
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	@Column(name = "DEGREELEVEL")
	public String getDegreeLevel() {
		return degreeLevel;
	}
	public void setDegreeLevel(String degreeLevel) {
		this.degreeLevel = degreeLevel;
	}
	
	@Column(name = "GPA")
	public String getGpa() {
		return gpa;
	}
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	
	@Column(name = "STARTDATE")
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	@Column(name = "ENDDATE")
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	@Column(name = "ISGRADUATED")
	public String getIsGraduated() {
		return isGraduated;
	}
	public void setIsGraduated(String isGraduated) {
		this.isGraduated = isGraduated;
	}
}
