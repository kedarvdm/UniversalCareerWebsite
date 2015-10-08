package com.me.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
@PrimaryKeyJoinColumn(name="USER_ID")
public class Employee extends User implements Serializable{
	private static final long serialVersionUID = 1L;
	private Employer employer;
	private String department;
	private String cellphone;
	private String dateCreated;
	
	@ManyToOne
	@JoinColumn(name="EMPLOYER_FK")
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	
	@Column(name = "DEPARTMENT")
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Column(name = "CELLPHONE")
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	@Column(name = "DATECREATED")
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
}
