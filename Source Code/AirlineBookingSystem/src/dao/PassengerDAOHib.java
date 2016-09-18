package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import entities.Booking;
import entities.Flight;
import entities.FlightId;
import entities.Passenger;
import entities.User;

public class PassengerDAOHib extends AbstractDAOHib<Passenger,String> implements PassengerDAO {
	
	
	public boolean exists(String passportnr){
    	List<Passenger> result = new ArrayList();
    	Configuration cfg = new Configuration();
    	cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Passenger.class);
			criteria.add(Restrictions.eq("passportNr", passportnr));
			result = criteria.list();
			transaction.commit();
		}catch (Exception e){
			
		}finally {
			session.close();
		}
		return !result.isEmpty();
		
	}

	@Override
	public Passenger get(String passportnr) {
    	List<Passenger> result = new ArrayList();
    	Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Passenger.class);
			criteria.add(Restrictions.eq("passportNr", passportnr));
			result = criteria.list();
			transaction.commit();
		}catch (Exception e){
			
		}finally {
			session.close();
		}
		return result.get(0);
	}
}
