package com.me.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private User user;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String country;
	private String zip;
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
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="address")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Column(name = "STREET1")
	public String getStreet1() {
		return street1;
	}	
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	@Column(name = "STREET2")
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
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
	@Column(name = "ZIP")
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Column(name = "DATECREATED")
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
}
