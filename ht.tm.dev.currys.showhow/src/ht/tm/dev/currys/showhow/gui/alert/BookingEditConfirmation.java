package ht.tm.dev.currys.showhow.gui.alert;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import com.alee.laf.WebLookAndFeel;

import ht.tm.dev.currys.showhow.db.dto.BookingDTO;
import ht.tm.dev.currys.showhow.print.BookingPrintUtil;
import ht.tm.dev.currys.showhow.print.ShowhowPrintUtil;

import javax.swing.JLabel;

public class BookingEditConfirmation extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		if(!WebLookAndFeel.isInstalled()){
			WebLookAndFeel.install();
		}
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		BookingDTO booking = new BookingDTO(0, "Mr", "Testy Testerton", "01234 534321", date, 1, date, 1);
		try {
			BookingEditConfirmation dialog = new BookingEditConfirmation(booking, booking);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BookingEditConfirmation(BookingDTO oldBooking, BookingDTO newBooking) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Updated booking: " + oldBooking.getId());
		setBounds(100, 100, 439, 287);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Old Booking", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(6, 12, 212, 202);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JPanel oldPanel = new JPanel();
				oldPanel.setBounds(6, 17, 200, 179);
				panel.add(oldPanel);
				oldPanel.setBackground(new Color(250, 128, 114));
				oldPanel.setLayout(null);
				{
					JLabel oldTitleBox = new JLabel("Title");
					oldTitleBox.setBounds(12, 17, 176, 15);
					oldPanel.add(oldTitleBox);
					oldTitleBox.setText(oldBooking.getTitle());
				}
				{
					JLabel oldNameBox = new JLabel("Name");
					oldNameBox.setBounds(12, 49, 176, 15);
					oldPanel.add(oldNameBox);
					oldNameBox.setText(oldBooking.getName());
				}
				{
					JLabel oldTelephoneBox = new JLabel("Telephone");
					oldTelephoneBox.setBounds(12, 81, 176, 15);
					oldPanel.add(oldTelephoneBox);
					oldTelephoneBox.setText(oldBooking.getTelephone());
				}
				{
					JLabel oldBookingDateBox = new JLabel("Booking Date");
					oldBookingDateBox.setBounds(12, 113, 176, 15);
					oldPanel.add(oldBookingDateBox);
					oldBookingDateBox.setText(oldBooking.getBookingDate().toGMTString());
				}
				{
					JLabel oldBookingTimeBox = new JLabel("Booking Time");
					oldBookingTimeBox.setBounds(12, 145, 176, 15);
					oldPanel.add(oldBookingTimeBox);
					oldBookingTimeBox.setText(oldBooking.getBookingTime() + " PM");
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "New Booking", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(216, 12, 212, 202);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JPanel newPanel = new JPanel();
				newPanel.setBounds(6, 17, 200, 179);
				panel.add(newPanel);
				newPanel.setBackground(new Color(144, 238, 144));
				newPanel.setLayout(null);
				{
					JLabel newTitleBox = new JLabel("Title");
					newTitleBox.setBounds(12, 17, 176, 15);
					newPanel.add(newTitleBox);
					newTitleBox.setText(newBooking.getTitle());
				}
				{
					JLabel newNameBox = new JLabel("Name");
					newNameBox.setBounds(12, 49, 176, 15);
					newPanel.add(newNameBox);
					newNameBox.setText(newBooking.getName());

				}
				{
					JLabel newTelephoneBox = new JLabel("Telephone");
					newTelephoneBox.setBounds(12, 81, 176, 15);
					newPanel.add(newTelephoneBox);
					newTelephoneBox.setText(newBooking.getTelephone());
				}
				{
					JLabel newBookingDateBox = new JLabel("Booking Date");
					newBookingDateBox.setBounds(12, 113, 176, 15);
					newPanel.add(newBookingDateBox);
					newBookingDateBox.setText(newBooking.getBookingDate().toGMTString());
				}
				{
					JLabel newBookingTimeBox = new JLabel("Booking Time");
					newBookingTimeBox.setBounds(12, 145, 176, 15);
					newPanel.add(newBookingTimeBox);
					newBookingTimeBox.setText(newBooking.getBookingTime() + " PM");
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPrintConfirmation = new JButton("Print Confirmation");
				buttonPane.add(btnPrintConfirmation);
				
				btnPrintConfirmation.addActionListener(new BookingPrintUtil(newBooking));
				
			}
			{
				JButton exitButton = new JButton("Exit");
				buttonPane.add(exitButton);
				getRootPane().setDefaultButton(exitButton);
				exitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
			}
		}
	}

}
