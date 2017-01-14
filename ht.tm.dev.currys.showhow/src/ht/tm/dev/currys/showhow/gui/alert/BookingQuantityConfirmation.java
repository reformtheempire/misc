package ht.tm.dev.currys.showhow.gui.alert;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.alee.laf.WebLookAndFeel;

import ht.tm.dev.currys.showhow.db.dto.BookingDTO;
import ht.tm.dev.currys.showhow.gui.util.TableFormat;
import ht.tm.dev.currys.showhow.gui.util.TableFormatter;
import java.awt.Dialog.ModalityType;

public class BookingQuantityConfirmation extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	public boolean response = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		if (!WebLookAndFeel.isInstalled()) {
			WebLookAndFeel.install();
		}
		ArrayList<BookingDTO> bookings = new ArrayList<>();
		bookings.add(
				new BookingDTO(3, "Mr", "Thomas", "012432 542332", new Date(Calendar.getInstance().getTime().getTime()),
						2, new Date(Calendar.getInstance().getTime().getTime()), 1));
		bookings.add(
				new BookingDTO(3, "Mr", "Smith", "213425 3242342", new Date(Calendar.getInstance().getTime().getTime()),
						3, new Date(Calendar.getInstance().getTime().getTime()), 1));

		try {
			BookingQuantityConfirmation dialog = new BookingQuantityConfirmation(bookings);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BookingQuantityConfirmation(ArrayList<BookingDTO> bookings) {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		TableFormat tf = TableFormatter.formatTableBookingQuantityConfirmation(bookings);

		setTitle("There is at least one ShowHow booking on this day");
		setResizable(false);
		setBounds(100, 100, 450, 248);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblInformation = new JLabel("Information:");
			lblInformation.setBounds(12, 12, 67, 15);
			contentPanel.add(lblInformation);
		}
		{
			JLabel lblThereAreExisting = new JLabel("There are existing bookings on this day already.");
			lblThereAreExisting.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblThereAreExisting.setBounds(12, 36, 370, 15);
			contentPanel.add(lblThereAreExisting);
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 63, 420, 109);
		contentPanel.add(scrollPane);

		table = new JTable(tf.getData(), tf.getTableHeaders());
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Create Booking");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);

				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						response = true;
						dispose();
					}
				});
			}
			{
				JButton cancelButton = new JButton("Reschedule");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				getRootPane().setDefaultButton(cancelButton);

				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						response = false;
						dispose();
					}
				});
			}
		}
	}
}
