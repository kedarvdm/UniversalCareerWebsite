package com.me.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.me.model.WorkExperience;

public class WorkExDao extends DAO {
	public boolean saveWorkEx(WorkExperience workEx)
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
}
