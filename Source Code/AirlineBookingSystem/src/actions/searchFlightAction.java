package actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import Utilities.BookingUtilities;
import businessService.BookingService;
import entities.Flight;

public class searchFlightAction extends ActionSupport implements SessionAware {
	
	private String origin;
	private String destination;
	private String flightDate;
	private String returnDate;
	private String nrOfTickets;
	private String typeOfTrip;
	private List<Flight> listOfFlights;
	private List<Flight> listOfReturns;
	private BookingService bookingService;
	private Map<String, Object> sessionMap;
	
	@Override
	public String execute() throws Exception {
		bookingService = new BookingService();
		nrOfTickets = nrOfTickets.split(" ")[0]; //Format
		try{
		origin = origin.split("-")[1].replace(" ", ""); //Format
		destination = destination.split("-")[1].replace(" ", ""); //Format
		}catch (Exception e){
			return INPUT;
		}
		listOfFlights = bookingService.getFlights(origin, destination, flightDate, nrOfTickets);
		if(listOfFlights.isEmpty()){
			addFieldError("origin", "No Flights Available on that date");
			return INPUT;
		}	
		
		if(typeOfTrip.equals("Return")){
			listOfReturns = bookingService.getFlights(destination, origin, flightDate, nrOfTickets);
			if(listOfReturns.isEmpty()){
				addFieldError("origin", "No Flights Available on that date");
				return INPUT;
			}
			sessionMap.put("listOfReturns", listOfReturns);	
		}
		sessionMap.put("listOfFlights", listOfFlights);
		sessionMap.put("nrOfTickets", nrOfTickets);
		return SUCCESS;
	}

	@Override
	public void validate() {
		//One-Way
		if(typeOfTrip.equals("One-Way")){
			boolean dateCorrect = BookingUtilities.validateDate(flightDate);
			if(!dateCorrect)
				addFieldError("flightDate","Invalid Date");
		}
		//Return
		else
		{
			boolean dateCorrect = BookingUtilities.validateDate(flightDate);
			boolean returnDateCorrect = BookingUtilities.validateDate(flightDate);
			if(!dateCorrect||!returnDateCorrect)
				addFieldError("flightDate","Invalid Date");
		}
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getNrOfTickets() {
		return nrOfTickets;
	}

	public void setNrOfTickets(String nrOfTickets) {
		this.nrOfTickets = nrOfTickets;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getTypeOfTrip() {
		return typeOfTrip;
	}

	public void setTypeOfTrip(String typeOfTrip) {
		this.typeOfTrip = typeOfTrip;
	}

	public List<Flight> getListOfFlights() {
		return listOfFlights;
	}

	public void setListOfFlights(List<Flight> listOfFlights) {
		this.listOfFlights = listOfFlights;
	}

	public List<Flight> getListOfReturns() {
		return listOfReturns;
	}

	public void setListOfReturns(List<Flight> listOfReturns) {
		this.listOfReturns = listOfReturns;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		
	}


	
	
	
	

}
