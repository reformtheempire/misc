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

public class ShowhowGui {

	public static StartupSplash splash = new StartupSplash();
	private JFrame frmShowhowBooker;
	private Date date = new Date(Calendar.getInstance().getTime().getTime());
	private JTable showhowTable;

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
		frmShowhowBooker.setIconImage(Toolkit.getDefaultToolkit().getImage(ShowhowGui.class.getResource("/com/alee/laf/optionpane/icons/question.png")));
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

		JButton showhowButton = new JButton("View ShowHow's");
		showhowButton.setBounds(0, 0, 160, 75);
		sideBar.add(showhowButton);

		JButton createBookingButton = new JButton("Book ShowHow");
		createBookingButton.setBounds(0, 86, 160, 75);
		sideBar.add(createBookingButton);

		createBookingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame booking = new ShowhowBooking();
				booking.setVisible(true);
			}
		});

		JButton adminButton = new JButton("Admin");
		adminButton.setEnabled(false);
		adminButton.setBounds(0, 172, 160, 75);
		sideBar.add(adminButton);

		JButton exitButton = new JButton("Exit");
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

		JTextArea totalShowhowMessage = new JTextArea();
		totalShowhowMessage.setFont(new Font("Tahoma", Font.PLAIN, 33));
		totalShowhowMessage.setText("There are " + BookingSQLUtil.getCountByDate(date) + " ShowHows for today");
		totalShowhowMessage.setBackground(SystemColor.control);
		totalShowhowMessage.setEditable(false);
		totalShowhowMessage.setBounds(190, 119, 514, 55);
		frmShowhowBooker.getContentPane().add(totalShowhowMessage);

		JLabel lblCopyright = new JLabel("Copyright Thomas Mather 2016 - Present");
		lblCopyright.setBounds(465, 444, 227, 15);
		frmShowhowBooker.getContentPane().add(lblCopyright);

		JLabel lblNewLabel = new JLabel("Current Version: 0.1.0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(567, 427, 125, 15);
		frmShowhowBooker.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 186, 502, 205);
		frmShowhowBooker.getContentPane().add(scrollPane);
		
		// get today's bookings.
		TableFormat tf = TableFormatter.formatTable(BookingSQLUtil.getBookingsByDate(new Date(Calendar.getInstance().getTime().getTime())));
		
		showhowTable = new JTable(tf.getData(), tf.getTableHeaders());
		showhowTable.setFillsViewportHeight(true);
		
		scrollPane.setViewportView(showhowTable);

		splash.dispose();
	}
}
