package actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ExitBookingAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> sessionMap;
	
	@Override
	public String execute() throws Exception {
		sessionMap.remove("nrOfTickets");
		sessionMap.remove("listOfFlights");
		sessionMap.remove("listOfReturns");
		sessionMap.remove("flightsToBook");
		sessionMap.remove("listOfPassengers");
		if(sessionMap.get("user")==null)
			return "not_logged_in";
		return SUCCESS;
	}



	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		
	}
	
	

}
