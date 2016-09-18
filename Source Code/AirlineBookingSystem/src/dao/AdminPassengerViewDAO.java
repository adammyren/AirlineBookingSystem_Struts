package dao;

import java.util.List;

import entities.Adminpassengerview;
import entities.FlightId;

public interface AdminPassengerViewDAO {
	
	public List<Adminpassengerview> getPassengers(FlightId flightId);

}
