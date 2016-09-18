package actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import Utilities.BookingUtilities;
import entities.Passenger;
import entities.User;


public class SavePassengerInformationAction extends ActionSupport implements SessionAware {
	
	private String[] firstname;
	private String[] lastname;
	private String[] dateOfBirth;
	private String[] passportNr;
	private String[] passportExp;
	private String[] passportIsh;
	private Map<String,Object> sessionMap;
	

	@Override
	public String execute() throws Exception {
		List<Passenger> listOfPassengers = new ArrayList<Passenger>();
		for(int i = 0;i<firstname.length;i++){
			Passenger passenger = new Passenger(passportNr[i],firstname[i],lastname[i],passportExp[i],passportIsh[i],dateOfBirth[i]);
			listOfPassengers.add(passenger);
		}
		sessionMap.put("listOfPassengers", listOfPassengers);
		for(Passenger p:listOfPassengers){
		System.out.println(p.getFirstname());
		}
		return SUCCESS;
	}

	@Override
	public void validate() {
	}

	public String[] getFirstname() {
		return firstname;
	}

	public void setFirstname(String[] firstname) {
		this.firstname = firstname;
	}

	public String[] getLastname() {
		return lastname;
	}

	public void setLastname(String[] lastname) {
		this.lastname = lastname;
	}

	public String[] getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String[] dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String[] getPassportNr() {
		return passportNr;
	}

	public void setPassportNr(String[] passportNr) {
		this.passportNr = passportNr;
	}

	public String[] getPassportExp() {
		return passportExp;
	}

	public void setPassportExp(String[] passportExp) {
		this.passportExp = passportExp;
	}

	public String[] getPassportIsh() {
		return passportIsh;
	}

	public void setPassportIsh(String[] passportIsh) {
		this.passportIsh = passportIsh;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	
	

}
