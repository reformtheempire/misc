package ht.tm.dev.currys.showhow.print;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;

import ht.tm.dev.currys.showhow.db.dto.BookingDTO;

public class ShowhowPrintUtil implements Printable, ActionListener {

	private ArrayList<BookingDTO> bookings = new ArrayList<>();

	public ShowhowPrintUtil(ArrayList<BookingDTO> bookings) {
		this.setBookings(bookings);
	}

	@Override
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
		g.setFont(new Font("monospaced", Font.PLAIN, 12));
		if (page > 0) {
			return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D) g;
		
		
		g2d.translate(pf.getImageableX(), pf.getImageableY());

		StringBuilder sb = new StringBuilder();

		for (BookingDTO bookingDTO : getBookings()) {
			sb.append(bookingDTO.toPrinterString() + "\n");
		}

		String printableDocument = sb.toString();

		int y = g.getFontMetrics().getHeight();

		g.drawString("Date      | Time | Name     | Telephone", 20, y);

		for (String line : printableDocument.split("\n")) {
			y = y + g.getFontMetrics().getHeight();
			g.drawString(line, 20, y);
		}
		return PAGE_EXISTS;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(this);
		boolean ok = job.printDialog();
		if (ok) {
			try {
				job.print();
			} catch (PrinterException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<BookingDTO> getBookings() {
		return bookings;
	}

	public void setBookings(ArrayList<BookingDTO> bookings) {
		if(bookings == null){
			this.bookings = new ArrayList<>();
		} else {
			this.bookings = bookings;			
		}
	}
}
