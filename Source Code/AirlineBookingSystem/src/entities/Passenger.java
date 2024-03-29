package entities;

// default package
// Generated 2016-mar-22 19:24:14 by Hibernate Tools 4.3.1.Final

/**
 * Passenger generated by hbm2java
 */
public class Passenger extends AbstractEntity<String> implements java.io.Serializable {

	private String passportNr;
	private String firstname;
	private String lastname;
	private String passportExp;
	private String passportIsh;
	private String dateOfBirth;

	public Passenger() {
	}

	public Passenger(String passportNr, String firstname, String lastname) {
		this.passportNr = passportNr;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Passenger(String passportNr, String firstname, String lastname, String passportExp, String passportIsh,
			String dateOfBirth) {
		this.passportNr = passportNr;
		this.firstname = firstname;
		this.lastname = lastname;
		this.passportExp = passportExp;
		this.passportIsh = passportIsh;
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassportNr() {
		return this.passportNr;
	}

	public void setPassportNr(String passportNr) {
		this.passportNr = passportNr;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassportExp() {
		return this.passportExp;
	}

	public void setPassportExp(String passportExp) {
		this.passportExp = passportExp;
	}

	public String getPassportIsh() {
		return this.passportIsh;
	}

	public void setPassportIsh(String passportIsh) {
		this.passportIsh = passportIsh;
	}

	public String getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String getKey() {
		return passportNr;
	}

	@Override
	public void setKey(String key) {
		passportNr = key;
		
	}

}
