package ht.tm.dev.currys.showhow.gui.util;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import ht.tm.dev.currys.showhow.db.dto.BookingDTO;

public class TableFormatter {

	public static TableFormat formatTableShowhowGui(ArrayList<BookingDTO> bookings) {

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
	
	public static TableFormat formatTableBookingQuantityConfirmation(ArrayList<BookingDTO> bookings) {

		String[] tableHeaders = {"Time", "Title", "Name"};
		
		int totalBookings = bookings.size();
		
		String[][] data = new String[totalBookings][3];
		
		int i = 0;
		for (String[] row : data) {
			BookingDTO booking = bookings.get(i);
			row[0] = booking.getBookingTime() + "PM";
			row[1] = booking.getTitle();
			row[2] = booking.getName();
			i++;
		}
		
		
		TableFormat tf = new TableFormat(tableHeaders, data);
		return tf;
	}

	public static TableFormat formatTableShowhowViewer(ArrayList<BookingDTO> bookings) {

		String[] tableHeaders = {"ID", "Date", "Time", "Title", "Name", "Telphone"};
		
		int totalBookings = bookings.size();
		
		String[][] data = new String[totalBookings][6];
		
		int i = 0;
		DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		for (String[] row : data) {
			BookingDTO booking = bookings.get(i);
			row[0] = booking.getId() + "";
			row[1] = formatter.format(booking.getBookingDate());
			row[2] = booking.getBookingTime() + "PM";
			row[3] = booking.getTitle();
			row[4] = booking.getName();
			row[5] = booking.getTelephone();
			i++;
		}
		
		
		TableFormat tf = new TableFormat(tableHeaders, data);
		return tf;
	}

	
}
