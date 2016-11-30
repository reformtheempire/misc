package ht.tm.dev.currys.showhow.gui.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import ht.tm.dev.currys.showhow.db.dto.BookingDTO;

public class TableFormatter {

	public static TableFormat formatTable(ArrayList<BookingDTO> bookings) {

		String[] tableHeaders = {"Time", "Title", "Name", "Telphone"};
		
		int totalBookings = bookings.size();
		
		String[][] data = new String[totalBookings][4];
		
		int i = 0;
		for (String[] row : data) {
			BookingDTO booking = bookings.get(i);
			row[0] = booking.getBookingTime() + "PM";
			row[1] = booking.getTitle();
			row[2] = booking.getName();
			row[3] = booking.getTelephone();
			i++;
		}
		
		
		TableFormat tf = new TableFormat(tableHeaders, data);
		return tf;
	}

}
