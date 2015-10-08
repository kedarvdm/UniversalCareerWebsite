package com.me.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.me.model.Employee;
import com.me.model.User;

public class EmployeeDao extends DAO{
	public Employee queryEmployeeByNameAndPassword(String name, String password)
            throws Exception {
        try {
            Criteria cr = getSession().createCriteria(Employee.class);
	        cr.add(Restrictions.like("emailId", name));
	        cr.add(Restrictions.like("password", password));
	        Employee employee=(Employee)cr.uniqueResult();
            return employee;
        } catch (HibernateException e) {
        	close();
            throw new Exception("Could not get Employer " + name, e);
        }
    }
	
	public Employee queryEmployeeById(int id) throws Exception
	{
		try
		{
			Criteria cr = getSession().createCriteria(Employee.class);
	        cr.add(Restrictions.like("id", id));
	        Employee employee=(Employee) cr.uniqueResult();
	        return employee;
		}
		catch(Exception ex)
		{
			getSession().close();
			throw new Exception("Could not get Employee id=" + id);
		}
		
	}
}
