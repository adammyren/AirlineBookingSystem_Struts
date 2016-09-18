package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import entities.Flight;
import entities.Mybookingselement;
import entities.MybookingselementId;

public class MyBookingsElementDAOHib extends AbstractDAOHib<Mybookingselement,MybookingselementId> implements MyBookingsElementDAO {

	@Override
	public List<Mybookingselement> getElements(String username) {
    	List<Mybookingselement> result = new ArrayList();
    	Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Mybookingselement.class);
			System.out.println(username);
			//criteria.add(Restrictions.eq("id.user", username));
			result = criteria.list();
			transaction.commit();
		}catch (Exception e){
			
		}finally {
			session.close();
		}
		return result;	
	}




}
