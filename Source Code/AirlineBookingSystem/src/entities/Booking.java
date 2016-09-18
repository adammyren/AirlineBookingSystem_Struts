package entities;

// default package
// Generated 2016-mar-22 19:24:14 by Hibernate Tools 4.3.1.Final

/**
 * Booking generated by hbm2java
 */
public class Booking extends AbstractEntity<BookingId> implements java.io.Serializable {

	private BookingId id;
	private String user;
	private String status;

	public Booking() {
	}

	public Booking(BookingId id) {
		this.id = id;
	}

	public Booking(BookingId id, String user, String status) {
		this.id = id;
		this.user = user;
		this.status = status;
	}

	public BookingId getId() {
		return this.id;
	}

	public void setId(BookingId id) {
		this.id = id;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BookingId getKey() {
		return id;
	}

	@Override
	public void setKey(BookingId key) {
		id = key;
	}

}