package businessService;

import java.util.ArrayList;
import java.util.List;

import dao.BookingDAO;
import dao.BookingDAOHib;
import dao.FlightDAO;
import dao.FlightDAOHib;
import dao.PassengerDAO;
import dao.PassengerDAOHib;
import entities.Booking;
import entities.BookingId;
import entities.Flight;
import entities.FlightId;
import entities.Passenger;
import entities.User;

public class BookingService {
	
	private BookingDAO bookingDAO;
	private FlightDAO flightDAO;
	private PassengerDAO passengerDAO;
	
	public BookingService(){
		bookingDAO = new BookingDAOHib();
		flightDAO = new FlightDAOHib();
		passengerDAO = new PassengerDAOHib();
	}

	public List<Flight> getFlights(String origin, String destination, String date, String nrOfTickets) {
		System.out.println(origin);
		System.out.println(destination);
		System.out.println(date);
		System.out.println(nrOfTickets);
		return flightDAO.getFlights(origin, destination, date, Integer.parseInt(nrOfTickets));
	}

	public boolean bookFlights(List<Passenger> listOfPassengers, List<FlightId> listOfFlights, User user) {
		List<Booking>listOfBookings = new ArrayList<Booking>();
		for(Passenger passenger:listOfPassengers){
			for(FlightId flightId:listOfFlights){
				BookingId bookingId = new BookingId(flightId.getFlightId(),passenger.getPassportNr(),flightId.getDate());
				Booking booking = new Booking(bookingId,user.getUsername(),"booked");
				listOfBookings.add(booking);
			}
		}
		for(Passenger passenger:listOfPassengers){
			if(!passengerDAO.exists(passenger.getPassportNr()))
				passengerDAO.add(passenger);
		}
		return bookingDAO.add(listOfBookings);
	}

	public boolean delete(BookingId bookingId) {
		return bookingDAO.delete(bookingId, Booking.class);
	}

	public Flight get(FlightId flightId) {
		return flightDAO.get(flightId, Flight.class);
	}

}
