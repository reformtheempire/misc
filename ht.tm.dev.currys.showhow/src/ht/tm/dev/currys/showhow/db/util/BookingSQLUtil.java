package ht.tm.dev.currys.showhow.db.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ht.tm.dev.currys.showhow.db.SQLConnectionManager;
import ht.tm.dev.currys.showhow.db.dto.BookingDTO;

public class BookingSQLUtil {

	public static BookingDTO getBookingByID(int id) {
		Connection conn = null;
		try {
			conn = SQLConnectionManager.getConnectionToDB();

			PreparedStatement ps = conn.prepareStatement(BookingDTO.selectByID);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs == null) {
				// we return null, a booking doesn't exist
				return null;
			} else {
				rs.next();
				return new BookingDTO(rs.getInt("id"), rs.getString("title"), rs.getString("name"),
						rs.getString("telephone"), rs.getDate("booking_date"), rs.getInt("booking_time"),
						rs.getDate("created_on"), rs.getInt("created_by"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SQLConnectionManager.closeConnection(conn);
		}

		return null;
	}

	public static ArrayList<BookingDTO> getBookingsByDate(Date date) {
		Connection conn = null;
		try {
			conn = SQLConnectionManager.getConnectionToDB();

			PreparedStatement ps = conn.prepareStatement(BookingDTO.selectAllOnSpecifiedDate);
			ps.setDate(1, date);

			ResultSet rs = ps.executeQuery();

			if (rs == null) {
				// we return null, a booking doesn't exist
				return null;
			} else {
				ArrayList<BookingDTO> bookingsOnThisDate = new ArrayList<>();
				while(rs.next()){
					bookingsOnThisDate.add(new BookingDTO(rs.getInt("id"), rs.getString("title"), rs.getString("name"),
						rs.getString("telephone"), rs.getDate("booking_date"), rs.getInt("booking_time"),
						rs.getDate("created_on"), rs.getInt("created_by")));
				}
				return bookingsOnThisDate;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SQLConnectionManager.closeConnection(conn);
		}

		return null;
	}
	
	public static int getCountByDate(Date date){
		
		Connection conn = null;
		try {
			conn = SQLConnectionManager.getConnectionToDB();

			PreparedStatement ps = conn.prepareStatement(BookingDTO.selectAllOnSpecifiedDate);
			ps.setDate(1, date);

			ResultSet rs = ps.executeQuery();

			if (rs == null) {
				// we return null, a booking doesn't exist
				return 0;
			} else {
				rs.last();
				int bookingsOnThisDate = rs.getRow();
				return bookingsOnThisDate;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SQLConnectionManager.closeConnection(conn);
		}

		return 0;
	}

	public static BookingDTO createBooking(BookingDTO newBooking) {
		Connection conn = null;
		try {
			conn = SQLConnectionManager.getConnectionToDB();
			PreparedStatement ps = conn.prepareStatement(BookingDTO.insert, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, newBooking.getTitle());
			ps.setString(2, newBooking.getName());
			ps.setString(3, newBooking.getTelephone());
			ps.setDate(4, newBooking.getBookingDate());
			ps.setInt(5, newBooking.getBookingTime());
			ps.setDate(6, newBooking.getCreatedOn());
			ps.setInt(7, newBooking.getCreatedBy());

			int success = ps.executeUpdate();

			if (success == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					BookingDTO createdBooking = new BookingDTO(rs.getInt(1), newBooking.getTitle(),
							newBooking.getName(), newBooking.getTelephone(), newBooking.getBookingDate(),
							newBooking.getBookingTime(), newBooking.getCreatedOn(), newBooking.getCreatedBy());
					System.out.println("Created booking with id: " + createdBooking.getId());
					return createdBooking;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SQLConnectionManager.closeConnection(conn);
		}

		return null;
	}

}
