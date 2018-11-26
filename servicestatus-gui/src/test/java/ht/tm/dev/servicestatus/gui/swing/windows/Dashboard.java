package ht.tm.dev.servicestatus.gui.swing.windows;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTabbedPane;

public class Dashboard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
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
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 12, 410, 237);
		JPanel serverPanel = new JPanel();
		JPanel mfdPanel = new JPanel();
		JPanel switchPanel = new JPanel();
		tabbedPane.addTab("Servers", serverPanel);
		tabbedPane.addTab("MFDs", mfdPanel);
		tabbedPane.addTab("Switches", switchPanel);
		serverPanel.setLayout(null);
		mfdPanel.setLayout(null);
		
		JButton button_1 = new JButton("BRIGHOUSE MFD");
		button_1.setBackground(Color.GREEN);
		button_1.setBounds(12, 12, 149, 26);
		mfdPanel.add(button_1);
		
		JButton btnLibraryMfd = new JButton("LIBRARY MONO MFD");
		btnLibraryMfd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLibraryMfd.setBackground(Color.GREEN);
		btnLibraryMfd.setBounds(12, 50, 149, 26);
		mfdPanel.add(btnLibraryMfd);
		
		JButton btnLibraryColMfd = new JButton("LIBRARY COL MFD");
		btnLibraryColMfd.setBackground(Color.ORANGE);
		btnLibraryColMfd.setBounds(12, 88, 149, 26);
		mfdPanel.add(btnLibraryColMfd);
		
		JButton btnLaneMfd = new JButton("LANE MFD");
		btnLaneMfd.setBackground(Color.RED);
		btnLaneMfd.setBounds(12, 126, 149, 26);
		mfdPanel.add(btnLaneMfd);
		
		JButton btnChadwickMfd = new JButton("CHADWICK MFD");
		btnChadwickMfd.setBackground(Color.GREEN);
		btnChadwickMfd.setBounds(12, 164, 149, 26);
		mfdPanel.add(btnChadwickMfd);
		
		JButton btnReprographicsMfd = new JButton("REPRO FRONT MFD");
		btnReprographicsMfd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReprographicsMfd.setBackground(Color.GREEN);
		btnReprographicsMfd.setBounds(244, 12, 149, 26);
		mfdPanel.add(btnReprographicsMfd);
		
		JButton btnReproRearMfd = new JButton("REPRO BACK MFD");
		btnReproRearMfd.setBackground(Color.GREEN);
		btnReproRearMfd.setBounds(244, 50, 149, 26);
		mfdPanel.add(btnReproRearMfd);
		switchPanel.setLayout(null);
		
		final JButton btnNewButton = new JButton("CHENEY-DC00");
		btnNewButton.setBounds(12, 12, 128, 26);
		serverPanel.add(btnNewButton);
		btnNewButton.setBackground(Color.RED);
		
		JButton button = new JButton("CHENEY-DC01");
		button.setBounds(12, 46, 128, 26);
		serverPanel.add(button);
		button.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setBackground(Color.green);
				panel.repaint();
			}
		});
		panel.add(tabbedPane);
	}
}
