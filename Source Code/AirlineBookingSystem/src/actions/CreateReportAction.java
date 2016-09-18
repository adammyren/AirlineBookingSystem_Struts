package actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import businessService.AdminService;
import entities.AbstractEntity;
import entities.FlightId;

public class CreateReportAction extends ActionSupport implements SessionAware {
	
	private List<? extends AbstractEntity> listOfEntities;
	private AdminService adminService;
	private FlightId flightId;
	private String typeOfEntity;
	private String heading;
	private Map<String, Object> sessionMap;

	@Override
	public String execute() throws Exception {
		switch(getTypeOfEntity()){
		case "Passenger":
			createPassengerReport();
			break;
		case "User":
			createUserReport();
			break;
		}
		sessionMap.put("listOfEntities", listOfEntities);
		return SUCCESS;
	}
	
	private void createUserReport() {
		adminService = new AdminService();
		setListOfEntities(adminService.getAllUsers());
		setHeading("All Active Users");
	}

	public void createPassengerReport(){
		adminService = new AdminService();
		setListOfEntities(adminService.getPassengerList(getFlightId()));
		setHeading("Passengers on Flight " + flightId.getFlightId() + " on " + flightId.getDate());
	}

	public List<? extends AbstractEntity> getListOfEntities() {
		return listOfEntities;
	}

	public void setListOfEntities(List<? extends AbstractEntity> listOfEntities) {
		this.listOfEntities = listOfEntities;
	}

	public FlightId getFlightId() {
		return flightId;
	}

	public void setFlightId(FlightId flightId) {
		this.flightId = flightId;
	}

	public String getTypeOfEntity() {
		return typeOfEntity;
	}

	public void setTypeOfEntity(String typeOfEntity) {
		this.typeOfEntity = typeOfEntity;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		
	}

}
