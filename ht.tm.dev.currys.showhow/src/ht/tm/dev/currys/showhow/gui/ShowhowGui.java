package ht.tm.dev.currys.showhow.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;

public class ShowhowGui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowhowGui window = new ShowhowGui();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 12, 172, 443);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel sideBar = new JPanel();
		sideBar.setBounds(6, 12, 160, 419);
		panel.add(sideBar);
		sideBar.setLayout(null);
		
		JButton showhowButton = new JButton("View ShowHow's");
		showhowButton.setBounds(0, 0, 160, 75);
		sideBar.add(showhowButton);
		
		JButton createBookingButton = new JButton("Book ShowHow");
		createBookingButton.setBounds(0, 86, 160, 75);
		sideBar.add(createBookingButton);
		
		JButton adminButton = new JButton("Admin");
		adminButton.setBounds(0, 172, 160, 75);
		sideBar.add(adminButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(0, 344, 160, 75);
		sideBar.add(exitButton);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(196, 12, 376, 84);
		frame.getContentPane().add(lblWelcome);
		
		JTextArea txtrYouHave = new JTextArea();
		txtrYouHave.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtrYouHave.setText("You have {$1}\nShowHow's for today!");
		txtrYouHave.setBackground(SystemColor.control);
		txtrYouHave.setEditable(false);
		txtrYouHave.setBounds(190, 119, 382, 105);
		frame.getContentPane().add(txtrYouHave);
	}
}
