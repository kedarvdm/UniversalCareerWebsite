package com.me.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYER")
@PrimaryKeyJoinColumn(name="USER_ID")
public class Employer extends User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String description;
	private String industry;
	private String website;
	private String workphone;
	private String dateCreated;
	private Set<Employee> employees;
	
	@Column(name = "VETERANSTATUS")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "INDUSTRY")
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	@Column(name = "WEBSITE")
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	@Column(name = "WORKPHONE")
	public String getWorkphone() {
		return workphone;
	}
	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}
	
	@Column(name = "DATECREATED")
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@OneToMany(mappedBy="employer",fetch=FetchType.EAGER)
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
}
