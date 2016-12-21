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

import ht.tm.dev.currys.showhow.db.dto.BookingDTO;

public class BookingPrintUtil implements Printable, ActionListener {

	private BookingDTO booking;

	public BookingPrintUtil(BookingDTO booking) {
		this.booking = booking;
	}

	@Override
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
		g.setFont(new Font("monospaced", Font.PLAIN, 12));

		if (page > 0) {
			return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D) g;

		g2d.translate(pf.getImageableX(), pf.getImageableY());

		int y = g.getFontMetrics().getHeight();
		String printableString = booking.toConfirmationString();
		for (String line : printableString.split("\n")) {
			g.drawString(line, 20, y);
			y = y + g.getFontMetrics().getHeight();
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

	public BookingDTO getBooking() {
		return booking;
	}

	public void setBooking(BookingDTO booking) {
		this.booking = booking;
	}

}
