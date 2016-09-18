package dao;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.persistence.internal.oxm.schema.model.Restriction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import entities.Airport;
import entities.Booking;
import entities.Flight;
import entities.FlightId;

public class FlightDAOHib extends AbstractDAOHib<Flight,FlightId> implements FlightDAO {
	
	public List<Flight> getFlights(String origin, String destination, String date, int nr_of_tickets){
    	List result = new ArrayList();
    	Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Flight.class);

			criteria.add(Restrictions.ilike("id.date",date));
			criteria.add(Restrictions.eq("origin",origin));
			criteria.add(Restrictions.eq("destination",destination));
			criteria.add(Restrictions.ge("freeSeats", nr_of_tickets));
			
			result = criteria.list();
			transaction.commit();
		}catch (Exception e){
			
		}finally {
			session.close();
		}
		return result;		
	}
	
	@Override
	public Flight get(FlightId flightid, Class<Flight> theClass){
    	List<Flight> result = new ArrayList();
    	Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Flight.class);
			criteria.add(Restrictions.eq("id.date", flightid.getDate()));
			criteria.add(Restrictions.eq("id.flightId", flightid.getFlightId()));
			result = criteria.list();
			transaction.commit();
		}catch (Exception e){
			
		}finally {
			session.close();
		}
		return result.get(0);
	}
	
	public boolean exists(FlightId flightid) {
    	List<Flight> result = new ArrayList();
    	Configuration cfg = new Configuration();
    	cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Flight.class);
			criteria.add(Restrictions.eq("id.date", flightid.getDate()));
			criteria.add(Restrictions.eq("id.flightId", flightid.getFlightId()));
			result = criteria.list();
	    	System.out.println("9");
			transaction.commit();
		}catch (Exception e){
			
		}finally {
	    	System.out.println("10");

			session.close();
	    	System.out.println("11");

		}
		return !result.isEmpty();
	}
	
	public boolean update(FlightId flightid, Flight newflight) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   Flight oldflight = (Flight) session.get(Flight.class,flightid);
		   oldflight.setOrigin(newflight.getOrigin());
		   oldflight.setDestination(newflight.getDestination());
		   oldflight.setDepartureTime(newflight.getDepartureTime());
		   oldflight.setDuration(newflight.getDuration());
		   oldflight.setFreeSeats(newflight.getFreeSeats());
		   oldflight.setPrice(newflight.getPrice());
		   oldflight.setCapacity(newflight.getCapacity());
		   session.update(oldflight);
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

	@Override
	public boolean update(String originId, String destinationId, String promotion) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   Criteria criteria = session.createCriteria(Flight.class);
		   criteria.add(Restrictions.eq("origin", originId));
		   criteria.add(Restrictions.eq("destination", destinationId));
		   List<Flight> flightsToUpdate = criteria.list();
		   for(Flight flight:flightsToUpdate){
			   flight.setPromotion(promotion);
			   session.update(flight);
		   }
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


}
