package actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import businessService.UserService;
import entities.Mybookingselement;
import entities.User;

public class LoginAction extends ActionSupport implements SessionAware{

	private String username;
	private String password;
	private UserService userService;
	private Map<String, Object> sessionMap;
	private List<Mybookingselement> bookingElements;
	private final String BOOKING_ACTIVE = "in_booking";
	private final String ADMIN = "admin";

	public List<Mybookingselement> getBookingElements() {
		return bookingElements;
	}

	public void setBookingElements(List<Mybookingselement> bookingElements) {
		this.bookingElements = bookingElements;
	}

	@Override
	public String execute() throws Exception {
		userService = new UserService();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		//Check if a user with that username and password exists
		boolean userValid = userService.validateUser(user);
		if (!userValid){
			addFieldError("username", "Wrong Username or Password");
			return INPUT;
		}
		//Get all information about user
		user = userService.getUser(username);
		sessionMap.put("user", user);
		if(sessionMap.get("target").equals("displayConfirm"))
			return BOOKING_ACTIVE;
		if(user.getAdmin().equals("true")){
			return ADMIN;
		}else
			return SUCCESS;
	}


	@Override
	public void validate() {
		if (username.isEmpty() || password.isEmpty())
			addFieldError("username", "Please fill out all fields");
			
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
