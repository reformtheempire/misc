package ht.tm.dev.currys.showhow.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.alee.laf.WebLookAndFeel;

public class ShowhowGui {

	private JFrame frmShowhowBooker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frmShowhowBooker.setResizable(false);
		frmShowhowBooker.setTitle("ShowHow Manager");
		frmShowhowBooker.setBounds(100, 100, 600, 500);
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

		JLabel lblWelcome = new JLabel("Good Day!");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(196, 12, 376, 84);
		frmShowhowBooker.getContentPane().add(lblWelcome);

		JTextArea totalShowhowMessage = new JTextArea();
		totalShowhowMessage.setFont(new Font("Tahoma", Font.PLAIN, 35));
		totalShowhowMessage.setText("There are {$1}\r\nShowHows Today");
		totalShowhowMessage.setBackground(SystemColor.control);
		totalShowhowMessage.setEditable(false);
		totalShowhowMessage.setBounds(190, 119, 382, 105);
		frmShowhowBooker.getContentPane().add(totalShowhowMessage);

		JLabel lblCopyright = new JLabel("Copyright Thomas Mather 2016 - Present");
		lblCopyright.setBounds(355, 444, 227, 15);
		frmShowhowBooker.getContentPane().add(lblCopyright);

		JLabel lblNewLabel = new JLabel("Current Version: {$1}");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(457, 427, 125, 15);
		frmShowhowBooker.getContentPane().add(lblNewLabel);

		JLabel lblLatestVersion = new JLabel("Latest Version: {$1}");
		lblLatestVersion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLatestVersion.setBounds(457, 409, 125, 15);
		frmShowhowBooker.getContentPane().add(lblLatestVersion);
	}
}
