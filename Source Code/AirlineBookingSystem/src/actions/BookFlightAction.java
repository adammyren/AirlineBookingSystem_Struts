package actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import businessService.BookingService;
import entities.Flight;
import entities.FlightId;
import entities.Passenger;
import entities.User;

public class BookFlightAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> sessionMap;
	private BookingService bookingService;
	

	@Override
	public String execute() throws Exception {
		List<Passenger> listOfPassengers = (List<Passenger>) sessionMap.get("listOfPassengers");
		List<FlightId> flightsToBook = (List<FlightId>) sessionMap.get("flightsToBook");
		User user = (User)sessionMap.get("user");
		bookingService = new BookingService();
		System.out.println("BOOKING STATUS: " + bookingService.bookFlights(listOfPassengers, flightsToBook, user));
		return SUCCESS;
	}



	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

}
