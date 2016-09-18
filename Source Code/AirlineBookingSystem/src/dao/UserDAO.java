package dao;

import java.util.List;

import entities.User;

public interface UserDAO {
	
	public boolean add(User user);
	public boolean exists(String username, Class<User> theClass);
	public User get(String username, Class<User> theClass);
	public List<User> getAll(Class<User> theClass);
	public boolean exists(String username, String password);


}
