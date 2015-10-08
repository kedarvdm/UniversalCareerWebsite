package com.me.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "APPLICANT")
@PrimaryKeyJoinColumn(name="USER_ID")
public class Applicant extends User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String cellphone;
	private String dateCreated;
	private String resumePath;
	
	private WorkExperience workEx;
	private Education education;
	private Set<Application> applications;
	
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
	
	@OneToOne(mappedBy="user",fetch=FetchType.EAGER)
	public WorkExperience getWorkEx() {
		return workEx;
	}
	public void setWorkEx(WorkExperience workEx) {
		this.workEx = workEx;
	}
	
	@OneToOne(mappedBy="user",fetch=FetchType.EAGER)
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education education) {
		this.education = education;
	}
	
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER)
	public Set<Application> getApplications() {
		return applications;
	}
	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}
	
	@Column(name = "RESUME")
	public String getResumePath() {
		return resumePath;
	}
	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}	
}
