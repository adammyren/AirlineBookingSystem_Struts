package actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import businessService.UserService;
import entities.Mybookingselement;
import entities.User;

public class PrepareMyPagesAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> sessionMap;
	private UserService userService;
	private List<Mybookingselement> bookingElements;

	@Override
	public String execute() throws Exception {
		System.out.println("IN PREPARE MYPAGES ACTION");
		User user = (User) sessionMap.get("user");
		userService = new UserService();
		setBookingElements(userService.getElements(user));
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public List<Mybookingselement> getBookingElements() {
		return bookingElements;
	}

	public void setBookingElements(List<Mybookingselement> bookingElements) {
		this.bookingElements = bookingElements;
	}
	
	

}
