package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

import entities.Airport;
import entities.Booking;
import entities.BookingId;
import entities.FlightId;
import entities.User;

public class BookingDAOHib extends AbstractDAOHib<Booking,BookingId> implements BookingDAO {

	public List<Booking> getBookings(String username){
    	List result = new ArrayList();
    	Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Booking.class);
			Booking booking = new Booking();
			booking.setUser(username);
			criteria.add(Example.create(booking));
			result = criteria.list();
			System.out.println("DAO: " + result.get(1));
			transaction.commit();
		}catch (Exception e){
			
		}finally {
			session.close();
		}
		return result;
	}
	
	public List<Booking> getBookings(FlightId flightId){
    	List result = new ArrayList();
    	Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Booking.class);
			BookingId bookingid = new BookingId();
			bookingid.setFlightId(flightId.getFlightId());
			bookingid.setDate(flightId.getDate());
			Booking booking = new Booking();
			booking.setId(bookingid);
			criteria.add(Example.create(booking));
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
	public boolean add(List<Booking> listOfBookings) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   for(Booking booking:listOfBookings)
			   session.save(booking);
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
