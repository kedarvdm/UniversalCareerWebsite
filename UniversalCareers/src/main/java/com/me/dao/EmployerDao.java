package com.me.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.me.model.Employee;
import com.me.model.Employer;
import com.me.model.User;

public class EmployerDao extends DAO {
	public Employer queryEmployerByNameAndPassword(String name, String password)
            throws Exception {
        try {
            Criteria cr = getSession().createCriteria(Employer.class);
	        cr.add(Restrictions.like("emailId", name));
	        cr.add(Restrictions.like("password", password));
	        Employer employer=(Employer)cr.uniqueResult();
            return employer;
        } catch (HibernateException e) {
        	close();
            throw new Exception("Could not get Employer " + name, e);
        }
    }
	
	public boolean deleteEmployees(String employeeIds[])
	{
		try{
			
			for(String employeeId:employeeIds)
			{
				Criteria cr = getSession().createCriteria(Employee.class);
		        cr.add(Restrictions.like("id", Integer.parseInt(employeeId)));
		        Employee e=(Employee) cr.uniqueResult();
		        getSession().getTransaction().begin();
		        getSession().delete(e);
				getSession().getTransaction().commit();
			}
			return true;
		}
		catch(Exception ex)
		{
			getSession().getTransaction().rollback();
			return false;
		}
	}
}
