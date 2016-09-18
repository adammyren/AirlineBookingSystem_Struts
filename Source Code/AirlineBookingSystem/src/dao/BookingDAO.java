package dao;

import java.util.List;

import entities.Booking;
import entities.BookingId;
import entities.FlightId;

public interface BookingDAO {
	
	public boolean add(Booking booking);
	public List<Booking> getBookings(String username);
	public boolean delete(BookingId bookingId, Class<Booking> theClass);
	public List<Booking> getBookings(FlightId flightId);
	public boolean add(List<Booking> listOfBookings);
	
}
