package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import entities.Adminpassengerview;
import entities.FlightId;

public class AdminPassengerViewDAOHib implements AdminPassengerViewDAO {

	@Override
	public List<Adminpassengerview> getPassengers(FlightId flightId) {
		List<Adminpassengerview> result = new ArrayList();
    	Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Adminpassengerview.class);
			criteria.add(Restrictions.eq("id.flightId", flightId.getFlightId()));
			criteria.add(Restrictions.eq("id.date", flightId.getDate()));
			result = criteria.list();
			transaction.commit();
		}catch (Exception e){
			
		}finally {
			session.close();
		}
		return result;
	}
}
