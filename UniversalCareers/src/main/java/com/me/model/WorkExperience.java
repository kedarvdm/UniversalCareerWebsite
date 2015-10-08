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
@Table(name = "WORKEXPERIENCE")
public class WorkExperience implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private User user;
	private String employerName;
	private String title;
	private String responsibilities;
	private String startDate;
	private String endDate;
	private String isCurrentEmployer;
	private String dateCreated;
	
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
	@JoinColumn(name="USER_WORKEX_FK")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name = "EMPLOYERNAME")
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	
	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "RESPONSIBILITIES")
	public String getResponsibilities() {
		return responsibilities;
	}
	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
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
	
	@Column(name = "ISCURRENTEMPLOYER")
	public String getIsCurrentEmployer() {
		return isCurrentEmployer;
	}
	public void setIsCurrentEmployer(String isCurrentEmployer) {
		this.isCurrentEmployer = isCurrentEmployer;
	}
	
	@Column(name = "DATECREATED")
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
}
