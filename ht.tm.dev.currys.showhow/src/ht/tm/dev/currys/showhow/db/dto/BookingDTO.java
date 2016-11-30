package ht.tm.dev.currys.showhow.db.dto;

import java.sql.Date;

public class BookingDTO {
	
	public static String selectByID = "select * from bookings where id = ?";
	int id;
	String title;
	String name;
	String telephone;
	Date bookingDate;
	int bookingTime;
	Date createdOn;
	int createdBy;
	
	public BookingDTO(int id, String title, String name, String telephone, Date bookingDate, int bookingTime,
			Date createdOn, int createdBy) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.telephone = telephone;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
	}
	
	
}
