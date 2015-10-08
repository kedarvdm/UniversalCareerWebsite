package com.me.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
@Inheritance(strategy= InheritanceType.JOINED)
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String emailId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String password;
	private String companyName;
	private String role;
	private String dateCreated;
	
	private Address address;
	
	public User()
	{
		address=new Address();
	}
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "EMAILID")
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Column(name = "FIRSTNAME")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "MIDDLENAME")
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	@Column(name = "LASTNAME")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name="PASSWORD")	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "COMPANYNAME")
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Column(name = "ROLE")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Column(name = "DATECREATED")
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRESS_FK")
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
