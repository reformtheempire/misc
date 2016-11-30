package ht.tm.dev.currys.showhow.gui;

import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.alee.laf.WebLookAndFeel;
import com.toedter.calendar.JCalendar;

public class ShowhowBooking extends JFrame {

	private static final long serialVersionUID = -5788101932266458873L;
	private JPanel contentPane;
	private JTextField customerNameBox;
	private JTextField customerPhoneBox;
	private JTextField customerTitleBox;

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
					ShowhowBooking frame = new ShowhowBooking();
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
	public ShowhowBooking() {
		setResizable(false);
		setTitle("Book a ShowHow");
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 552, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel mainPanelBorder = new JPanel();
		mainPanelBorder.setBorder(
				new TitledBorder(null, "Booking Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mainPanelBorder.setBounds(6, 12, 524, 297);
		contentPane.add(mainPanelBorder);
		mainPanelBorder.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(6, 17, 512, 268);
		mainPanelBorder.add(mainPanel);
		mainPanel.setLayout(null);

		JPanel customerNameBorder = new JPanel();
		customerNameBorder
				.setBorder(new TitledBorder(null, "Customer Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		customerNameBorder.setBounds(146, 0, 171, 48);
		mainPanel.add(customerNameBorder);
		customerNameBorder.setLayout(null);

		customerNameBox = new JTextField();
		customerNameBox.setBounds(6, 17, 153, 25);
		customerNameBorder.add(customerNameBox);
		customerNameBox.setToolTipText("Customer Name");
		customerNameBox.setColumns(10);

		JPanel customerTelephoneBorder = new JPanel();
		customerTelephoneBorder.setLayout(null);
		customerTelephoneBorder.setBorder(
				new TitledBorder(null, "Customer Telephone", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		customerTelephoneBorder.setBounds(329, 0, 171, 48);
		mainPanel.add(customerTelephoneBorder);

		customerPhoneBox = new JTextField();
		customerPhoneBox.setToolTipText("Customer Telephone");
		customerPhoneBox.setColumns(10);
		customerPhoneBox.setBounds(6, 17, 153, 25);
		customerTelephoneBorder.add(customerPhoneBox);

		JPanel customerTitleBorder = new JPanel();
		customerTitleBorder.setLayout(null);
		customerTitleBorder.setBorder(
				new TitledBorder(null, "Customer Title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		customerTitleBorder.setBounds(12, 0, 122, 48);
		mainPanel.add(customerTitleBorder);

		customerTitleBox = new JTextField();
		customerTitleBox.setToolTipText("Customer Title");
		customerTitleBox.setColumns(10);
		customerTitleBox.setBounds(6, 17, 110, 25);
		customerTitleBorder.add(customerTitleBox);

		JButton createBookingButton = new JButton("Create Booking");
		createBookingButton.setBounds(329, 243, 171, 25);
		mainPanel.add(createBookingButton);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(12, 60, 305, 208);
		mainPanel.add(calendar);
		calendar.setWeekOfYearVisible(false);
		calendar.setTodayButtonVisible(true);
		calendar.getDayChooser().getDay();
		calendar.setMinSelectableDate(new Date());

		JPanel timePanel = new JPanel();
		timePanel.setBorder(new TitledBorder(null, "ShowHow Time", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		timePanel.setBounds(329, 48, 171, 190);
		mainPanel.add(timePanel);
		timePanel.setLayout(null);

		JPanel showhowTimePanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) showhowTimePanel.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(10);
		showhowTimePanel.setBounds(12, 17, 147, 161);
		timePanel.add(showhowTimePanel);

		JRadioButton oneHourRadio = new JRadioButton("1:00 PM");
		oneHourRadio.setSelected(true);
		showhowTimePanel.add(oneHourRadio);

		JRadioButton twoHourRadio = new JRadioButton("2:00 PM");
		showhowTimePanel.add(twoHourRadio);

		JRadioButton threeHourRadio = new JRadioButton("3:00 PM");
		showhowTimePanel.add(threeHourRadio);

		JRadioButton fourHourRadio = new JRadioButton("4:00 PM");
		showhowTimePanel.add(fourHourRadio);

		ButtonGroup timeSelectionButtonGroup = new ButtonGroup();

		timeSelectionButtonGroup.add(oneHourRadio);
		timeSelectionButtonGroup.add(twoHourRadio);
		timeSelectionButtonGroup.add(threeHourRadio);
		timeSelectionButtonGroup.add(fourHourRadio);

		createBookingButton.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				// check if all the boxes are filled
				if (customerNameBox.getText().isEmpty() || customerTitleBox.getText().isEmpty()
						|| customerPhoneBox.getText().isEmpty()) {
					JOptionPane.showMessageDialog(createBookingButton, "Please ensure that all fields are filled");
					return;
				}

				// check if calendar has selected a day outside of Tues - Thurs
				System.out.println(calendar.getDate().getDay());
				if (calendar.getDate().getDay() > 4 || calendar.getDate().getDay() <= 1) {
					JOptionPane.showMessageDialog(createBookingButton, "ShowHow is only available Tuesday to Thursday");
					return;
				}

				// TODO add booking function
			}
		});

	}

	protected boolean isBoxSelected() {
		// TODO Auto-generated method stub
		return false;
	}
}