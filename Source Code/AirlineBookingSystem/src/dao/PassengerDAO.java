 package dao;

import java.util.List;

import entities.Booking;
import entities.FlightId;
import entities.Passenger;

public interface PassengerDAO {
	
	public Passenger get(String passportnr);
	public boolean add(Passenger passenger);
	public boolean exists(String passportnr);
	public List<Passenger> getAll(Class<Passenger> theClass);

}
