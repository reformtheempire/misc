package ht.tm.dev.currys.showhow.db.util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

import ht.tm.dev.currys.showhow.db.dto.BookingDTO;

public class BookingSQLUtilTest {

	@Test
	public void testGetBookingByID() {
		BookingDTO booking = BookingSQLUtil.getBookingByID(1);

		System.out.println(booking.toString());
	}

	@Test
	public void testCreateBooking(){
		Date date = new Date(Calendar.getInstance().getTime().getTime());

		BookingDTO booking = new BookingDTO(0, "Mr", "Testy Testerton", "01234 534321", date, 1, date, 1);
		
		BookingDTO newBooking = BookingSQLUtil.createBooking(booking);
				
		System.out.println(newBooking);
	}
	
	@Test
	public void testGetBookingsByDate(){
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		
		ArrayList<BookingDTO> bookings = BookingSQLUtil.getBookingsByDate(date);
		
		for (BookingDTO bookingDTO : bookings) {
			System.out.println(bookingDTO);
		}
	}
	
	@Test
	public void testGetCountByDate(){
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		System.out.println(BookingSQLUtil.getCountByDate(date));
	}
}
