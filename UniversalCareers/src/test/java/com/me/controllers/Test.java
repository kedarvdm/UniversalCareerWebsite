package com.me.controllers;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.me.dao.HibernateUtil;
import com.me.model.Address;
import com.me.model.Applicant;
import com.me.model.Application;
import com.me.model.Education;
import com.me.model.Employee;
import com.me.model.Employer;
import com.me.model.JobDetails;
import com.me.model.WorkExperience;


public class Test {

	public static void main(String[] args) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction t= session.beginTransaction();
		/*Employee e= new Employee();
		
		Applicant a= new Applicant();
		
		Application ap= new Application();
		
		Employer er= new Employer();
		
		JobDetails job= new JobDetails();
		
		WorkExperience wx= new WorkExperience();
		
		Countries c= new Countries();
		
		Address ad= new Address();
		
		Education ed= new Education();
		
		*/
		t.commit();
		session.close();
	}

}
