package com.me.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.me.model.User;

public class UserDao extends DAO {

	public User queryUserByNameAndPassword(String name, String password)
            throws Exception {
        try {
            Criteria cr = getSession().createCriteria(User.class);
            cr.add(Restrictions.like("emailId", name));
	        cr.add(Restrictions.like("password", password));
	        User user=(User)cr.uniqueResult();
            return user;
        } catch (HibernateException e) {
        	close();
            throw new Exception("Could not get User " + name, e);
        }
    }
	public User queryUserById(int id)
            throws Exception {
        try {
            Criteria cr = getSession().createCriteria(User.class);
            cr.add(Restrictions.like("id", id));
	        User user=(User)cr.uniqueResult();
            return user;
        } catch (HibernateException e) {
        	close();
            throw new Exception("Could not get User " + id, e);
        }
    }
	public boolean saveUser(User user)
	{
		try{
			getSession().getTransaction().begin();
			getSession().saveOrUpdate(user);
			getSession().getTransaction().commit();
			return true;
		}
		catch(Exception ex)
		{
			getSession().getTransaction().rollback();
			return false;
		}
	}
	public boolean queryDuplicateUser(String name)
            throws Exception {
        try {
            Criteria cr = getSession().createCriteria(User.class);
	        cr.add(Restrictions.like("emailId", name.trim()));
	        User user=(User) cr.uniqueResult();
	        if(user!=null)
	        {
	        	return true;
	        }
	        else
	        {
	        	return false;
	        }
        } catch (HibernateException e) {
        	close();
            throw new Exception("Could not get user " + name, e);
        }
    }
	
	public boolean changeUserPassword(int id, String password) throws Exception
	{
		try{
			getSession().getTransaction().begin();
			Query q = getSession().createQuery("Update User set password = :password where id= :id");
            q.setString("id", String.valueOf(id));
            q.setString("password",password);
            int rowCount=q.executeUpdate();
            getSession().getTransaction().commit();
            if(rowCount>0)
            {
            	return true;
            }
            return false;
		}
		catch(Exception ex)
		{
			getSession().getTransaction().rollback();
			throw new Exception("Could not change user password " + id, ex);
		}
	}
}
