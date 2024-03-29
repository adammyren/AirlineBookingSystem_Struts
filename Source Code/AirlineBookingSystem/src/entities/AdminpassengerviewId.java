package entities;

// default package
// Generated 2016-mar-28 22:08:12 by Hibernate Tools 4.3.1.Final

/**
 * AdminpassengerviewId generated by hbm2java
 */
public class AdminpassengerviewId implements java.io.Serializable {

	private String flightId;
	private String date;
	private String passportNr;
	private String firstname;
	private String lastname;
	private String passportExp;
	private String passportIsh;
	private String dateOfBirth;

	public AdminpassengerviewId() {
	}

	public AdminpassengerviewId(String flightId, String date, String passportNr, String firstname, String lastname) {
		this.flightId = flightId;
		this.date = date;
		this.passportNr = passportNr;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public AdminpassengerviewId(String flightId, String date, String passportNr, String firstname, String lastname,
			String passportExp, String passportIsh, String dateOfBirth) {
		this.flightId = flightId;
		this.date = date;
		this.passportNr = passportNr;
		this.firstname = firstname;
		this.lastname = lastname;
		this.passportExp = passportExp;
		this.passportIsh = passportIsh;
		this.dateOfBirth = dateOfBirth;
	}

	public String getFlightId() {
		return this.flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AdminpassengerviewId))
			return false;
		AdminpassengerviewId castOther = (AdminpassengerviewId) other;

		return ((this.getFlightId() == castOther.getFlightId()) || (this.getFlightId() != null
				&& castOther.getFlightId() != null && this.getFlightId().equals(castOther.getFlightId())))
				&& ((this.getDate() == castOther.getDate()) || (this.getDate() != null && castOther.getDate() != null
						&& this.getDate().equals(castOther.getDate())))
				&& ((this.getPassportNr() == castOther.getPassportNr()) || (this.getPassportNr() != null
						&& castOther.getPassportNr() != null && this.getPassportNr().equals(castOther.getPassportNr())))
				&& ((this.getFirstname() == castOther.getFirstname()) || (this.getFirstname() != null
						&& castOther.getFirstname() != null && this.getFirstname().equals(castOther.getFirstname())))
				&& ((this.getLastname() == castOther.getLastname()) || (this.getLastname() != null
						&& castOther.getLastname() != null && this.getLastname().equals(castOther.getLastname())))
				&& ((this.getPassportExp() == castOther.getPassportExp())
						|| (this.getPassportExp() != null && castOther.getPassportExp() != null
								&& this.getPassportExp().equals(castOther.getPassportExp())))
				&& ((this.getPassportIsh() == castOther.getPassportIsh())
						|| (this.getPassportIsh() != null && castOther.getPassportIsh() != null
								&& this.getPassportIsh().equals(castOther.getPassportIsh())))
				&& ((this.getDateOfBirth() == castOther.getDateOfBirth())
						|| (this.getDateOfBirth() != null && castOther.getDateOfBirth() != null
								&& this.getDateOfBirth().equals(castOther.getDateOfBirth())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getFlightId() == null ? 0 : this.getFlightId().hashCode());
		result = 37 * result + (getDate() == null ? 0 : this.getDate().hashCode());
		result = 37 * result + (getPassportNr() == null ? 0 : this.getPassportNr().hashCode());
		result = 37 * result + (getFirstname() == null ? 0 : this.getFirstname().hashCode());
		result = 37 * result + (getLastname() == null ? 0 : this.getLastname().hashCode());
		result = 37 * result + (getPassportExp() == null ? 0 : this.getPassportExp().hashCode());
		result = 37 * result + (getPassportIsh() == null ? 0 : this.getPassportIsh().hashCode());
		result = 37 * result + (getDateOfBirth() == null ? 0 : this.getDateOfBirth().hashCode());
		return result;
	}

}
