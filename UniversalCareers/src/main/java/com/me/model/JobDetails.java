package com.me.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "JOBDETAILS")
public class JobDetails implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private User user;			//Person who posted the job
	private Employer employer;		//Employer id
	private String jobTitle;
	private String durationFrom;
	private String durationTo;
	private String jobType;
	private String description;
	private String skills;
	private String hourlyWage;
	private int positions;
	private String city;
	private String state;
	private String country;
	private String dateCreated;
	
	private Set<Application> applications;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@OneToOne
	@JoinColumn(name="EMPLOYEE_FK")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToOne
	@JoinColumn(name="EMPLOYER_FK")
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	
	@Column(name = "JOBTITLE")
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	@Column(name = "DURATIONFROM")
	public String getDurationFrom() {
		return durationFrom;
	}
	public void setDurationFrom(String durationFrom) {
		this.durationFrom = durationFrom;
	}
	
	@Column(name = "DURATIONTO")
	public String getDurationTo() {
		return durationTo;
	}
	public void setDurationTo(String durationTo) {
		this.durationTo = durationTo;
	}
	
	@Column(name = "JOBTYPE")
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "SKILLS")
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	@Column(name = "HOURLYWAGE")
	public String getHourlyWage() {
		return hourlyWage;
	}
	public void setHourlyWage(String hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	
	@Column(name = "POSITIONS")
	public int getPositions() {
		return positions;
	}
	public void setPositions(int positions) {
		this.positions = positions;
	}
	
	@Column(name = "DATECREATED")
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	@Column(name = "CITY")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "STATE")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name = "COUNTRY")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@OneToMany(mappedBy="job",fetch=FetchType.EAGER)
	public Set<Application> getApplications() {
		return applications;
	}
	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}
}
