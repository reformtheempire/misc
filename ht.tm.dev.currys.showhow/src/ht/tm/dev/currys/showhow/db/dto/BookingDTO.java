package ht.tm.dev.currys.showhow.db.dto;

import java.sql.Date;

public class BookingDTO {

	public static final String selectByID = "select * from bookings where id = ?";
	public static final String selectAllOnSpecifiedDate = "select * from bookings where booking_date = ?";
	public static final String selectBetweenTwoDates = "select * from bookings where booking_date between ? and ? order by booking_date asc";
	public static final String insert = "insert into bookings (title, name, telephone, booking_date, booking_time, created_on, created_by) values (?,?,?,?,?,?,?)";
	public static final String updateWhereIDEquals = "update bookings set title = ?, name = ?, telephone = ?, booking_date = ?, booking_time = ? where id = ?";
	public static final String deleteWhereIDEquals = "delete from bookings where id = ?";

	private int id;
	private String title;
	private String name;
	private String telephone;
	private Date bookingDate;
	private int bookingTime;
	private Date createdOn;
	private int createdBy;

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

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getName() {
		return name;
	}

	public String getTelephone() {
		return telephone;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public int getBookingTime() {
		return bookingTime;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public String toPrinterString() {
		StringBuilder sb = new StringBuilder();
		sb.append(bookingDate);
		sb.append(" ");
		sb.append(bookingTime);
		sb.append("pm    ");
		sb.append(title + " " + name);
		sb.append("  ");
		sb.append(telephone);
		
		return sb.toString();
	}

	@Override
	public String toString() {
		return "BookingDTO [id=" + id + ", title=" + title + ", name=" + name + ", telephone=" + telephone
				+ ", bookingDate=" + bookingDate + ", bookingTime=" + bookingTime + ", createdOn=" + createdOn
				+ ", createdBy=" + createdBy + "]";
	}

	public String toConfirmationString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: " + id);
		sb.append("\n");
		sb.append("Name: " + name);
		sb.append("\n");
		sb.append("Telephone: " + telephone);
		sb.append("\n");
		sb.append("Date: " + bookingDate + " Time: " + bookingTime);
		return sb.toString();
	}

}
