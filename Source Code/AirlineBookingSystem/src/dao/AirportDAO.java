package dao;

import java.util.List;

import entities.Airport;
import entities.User;

public interface AirportDAO {

	public List<Airport> getAirportID(String city);
	public boolean add(Airport airport);
	public boolean exists(String airportId);
	public Airport get(String airportId);
	public List<Airport> getAll(Class<Airport> theClass);
}
