package ht.tm.dev.currys.showhow.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class StartupSplash extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartupSplash frame = new StartupSplash();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void go() {
		StartupSplash frame = new StartupSplash();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public StartupSplash() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartupSplash.class.getResource("/com/alee/managers/plugin/data/icons/status/detected.png")));
		setTitle("Hold on a Minute");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 127);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblStartingApplication = new JLabel("Starting Application...");
		lblStartingApplication.setFont(new Font("Dialog", Font.BOLD, 23));
		lblStartingApplication.setBounds(12, 12, 410, 35);
		panel.add(lblStartingApplication);

		JLabel lblPleaseWait = new JLabel("Please Wait.");
		lblPleaseWait.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPleaseWait.setBounds(12, 51, 92, 16);
		panel.add(lblPleaseWait);
		setVisible(true);
	}
}
