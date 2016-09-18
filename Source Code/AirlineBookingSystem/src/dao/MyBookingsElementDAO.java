package dao;

import java.util.List;

import entities.Flight;
import entities.FlightId;
import entities.Mybookingselement;
import entities.MybookingselementId;

public interface MyBookingsElementDAO {
	
	public List<Mybookingselement> getElements(String username);

}
