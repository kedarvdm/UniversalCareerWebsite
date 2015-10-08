package com.me.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.me.model.Applicant;
import com.me.model.Application;
import com.me.model.Education;
import com.me.model.JobDetails;
import com.me.model.User;
import com.me.model.WorkExperience;
import com.me.utils.SearchingCriteria;

public class ApplicantDao extends DAO {
	public Applicant queryApplicantByNameAndPassword(String name, String password)
            throws Exception {
        try {
            Criteria cr = getSession().createCriteria(Applicant.class);
	        cr.add(Restrictions.like("emailId", name));
	        cr.add(Restrictions.like("password", password));
	        Applicant applicant=(Applicant)cr.uniqueResult();
            return applicant;
        } catch (HibernateException e) {
            throw new Exception("Could not get Applicant " + name, e);
        }
    }
	public WorkExperience getWorkExDetails(User user) throws Exception
	{
		try {
            Criteria cr = getSession().createCriteria(WorkExperience.class);
	        cr.add(Restrictions.like("user", user));
	        WorkExperience workEx=(WorkExperience)cr.uniqueResult();
            return workEx;
        } catch (HibernateException e) {
            throw new Exception("Could not get Work Experience" + user.getFirstName(), e);
        }
	}
	public Education getEducationDetails(User user) throws Exception
	{
		try {
            Criteria cr = getSession().createCriteria(Education.class);
	        cr.add(Restrictions.like("user", user));
	        Education education=(Education)cr.uniqueResult();
            return education;
        } catch (HibernateException e) {
            throw new Exception("Could not get Work Experience" + user.getFirstName(), e);
        }
	}
	
	public ArrayList<JobDetails> searchJobsByCriteria(SearchingCriteria sc) throws Exception
	{
		
		try{
			String query;
			query= "From JobDetails where jobTitle like :jobTitle And 1=1 ";
			if(!sc.getCity().equalsIgnoreCase(""))
			{
				query=query+" And city=:city";
			}
			if(!sc.getState().equalsIgnoreCase(""))
            {
				query=query+" and state=:state";
            }
			Query q = getSession().createQuery(query);
			q.setString("jobTitle",sc.getJobTitle()+"%");
			if(!sc.getCity().equalsIgnoreCase(""))
			{
				q.setString("city",sc.getCity()+"%");
			}
			if(!sc.getState().equalsIgnoreCase(""))
            {
				q.setString("state",sc.getState()+"%");
            }
            
            ArrayList<JobDetails> jobs=(ArrayList<JobDetails>)q.list();
            return jobs;
		}
		catch(Exception e)
		{
			throw new Exception("Could not get Job Details ", e);
		}
		
		/*try {
            Criteria cr = getSession().createCriteria(JobDetails.class);
            if(!sc.getJobTitle().equalsIgnoreCase(""))
            {
            	cr.add(Restrictions.ilike("jobTitle", "%"+sc.getJobTitle()+"%"));
            }
            if(!sc.getCity().equalsIgnoreCase(""))
            {
            	cr.add(Restrictions.ilike("city", sc.getJobTitle()+"%"));
            }
            if(!sc.getState().equalsIgnoreCase(""))
            {
            	cr.add(Restrictions.ilike("state", sc.getJobTitle()+"%"));
            }
            
            ArrayList<JobDetails> jobs=(ArrayList<JobDetails>)cr.list();
            return jobs;
        } catch (HibernateException e) {
            throw new Exception("Could not get Job Details ", e);
        }*/
	}
	
	public JobDetails searchJobsById(int id) throws Exception
	{
		try {
            Criteria cr = getSession().createCriteria(JobDetails.class);
            cr.add(Restrictions.eq("id", id));
            JobDetails job=(JobDetails)cr.uniqueResult();
            return job;
        } catch (HibernateException e) {
            throw new Exception("Could not get Job Details ", e);
        }
	}
	
	public boolean saveEducationalDetails(Education education)
	{
		try{
			getSession().getTransaction().begin();
			getSession().saveOrUpdate(education);
			getSession().getTransaction().commit();
			return true;
		}
		catch(Exception ex)
		{
			getSession().getTransaction().rollback();
			return false;
		}
	}
	public boolean saveWork(WorkExperience workEx)
	{
		try{
			getSession().getTransaction().begin();
			getSession().saveOrUpdate(workEx);
			getSession().getTransaction().commit();
			return true;
		}
		catch(Exception ex)
		{
			getSession().getTransaction().rollback();
			return false;
		}
	}
	
	public boolean checkIfAlreadyApplied(User user, JobDetails job) throws Exception
	{
		try {
            Criteria cr = getSession().createCriteria(Application.class);
            cr.add(Restrictions.eq("user", user));
            cr.add(Restrictions.eq("job", job));
            cr.setProjection(Projections.rowCount());
            Long count = (Long) cr.uniqueResult();
            if(count>0)
            {
            	return true;
            }
            else
            {
            	return false;
            }
        } catch (HibernateException e) {
            throw new Exception("Could not get Job Details ", e);
        }
	}
	
	public boolean submitApplication(Application application)
	{
		try{
			getSession().getTransaction().begin();
			getSession().saveOrUpdate(application);
			getSession().getTransaction().commit();
			return true;
		}
		catch(Exception ex)
		{
			getSession().getTransaction().rollback();
			return false;
		}
	}
}
