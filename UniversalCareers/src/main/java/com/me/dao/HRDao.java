package com.me.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.me.model.Employee;
import com.me.model.JobDetails;

public class HRDao extends DAO {

	public ArrayList<JobDetails> getAllJobs(Employee hr) throws Exception
	{
		/*try {
            Criteria cr = getSession().createCriteria(JobDetails.class);
            cr.add(Restrictions.eq("user", hr));
            cr.add(Restrictions.eq("employer", hr.getEmployer()));
            ArrayList<JobDetails> jobs=(ArrayList<JobDetails>)cr.list();
            return jobs;
        } catch (HibernateException e) {
            throw new Exception("Could not get User " + hr.getFirstName(), e);
        }*/
		
		try{
			Query q = getSession().createQuery("From JobDetails where user = :user and employer=:employer");
            q.setEntity("user",hr);
            q.setEntity("employer", hr.getEmployer());
            ArrayList<JobDetails> jobs=(ArrayList<JobDetails>)q.list();
            return jobs;
		}
		catch(Exception e)
		{
			getSession().getTransaction().rollback();
			throw new Exception("Could not get User " + hr.getFirstName(), e);
		}
		
	}
	
	public JobDetails getJob(int id) throws Exception
	{
		try {
            Criteria cr = getSession().createCriteria(JobDetails.class);
            cr.add(Restrictions.like("id", id));
            JobDetails job=(JobDetails)cr.uniqueResult();
            return job;
        } catch (HibernateException e) {
            throw new Exception("Could not get Job id:" + id, e);
        }
	}
	
	public boolean saveJobDetail(JobDetails job)
	{
		try{
			getSession().getTransaction().begin();
			getSession().saveOrUpdate(job);
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
