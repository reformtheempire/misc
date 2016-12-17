package ht.tm.dev.currys.showhow.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

import com.alee.laf.WebLookAndFeel;
import com.toedter.calendar.JDateChooser;

import ht.tm.dev.currys.showhow.db.dto.BookingDTO;
import ht.tm.dev.currys.showhow.db.util.BookingSQLUtil;
import ht.tm.dev.currys.showhow.gui.alert.BookingEditConfirmation;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;

public class ShowhowEditor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField idSearchBox;
	private JTextField titleBox;
	private JTextField nameBox;
	private JTextField telephoneBox;
	private JTextField timeBox;
	private JButton searchButton;
	private JDateChooser dateChooser;

	private BookingDTO oldBooking = null;
	private JButton deleteButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		if (!WebLookAndFeel.isInstalled()) {
			WebLookAndFeel.install();
		}

		try {
			ShowhowEditor dialog = new ShowhowEditor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ShowhowEditor() {
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ShowhowEditor.class.getResource("/com/alee/extended/filechooser/icons/edit.png")));
		setTitle("Edit ShowHow");
		setBounds(100, 100, 427, 264);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(
					new TitledBorder(null, "Lookup Showhow", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(0, 0, 422, 68);
			contentPanel.add(panel);
			panel.setLayout(null);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(6, 17, 404, 38);
			panel.add(panel_1);
			panel_1.setLayout(null);

			JLabel lblShowhowId = new JLabel("ID:");
			lblShowhowId.setHorizontalAlignment(SwingConstants.TRAILING);
			lblShowhowId.setBounds(12, 12, 16, 15);
			panel_1.add(lblShowhowId);

			idSearchBox = new JTextField();
			idSearchBox.setBounds(39, 7, 268, 25);
			panel_1.add(idSearchBox);
			idSearchBox.setColumns(10);

			searchButton = new JButton("Search");
			searchButton.setBounds(318, 7, 85, 25);
			panel_1.add(searchButton);

			searchButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int id = 0;
					try {
						id = Integer.parseInt(idSearchBox.getText());
					} catch (NumberFormatException exc) {
						JOptionPane.showMessageDialog(searchButton, "Please enter a valid ID");
						id = 0;
					}
					populate(id);
				}
			});
		}

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 72, 122, 48);
		contentPanel.add(panel);
		panel.setLayout(null);

		titleBox = new JTextField();
		titleBox.setBounds(6, 17, 110, 25);
		panel.add(titleBox);
		titleBox.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(134, 72, 122, 48);
		contentPanel.add(panel_1);

		nameBox = new JTextField();
		nameBox.setColumns(10);
		nameBox.setBounds(6, 17, 110, 25);
		panel_1.add(nameBox);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Telephone", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(268, 72, 154, 48);
		contentPanel.add(panel_2);

		telephoneBox = new JTextField();
		telephoneBox.setColumns(10);
		telephoneBox.setBounds(6, 17, 136, 25);
		panel_2.add(telephoneBox);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "Booking Date", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(0, 132, 256, 58);
		contentPanel.add(panel_3);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(8, 17, 236, 29);
		panel_3.add(dateChooser);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "Booking Time", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(268, 132, 154, 58);
		contentPanel.add(panel_4);

		timeBox = new JTextField();
		timeBox.setToolTipText("Enter value as a WHOLE number (i.e: 3)");
		timeBox.setColumns(10);
		timeBox.setBounds(6, 17, 136, 29);
		panel_4.add(timeBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton saveButton = new JButton("Save");
				saveButton.setHorizontalAlignment(SwingConstants.LEFT);
				saveButton.setIcon(
						new ImageIcon(ShowhowEditor.class.getResource("/com/alee/extended/ninepatch/icons/save.png")));
				saveButton.setActionCommand("OK");
				buttonPane.add(saveButton);
				getRootPane().setDefaultButton(saveButton);
				saveButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (save()) {
							dispose();
						} else {
							JOptionPane.showMessageDialog(saveButton,
									"Could not update booking.\nPlease reload the booking then try again.");
						}
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setHorizontalAlignment(SwingConstants.LEFT);
				cancelButton.setIcon(new ImageIcon(
						ShowhowEditor.class.getResource("/com/alee/extended/filechooser/icons/cancel.png")));
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});

				deleteButton = new JButton("Delete");
				deleteButton.setHorizontalAlignment(SwingConstants.LEFT);
				deleteButton.setIcon(new ImageIcon(
						ShowhowEditor.class.getResource("/com/alee/extended/ninepatch/icons/warning.png")));

				deleteButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						if (oldBooking == null) {
							JOptionPane.showMessageDialog(deleteButton, "Please search for a booking");
							return;
						}
						delete(oldBooking.getId());
					}
				});

				buttonPane.add(deleteButton);
				buttonPane.add(cancelButton);
			}
		}

	}

	private boolean delete(int id) {
		if (JOptionPane.showConfirmDialog(deleteButton, "Delete ShowHow? with ID: " + id) == 0) {
			if(BookingSQLUtil.deleteBooking(id)){
				JOptionPane.showMessageDialog(deleteButton, "Deleted.");
				dispose();
				return true;
			} else {
				JOptionPane.showMessageDialog(deleteButton, "Could not delete booking.\n"
						+ "please reload the booking and try again.");
				return false;
			}
		}
		return false;
	}

	public void populate(int showhowID) {
		BookingDTO showhow = BookingSQLUtil.getBookingByID(showhowID);
		if (showhow == null) {
			JOptionPane.showMessageDialog(searchButton, "This ID doesn't exist.");
		} else {
			titleBox.setText(showhow.getTitle());
			nameBox.setText(showhow.getName());
			telephoneBox.setText(showhow.getTelephone());
			timeBox.setText(showhow.getBookingTime() + "");
			dateChooser.setDate(new Date(showhow.getBookingDate().getTime()));
		}
		oldBooking = showhow;
	}

	private boolean save() {

		if (oldBooking == null) {
			// nothing to update.
			return false;
		}

		int bookingId = Integer.parseInt(idSearchBox.getText());
		int time = Integer.parseInt(timeBox.getText());
		BookingDTO newBooking = new BookingDTO(bookingId, titleBox.getText(), nameBox.getText(), telephoneBox.getText(),
				new java.sql.Date(dateChooser.getDate().getTime()), time,
				new java.sql.Date(Calendar.getInstance().getTime().getTime()), 1);

		if (BookingSQLUtil.updateBooking(newBooking)) {
			BookingEditConfirmation bec = new BookingEditConfirmation(oldBooking, newBooking);
			bec.setVisible(true);
			return true;
		} else {
			return false;
		}
	}
}
