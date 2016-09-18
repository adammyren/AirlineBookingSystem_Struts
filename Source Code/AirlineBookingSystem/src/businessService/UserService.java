 package businessService;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import dao.MyBookingsElementDAO;
import dao.MyBookingsElementDAOHib;
import dao.UserDAO;
import dao.UserDAOHib;
import entities.Mybookingselement;
import entities.User;

public class UserService implements SessionAware{
	
	private UserDAO userDAO;
	private MyBookingsElementDAO elementsDAO;
	private Map<String, Object> sessionMap;
	
	public UserService(){
		userDAO = new UserDAOHib();
		elementsDAO = new MyBookingsElementDAOHib();
	}
	
	public boolean validateUser(User user) {
		return userDAO.exists(user.getUsername(), user.getPassword());
	}

	public boolean registerUser(User newUser) {
		return userDAO.add(newUser);
	}

	public boolean exists(String username) {
		return userDAO.exists(username, User.class);
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;
	}

	public User getUser(String username) {
		return userDAO.get(username, User.class);
	}

	public List<Mybookingselement> getElements(User user) {
		return elementsDAO.getElements(user.getUsername());
	}
}

