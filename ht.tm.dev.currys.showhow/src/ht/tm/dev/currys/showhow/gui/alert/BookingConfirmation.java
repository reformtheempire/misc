package ht.tm.dev.currys.showhow.gui.alert;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.alee.laf.WebLookAndFeel;

import ht.tm.dev.currys.showhow.db.dto.BookingDTO;

import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;

public class BookingConfirmation extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		if (!WebLookAndFeel.isInstalled()) {
			WebLookAndFeel.install();
		}
		try {
			Date date = new Date(Calendar.getInstance().getTime().getTime());

			BookingDTO booking = new BookingDTO(0, "Mr", "Testy Testerton", "01234 534321", date, 1, date, 1);
			BookingConfirmation dialog = new BookingConfirmation(booking);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BookingConfirmation(BookingDTO booking) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(BookingConfirmation.class.getResource("/com/alee/extended/filechooser/icons/ok.png")));
		setResizable(false);
		setTitle("Booking Confirmed");
		setBounds(100, 100, 361, 188);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JTextPane txtpnBookingIdName = new JTextPane();
		txtpnBookingIdName.setEditable(false);
		txtpnBookingIdName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnBookingIdName.setText("Booking ID: " + booking.getId() + "\r\nName: " + booking.getName()
				+ "\r\nTelephone:" + booking.getTelephone() + "\r\nDate: " + booking.getBookingDate() + " Time: "
				+ booking.getBookingTime() +"pm");
		txtpnBookingIdName.setBackground(SystemColor.menu);
		txtpnBookingIdName.setBounds(12, 12, 421, 100);
		contentPanel.add(txtpnBookingIdName);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton closeButton = new JButton("Close");
				closeButton.setActionCommand("OK");
				buttonPane.add(closeButton);
				getRootPane().setDefaultButton(closeButton);

				closeButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
			}
		}
	}
}
