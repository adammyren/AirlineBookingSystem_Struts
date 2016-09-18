package actions;

import com.opensymphony.xwork2.ActionSupport;

import businessService.AdminService;
import entities.Flight;
import entities.FlightId;

public class AddFlightAction extends ActionSupport {

	private String flightId;
	private String date;
	private String departureTime;
	private String duration;
	private String capacity;
	private String origin;
	private String destination;
	private String price;
	private AdminService adminService;
	
	@Override
	public String execute() throws Exception {
		Flight flight = new Flight(new FlightId(flightId,date),departureTime,duration,Integer.parseInt(capacity),Integer.parseInt(capacity),origin,destination,price,"No");
		adminService = new AdminService();
		boolean success = adminService.add(flight);
		return SUCCESS;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
	
}
