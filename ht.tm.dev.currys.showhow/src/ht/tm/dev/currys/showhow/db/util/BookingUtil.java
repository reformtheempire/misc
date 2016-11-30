package ht.tm.dev.currys.showhow.db.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ht.tm.dev.currys.showhow.db.SQLConnectionManager;
import ht.tm.dev.currys.showhow.db.dto.BookingDTO;

public class BookingUtil {

	public static BookingDTO getBookingByID(int id){
		Connection conn = null;
		try {
			conn = SQLConnectionManager.getConnectionToDB();
			
			PreparedStatement ps = conn.prepareStatement(BookingDTO.selectByID);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.getFetchSize() < 1){
				// we return null, a booking doesn't exist
				return null;
			} else {
				return new BookingDTO(rs.getInt("id"), rs.getString("title"), rs.getString("name"), rs.getString("telephone"), rs.getDate("booking_date"), rs.getInt("booking_time"), rs.getDate("created_on"), rs.getInt("created_by"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}
	
}
