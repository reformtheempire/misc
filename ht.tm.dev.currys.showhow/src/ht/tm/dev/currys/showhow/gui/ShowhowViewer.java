package ht.tm.dev.currys.showhow.gui;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import com.alee.laf.WebLookAndFeel;
import com.toedter.calendar.JDateChooser;

import ht.tm.dev.currys.showhow.db.dto.BookingDTO;
import ht.tm.dev.currys.showhow.db.util.BookingSQLUtil;
import ht.tm.dev.currys.showhow.gui.util.TableFormat;
import ht.tm.dev.currys.showhow.gui.util.TableFormatter;
import java.awt.Toolkit;

public class ShowhowViewer extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (!WebLookAndFeel.isInstalled()) {
						WebLookAndFeel.install();
					}

					ShowhowViewer frame = new ShowhowViewer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShowhowViewer() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShowhowViewer.class.getResource("/com/alee/managers/notification/icons/types/calendar.png")));
		setTitle("View ShowHows");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDateFrom = new JLabel("Date From:");
		lblDateFrom.setBounds(12, 30, 61, 15);
		contentPane.add(lblDateFrom);

		JDateChooser dateFromBox = new JDateChooser();
		dateFromBox.setBounds(117, 12, 174, 33);
		dateFromBox.getJCalendar().setWeekOfYearVisible(false);
		dateFromBox.getJCalendar().setTodayButtonVisible(true);
		dateFromBox.getJCalendar().getCalendar().setTime(Calendar.getInstance().getTime());
		contentPane.add(dateFromBox);

		JLabel lblDateTo = new JLabel("Date To:");
		lblDateTo.setBounds(22, 57, 61, 15);
		contentPane.add(lblDateTo);

		JDateChooser dateToBox = new JDateChooser();
		dateToBox.setBounds(117, 50, 174, 33);
		dateToBox.getJCalendar().setWeekOfYearVisible(false);
		dateToBox.getJCalendar().setTodayButtonVisible(true);
		dateToBox.getJCalendar().getCalendar().setTime(Calendar.getInstance().getTime());
		contentPane.add(dateToBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 95, 570, 236);
		contentPane.add(scrollPane);

		TableFormat tf = TableFormatter.formatTableShowhowViewer(BookingSQLUtil.getBookingsInDateRange(
				new java.sql.Date(dateFromBox.getJCalendar().getCalendar().getTime().getTime()),
				new java.sql.Date(dateToBox.getJCalendar().getCalendar().getTime().getTime())));
		table = new JTable(tf.getData(), tf.getTableHeaders());
		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(487, 335, 95, 25);
		contentPane.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TableFormat tf = new TableFormat(null, null);

				tf = TableFormatter.formatTableShowhowViewer(BookingSQLUtil.getBookingsInDateRange(
						new java.sql.Date(dateFromBox.getJCalendar().getCalendar().getTime().getTime()),
						new java.sql.Date(dateToBox.getJCalendar().getCalendar().getTime().getTime())));

				table = new JTable(tf.getData(), tf.getTableHeaders());
				scrollPane.setViewportView(table);
			}
		});

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(12, 335, 95, 25);
		contentPane.add(btnExit);

		idField = new JTextField();
		idField.setToolTipText("Coming Soon!");
		idField.setEnabled(false);
		idField.setEditable(false);
		idField.setHorizontalAlignment(SwingConstants.TRAILING);
		idField.setBounds(362, 46, 207, 38);
		contentPane.add(idField);
		idField.setColumns(10);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(321, 57, 23, 15);
		contentPane.add(lblId);

		JTextPane txtpnUseThisMenu = new JTextPane();
		txtpnUseThisMenu.setText("Use this menu to lookup ShowHows! (Future or Past)");
		txtpnUseThisMenu.setBackground(SystemColor.menu);
		txtpnUseThisMenu.setEditable(false);
		txtpnUseThisMenu.setBounds(321, 12, 242, 33);
		contentPane.add(txtpnUseThisMenu);

		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
