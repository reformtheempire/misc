package ht.tm.dev.currys.showhow.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.TitledBorder;

import com.alee.laf.WebLookAndFeel;

import ht.tm.dev.currys.showhow.db.util.BookingSQLUtil;
import ht.tm.dev.currys.showhow.gui.util.TableFormat;
import ht.tm.dev.currys.showhow.gui.util.TableFormatter;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ShowhowGui {

	public static StartupSplash splash = new StartupSplash();
	private JFrame frmShowhowBooker;
	private Date date = new Date(Calendar.getInstance().getTime().getTime());
	private JTable showhowTable;
	private JTextArea totalShowhowMessage;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		splash.setVisible(true);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebLookAndFeel.install();
					ShowhowGui window = new ShowhowGui();
					window.frmShowhowBooker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShowhowGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmShowhowBooker = new JFrame();
		frmShowhowBooker.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ShowhowGui.class.getResource("/com/alee/laf/optionpane/icons/question.png")));
		frmShowhowBooker.setResizable(false);
		frmShowhowBooker.setTitle("ShowHow Manager");
		frmShowhowBooker.setBounds(100, 100, 710, 500);
		frmShowhowBooker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShowhowBooker.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 12, 172, 459);
		frmShowhowBooker.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel sideBar = new JPanel();
		sideBar.setBounds(6, 12, 160, 435);
		panel.add(sideBar);
		sideBar.setLayout(null);

		JButton showhowButton = new JButton("View ShowHows");
		showhowButton.setHorizontalAlignment(SwingConstants.LEFT);
		showhowButton.setIcon(new ImageIcon(
				ShowhowGui.class.getResource("/com/alee/managers/notification/icons/types/calendar.png")));
		showhowButton.setBounds(0, 0, 160, 75);
		sideBar.add(showhowButton);

		showhowButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ShowhowViewer viewerDialogue = new ShowhowViewer();
				viewerDialogue.setVisible(true);
			}
		});

		JButton createBookingButton = new JButton("Book ShowHow");
		createBookingButton.setHorizontalAlignment(SwingConstants.LEFT);
		createBookingButton.setIcon(
				new ImageIcon(ShowhowGui.class.getResource("/com/alee/managers/notification/icons/types/plus.png")));
		createBookingButton.setBounds(0, 86, 160, 75);
		sideBar.add(createBookingButton);

		createBookingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame booking = new ShowhowBooking();
				booking.setVisible(true);
			}
		});

		JButton adminButton = new JButton("Edit Showhow");
		adminButton.setHorizontalAlignment(SwingConstants.LEFT);
		adminButton.setIcon(new ImageIcon(
				ShowhowGui.class.getResource("/com/alee/managers/notification/icons/types/database.png")));
		adminButton.setBounds(0, 172, 160, 75);
		sideBar.add(adminButton);
		
		adminButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// open edit panel
				ShowhowEditor she = new ShowhowEditor();
				she.setVisible(true);
			}
		});

		JButton exitButton = new JButton("Exit");
		exitButton.setHorizontalAlignment(SwingConstants.LEFT);
		exitButton.setIcon(
				new ImageIcon(ShowhowGui.class.getResource("/com/alee/managers/notification/icons/types/cross.png")));
		exitButton.setBounds(0, 360, 160, 75);
		sideBar.add(exitButton);

		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmShowhowBooker.dispose();
			}
		});

		JLabel lblWelcome = new JLabel("Hello There!");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(196, 12, 496, 84);
		frmShowhowBooker.getContentPane().add(lblWelcome);

		totalShowhowMessage = new JTextArea();
		totalShowhowMessage.setFont(new Font("Tahoma", Font.PLAIN, 33));
		totalShowhowMessage.setBackground(SystemColor.control);
		totalShowhowMessage.setEditable(false);
		totalShowhowMessage.setBounds(190, 119, 514, 55);
		frmShowhowBooker.getContentPane().add(totalShowhowMessage);

		JLabel lblCopyright = new JLabel("Copyright Thomas Mather 2016 - Present");
		lblCopyright.setBounds(465, 444, 227, 15);
		frmShowhowBooker.getContentPane().add(lblCopyright);

		JLabel lblNewLabel = new JLabel("Current Version: ALPHA: 0.3.5");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(465, 427, 227, 15);
		frmShowhowBooker.getContentPane().add(lblNewLabel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 186, 502, 205);
		frmShowhowBooker.getContentPane().add(scrollPane);

		// setup the panel for today's bookings:
		refreshData();

		JButton refreshButton = new JButton("Refresh");
		refreshButton.setHorizontalAlignment(SwingConstants.LEFT);
		refreshButton.setIcon(
				new ImageIcon(ShowhowGui.class.getResource("/com/alee/extended/filechooser/icons/refresh.png")));
		refreshButton.setBounds(189, 402, 85, 25);
		frmShowhowBooker.getContentPane().add(refreshButton);
		
		refreshButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshData();
				
			}
		});

		splash.dispose();
	}

	public void refreshData() {
		// get today's bookings.
		totalShowhowMessage.setText("There are " + BookingSQLUtil.getCountByDate(date) + " ShowHows for today");
		TableFormat tf = TableFormatter.formatTableShowhowGui(
				BookingSQLUtil.getBookingsByDate(new Date(Calendar.getInstance().getTime().getTime())));

		showhowTable = new JTable(tf.getData(), tf.getTableHeaders());
		showhowTable.setFillsViewportHeight(true);
		scrollPane.setViewportView(showhowTable);

	}
}
