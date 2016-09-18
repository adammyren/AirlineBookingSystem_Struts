package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import entities.Flight;
import entities.User;

public class UserDAOHib extends AbstractDAOHib<User,String> implements UserDAO{

	
	public boolean exists(String username, String password){
    	List<Flight> result = new ArrayList();
    	Configuration cfg = new Configuration();
    	cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("username", username));
			criteria.add(Restrictions.eq("password", password));
			result = criteria.list();
			transaction.commit();
		}catch (Exception e){
			
		}finally {
			session.close();
		}
		return !result.isEmpty();
	}

	@Override
	public boolean exists(String key, Class<User> theClass) {
    	List<User> result = new ArrayList();
    	Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(theClass);
			
			criteria.add(Restrictions.eq("username", key));
			result = criteria.list();
			
			transaction.commit();
		}catch (Exception e){
			
		}finally {
			session.close();
		}
		return !result.isEmpty();
	}

	@Override
	public User get(String key, Class<User> theClass) {
    	List<User> result = new ArrayList();
    	Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("username", key));
			result = criteria.list();
			transaction.commit();
		}catch (Exception e){
			
		}finally {
			session.close();
		}
		return result.get(0);
	}
	
	
}
