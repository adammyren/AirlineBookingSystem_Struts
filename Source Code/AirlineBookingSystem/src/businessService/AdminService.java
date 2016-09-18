package businessService;

import java.util.ArrayList;
import java.util.List;

import dao.AdminPassengerViewDAO;
import dao.AdminPassengerViewDAOHib;
import dao.BookingDAO;
import dao.BookingDAOHib;
import dao.FlightDAO;
import dao.FlightDAOHib;
import dao.PassengerDAO;
import dao.PassengerDAOHib;
import dao.PromotionDAO;
import dao.PromotionDAOHib;
import dao.UserDAO;
import dao.UserDAOHib;
import entities.AbstractEntity;
import entities.Adminpassengerview;
import entities.Booking;
import entities.Flight;
import entities.FlightId;
import entities.Passenger;
import entities.Promotion;
import entities.User;

public class AdminService {
	
	private AdminPassengerViewDAO adminPassengerViewDAO;
	private FlightDAO flightDAO;
	private UserDAO userDAO;
	private PromotionDAO promotionDAO;
	
	public AdminService(){
		adminPassengerViewDAO = new AdminPassengerViewDAOHib();
		flightDAO = new FlightDAOHib();
		userDAO = new UserDAOHib();
		promotionDAO = new PromotionDAOHib();
	}

	public List<Adminpassengerview> getPassengerList(FlightId flightId) {
		return adminPassengerViewDAO.getPassengers(flightId);
	}

	public boolean add(Flight flight) {
		return flightDAO.add(flight);
	}

	public List<User> getAllUsers() {
		return userDAO.getAll(User.class);
	}

	public List<Promotion> getPromotions() {
		return promotionDAO.getAll(Promotion.class);
	}

	public boolean setPromotion(String originId, String destinationId, String promotion) {
		return flightDAO.update(originId, destinationId, promotion);
	}
	

}
