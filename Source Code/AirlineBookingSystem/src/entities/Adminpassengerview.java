package entities;

// default package
// Generated 2016-mar-28 22:08:12 by Hibernate Tools 4.3.1.Final

/**
 * Adminpassengerview generated by hbm2java
 */
public class Adminpassengerview extends AbstractEntity<AdminpassengerviewId> implements java.io.Serializable {

	private AdminpassengerviewId id;

	public Adminpassengerview() {
	}

	public Adminpassengerview(AdminpassengerviewId id) {
		this.id = id;
	}

	public AdminpassengerviewId getId() {
		return this.id;
	}

	public void setId(AdminpassengerviewId id) {
		this.id = id;
	}

	@Override
	public AdminpassengerviewId getKey() {
		return id;
	}

	@Override
	public void setKey(AdminpassengerviewId key) {
		this.id = key;
		
	}
	
	@Override
	public String toString(){
		return id.getFirstname() + " " + id.getLastname() + id.getDateOfBirth() + " | Passport Number: " + id.getPassportNr();
		
	}
}
