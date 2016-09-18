package actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import businessService.UserService;
import entities.User;

public class RegisterUserAction extends ActionSupport implements SessionAware {
	
	private UserService userService;
	private String username;
	private String password;
	private String email;
	private String passwordRepeat;
	private String admin;
	private Map<String, Object> sessionMap;
	private final String BOOKING_ACTIVE = "in_booking";

	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

	@Override
	public String execute() throws Exception {
		userService = new UserService();
		User newUser = new User(username, password, email, getAdmin());
		userService.registerUser(newUser);
		sessionMap.put("user", newUser);
		if(sessionMap.get("target").equals("displayConfirm"))
			return BOOKING_ACTIVE;
		return SUCCESS;
		
	}
	
	@Override
	public void validate() {
		userService = new UserService();
		boolean userExists = userService.exists(username);
		if(username.isEmpty()||password.isEmpty()||passwordRepeat.isEmpty()||email.isEmpty())
			addFieldError("username", "Please fill out all fields");
		else if(!password.equals(passwordRepeat))
			addFieldError("password", "The passwords does not match");
		else if(!email.contains("@"))
			addFieldError("email", "not a valid email address");
		else if(userExists)
			addFieldError("username", "User with that username already exists");
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		
	}
}
