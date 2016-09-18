package actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import businessService.BookingService;
import entities.Flight;
import entities.FlightId;

public class selectFlightAction extends ActionSupport implements SessionAware {
	
	private String flightOut;
	private String returnFlight;
	private FlightId returnFlightId;
	private FlightId flightOutId;
	private List<FlightId> flightsToBook;
	private List<Flight> flightInformation;
	private Map<String, Object> sessionMap;
	private BookingService bookingService;
	private int totalPrice;

	@Override
	public String execute() throws Exception {
		bookingService = new BookingService();
		flightsToBook = new ArrayList<FlightId>();
		flightInformation = new ArrayList<Flight>();
		FlightId flightOutId = createFlightId(flightOut);
		flightsToBook.add(flightOutId);
		Flight flightOut = bookingService.get(flightOutId);
		flightInformation.add(flightOut);
		totalPrice = Integer.parseInt(flightOut.getPrice()) * Integer.parseInt((String) sessionMap.get("nrOfTickets"));
		if(returnFlight!=null){
			returnFlightId = createFlightId(returnFlight);
			flightsToBook.add(returnFlightId);
			Flight returnFlight = bookingService.get(returnFlightId);
			flightInformation.add(returnFlight);
			totalPrice = totalPrice + Integer.parseInt(returnFlight.getPrice()) * Integer.parseInt((String) sessionMap.get("nrOfTickets"));
		}
		sessionMap.remove("listOfFlights");
		sessionMap.remove("listOfReturns");
		sessionMap.put("flightsToBook", flightsToBook);
		sessionMap.put("flightInformation", flightInformation);
		sessionMap.put("totalPrice", totalPrice);
		return SUCCESS;
	}




	private FlightId createFlightId(String flightString) {
		String[] stringArray = flightString.split(" | ");
		for(int i =0;i<stringArray.length;i++){
			System.out.println(stringArray[i]);
			
		}
		String flightFlightId = stringArray[0].replace(" ", "");
		String flightDate = stringArray[2].replace(" ", "");
		return new FlightId(flightFlightId,flightDate);
	}



	public String getReturnFlight() {
		return returnFlight;
	}

	public void setReturnFlight(String returnFlight) {
		this.returnFlight = returnFlight;
	}



	public String getFlightOut() {
		return flightOut;
	}



	public void setFlightOut(String flightOut) {
		this.flightOut = flightOut;
	}



	public FlightId getReturnFlightId() {
		return returnFlightId;
	}



	public void setReturnFlightId(FlightId returnFlightId) {
		this.returnFlightId = returnFlightId;
	}



	public FlightId getFlightOutId() {
		return flightOutId;
	}



	public void setFlightOutId(FlightId flightOutId) {
		this.flightOutId = flightOutId;
	}



	public List<FlightId> getFlightsToBook() {
		return flightsToBook;
	}



	public void setFlightsToBook(List<FlightId> flightsToBook) {
		this.flightsToBook = flightsToBook;
	}



	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		
	}



	public int getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}



	
}
