package actions;

import com.opensymphony.xwork2.ActionSupport;

import businessService.BookingService;
import entities.BookingId;
import entities.MybookingselementId;

public class CancelBookingAction extends ActionSupport {
	
	private BookingId bookingId;
	private BookingService bookingService;

	@Override
	public String execute() throws Exception {
		bookingService = new BookingService();
		bookingService.delete(bookingId);		
		return SUCCESS;
	}

	public BookingId getBookingId() {
		return bookingId;
	}

	public void setBookingId(BookingId bookingId) {
		this.bookingId = bookingId;
	}
	
	

}
