package ht.tm.dev.currys.showhow.gui.alert;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.alee.laf.WebLookAndFeel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Dialog.ModalityType;

public class BookingTimeUnavailableDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton override;
	private JButton customTime;
	private JButton cancel;

	public int selection = 0;
	private int originalSelection = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		if (!WebLookAndFeel.isInstalled()) {
			WebLookAndFeel.install();
		}

		try {
			int[] unavailableSlots = new int[1];
			unavailableSlots[0] = 2;
			BookingTimeUnavailableDialog dialog = new BookingTimeUnavailableDialog(unavailableSlots, 1);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BookingTimeUnavailableDialog(int[] unavailableSlots, int originalSelection) {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BookingTimeUnavailableDialog.class.getResource("/com/alee/managers/notification/icons/types/clock.png")));
		this.originalSelection = originalSelection;
		setType(Type.POPUP);
		setResizable(false);
		setModal(true);
		setTitle("This time is not available.");
		setBounds(100, 100, 497, 152);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblPleaseSelectA = new JLabel("A booking already exists with this time. Select another from below.");
		lblPleaseSelectA.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelectA.setBounds(12, 12, 468, 15);
		contentPanel.add(lblPleaseSelectA);

		one = new JButton("1");
		one.setBounds(11, 38, 85, 25);
		contentPanel.add(one);

		one.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				selection = 1;
				dispose();
			}
		});

		two = new JButton("2");
		two.setBounds(107, 38, 85, 25);
		contentPanel.add(two);

		two.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				selection = 2;
				dispose();
			}
		});

		three = new JButton("3");
		three.setBounds(204, 38, 85, 25);
		contentPanel.add(three);

		three.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				selection = 3;
				dispose();
			}
		});

		four = new JButton("4");
		four.setBounds(299, 38, 85, 25);
		contentPanel.add(four);

		four.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				selection = 4;
				dispose();
			}
		});

		override = new JButton("Ignore Clash");
		override.setBounds(395, 38, 85, 25);
		contentPanel.add(override);
		
		override.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selection = originalSelection;
				dispose();
			}
		});

		cancel = new JButton("Cancel");
		cancel.setBounds(395, 80, 85, 25);
		contentPanel.add(cancel);
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selection = 0;
				dispose();
			}
		});

		JTextField customValueBox = new JTextField();
		customValueBox.setEnabled(false);
		customValueBox.setToolTipText("Coming Soon!");
		customValueBox.setBounds(12, 80, 181, 25);
		contentPanel.add(customValueBox);
		customValueBox.setColumns(10);

		customTime = new JButton("Custom Time");
		customTime.setToolTipText("Coming Soon!");
		customTime.setEnabled(false);
		customTime.setBounds(204, 80, 181, 25);
		contentPanel.add(customTime);

		setAvailability(unavailableSlots);
	}

	/**
	 * Set the availability of the buttons.
	 * 
	 * @param unavailableSlots
	 *            - an array of type int. any numbers contained will have the
	 *            corresponding button disabled.
	 */
	private void setAvailability(int[] unavailableSlots) {
		for (int slot : unavailableSlots) {
			switch (slot) {

			case 1:
				one.setEnabled(false);
				one.setToolTipText("1:00pm is not available.");
				break;

			case 2:
				two.setEnabled(false);
				two.setToolTipText("2:00pm is not available.");
				break;

			case 3:
				three.setEnabled(false);
				three.setToolTipText("3:00pm is not available.");
				break;

			case 4:
				four.setEnabled(false);
				four.setToolTipText("4:00pm is not available.");
				break;

			default:
				// do nothing here. either nothing is sent,
				// or the time is not standard.
				break;
			}
		}
	}

}
