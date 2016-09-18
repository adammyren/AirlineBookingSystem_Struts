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

import entities.Airport;
import entities.User;

public class AirportDAOHib extends AbstractDAOHib<Airport,String> implements AirportDAO {

    /**
     * Default constructor. 
     */
    public AirportDAOHib() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Airport> getAirportID(String city){
    	List result = new ArrayList();
    	Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Airport.class);
			Airport airport = new Airport();
			airport.setAirportCity(city);
			criteria.add(Example.create(airport));
			result = criteria.list();
			System.out.println("DAO: " + result.get(1));
			transaction.commit();
		}catch (Exception e){
			
		}finally {
			session.close();
		}
		return result;
    }

	@Override
	public boolean exists(String airportId) {
    	List<Airport> result = new ArrayList();
    	Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Airport.class);
			
			criteria.add(Restrictions.eq("airportId", airportId));
			result = criteria.list();
			
			transaction.commit();
		}catch (Exception e){
			
		}finally {
			session.close();
		}
		return !result.isEmpty();
	}

	@Override
	public Airport get(String airportId) {
    	List<Airport> result = new ArrayList();
    	Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Airport.class);
			criteria.add(Restrictions.eq("airportId", airportId));
			transaction.commit();
		}catch (Exception e){
			
		}finally {
			session.close();
		}
		return result.get(0);
	}
}
