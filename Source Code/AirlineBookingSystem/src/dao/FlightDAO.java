package dao;

import java.util.List;

import entities.Airport;
import entities.Flight;
import entities.FlightId;

public interface FlightDAO {
	
	public List<Flight> getFlights(String origin, String destination, String date, int nr_of_tickets);
	public Flight get(FlightId flightid, Class<Flight> theClass);
	public boolean exists(FlightId flightid);
	public boolean add(Flight flight);
	public boolean update(FlightId flightid, Flight newflight);
	public boolean update(String originId, String destinationId, String promotion);

}
