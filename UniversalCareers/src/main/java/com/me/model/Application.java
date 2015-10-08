package com.me.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APPLICATION")
public class Application implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private User user;
	private JobDetails job;
	private String appStatus;
	private String internalAppStatus;
	private String dateAppStatus;
	private String dateIntStatus;
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
	@JoinColumn(name="USER_APPLICATION_FK")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "JOB_ID", nullable = false)
	public JobDetails getJob() {
		return job;
	}
	public void setJob(JobDetails job) {
		this.job = job;
	}
	
	@Column(name = "APPSTATUS")
	public String getAppStatus() {
		return appStatus;
	}
	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}
	@Column(name = "INTERNALAPPSTATUS")
	public String getInternalAppStatus() {
		return internalAppStatus;
	}
	public void setInternalAppStatus(String internalAppStatus) {
		this.internalAppStatus = internalAppStatus;
	}
	
	@Column(name = "DATEAPPSTATUS")
	public String getDateAppStatus() {
		return dateAppStatus;
	}
	public void setDateAppStatus(String dateAppStatus) {
		this.dateAppStatus = dateAppStatus;
	}
	
	@Column(name = "DATEINTSTATUS")
	public String getDateIntStatus() {
		return dateIntStatus;
	}
	public void setDateIntStatus(String dateIntStatus) {
		this.dateIntStatus = dateIntStatus;
	}
	
	@Column(name = "DATECREATED")
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
}
