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

import entities.AbstractEntity;
import entities.Booking;
import entities.Flight;
import entities.User;
//Abstract class for basic DAO functionality for Hibernate
public abstract class AbstractDAOHib <Entity extends AbstractEntity<Key>,Key> {

	
	private Session session;

	public boolean add(Entity entity){
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   session.save(entity);
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		   return false;
		}finally {
		   session.close();
		}
		return true;
	}

	public boolean delete(Key key, Class<Entity> theClass){
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   Entity entity = theClass.newInstance();
		   entity.setKey(key);
		   session.delete(entity);
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		   return false;
		}finally {
		   session.close();
		   
		}
		return true;	
	}
	
	public List<Entity> getAll(Class<Entity> theClass){
    	List<Entity> result = new ArrayList();
    	Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(theClass);
			result = criteria.list();
			transaction.commit();
		}catch (Exception e){
			
		}finally {
			session.close();
		}
		return result;
	}
	

	
}
