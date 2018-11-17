import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class SearchPage extends JFrame implements ActionListener {
	// JTextField;
	// JFrame
	static JFrame frmSearch;
	static JPanel panelTop;
	static JPanel panelBottom;
	static JPanel contentPane1;
	static JPanel contentPane2;

	// static JTextField numberOfPeople;

	static JComboBox<String> location;
	// static JComboBox<String> numberOfRooms;
	static JDateChooser calenderCheckIn;
	static JDateChooser calenderCheckOut;
	static String checkIn;
	static String checkOut;
	// labelHeading to diaplay text
	static JLabel labelHeading;
	static JLabel labelLocation;
	static JLabel labelCheckIn;
	static JLabel labelCheckOut;
	static JLabel labelNumberOfRooms;
	static JLabel labelNumberOfPeople;

	static JSlider numberOfRooms;
	static JSlider numberOfPeople;

	static JButton btnSearch;
	static JButton btnBack;
	static JLabel labelWrongCredentials;

	static String passingUserName;

	// default constructor
	SearchPage() {
	}

	// main class
	public static void main(String[] args) {
		passingUserName = args[0];
		// create a new frame to stor text field and button
		frmSearch = new JFrame();
		frmSearch.setTitle("Hotel Booking");
		frmSearch.setBounds(100, 100, 900, 600);

		frmSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSearch.getContentPane().setLayout(null);

		labelLocation = new JLabel("Location:");
		labelLocation.setForeground(new Color(255, 250, 250));
		// labelUserName.setBounds(83,34,111,27);
		labelLocation.setBounds(166, 20, 200, 50);
		labelLocation.setFont(new Font("Tahoma", Font.BOLD, 28));

		labelCheckIn = new JLabel("Check In:");
		labelCheckIn.setForeground(new Color(255, 250, 250));
		// labelUserName.setBounds(83,34,111,27);
		labelCheckIn.setBounds(166, 100, 200, 50);
		labelCheckIn.setFont(new Font("Tahoma", Font.BOLD, 28));

		labelCheckOut = new JLabel("Check Out:");
		labelCheckOut.setForeground(new Color(255, 250, 250));
		// labelUserName.setBounds(83,34,111,27);
		labelCheckOut.setBounds(166, 180, 200, 50);
		labelCheckOut.setFont(new Font("Tahoma", Font.BOLD, 28));

		labelNumberOfRooms = new JLabel("<html>" + "No. Of<br>Rooms :" + "</html>");
		labelNumberOfRooms.setForeground(new Color(255, 250, 250));
		// labelUserName.setBounds(83,34,111,27);
		labelNumberOfRooms.setBounds(166, 260, 200, 70);
		labelNumberOfRooms.setFont(new Font("Tahoma", Font.BOLD, 28));

		labelNumberOfPeople = new JLabel("<html>" + "No. Of<br>People :" + "</html>");
		labelNumberOfPeople.setForeground(new Color(255, 250, 250));
		// labelUserName.setBounds(83,34,111,27);
		labelNumberOfPeople.setBounds(166, 340, 200, 70);
		labelNumberOfPeople.setFont(new Font("Tahoma", Font.BOLD, 28));

		String welcome = "Hello, " + args[1];
		labelHeading = new JLabel(welcome, SwingConstants.LEFT);
		labelHeading.setForeground(new Color(255, 250, 250));
		labelHeading.setBounds(10, 2, 890, 46);
		labelHeading.setFont(new Font("Tahoma", Font.BOLD, 30));

		panelTop = new JPanel();
		// panelTop.setBounds(0,0,frmSearch.getContentPane().getSize().width,46);
		panelTop.setBounds(0, 0, 900, 60);
		panelTop.setBackground(new Color(0, 0, 0));
		frmSearch.getContentPane().add(panelTop);
		panelTop.setLayout(null);

		panelBottom = new JPanel();
		panelBottom.setBounds(0, 60, 900, 540);
		panelBottom.setBackground(new Color(0, 51, 51));
		frmSearch.getContentPane().add(panelBottom);
		panelBottom.setLayout(null);

		String[] choicesLocation = { "", "Delhi", "Bangalore", "Hyderabad" };
		location = new JComboBox<String>(choicesLocation);
		location.setBounds(384, 20, 200, 50);

		contentPane1 = new JPanel();
		calenderCheckIn = new JDateChooser();

		calenderCheckIn.setDateFormatString("yyyy-MM-dd");
		calenderCheckIn.setBounds(384, 100, 300, 50);

		contentPane2 = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// frmRegister.setContentPane(contentPane);
		// contentPane.setLayout(null);
		calenderCheckOut = new JDateChooser();

		calenderCheckOut.setDateFormatString("yyyy-MM-dd");
		calenderCheckOut.setBounds(384, 180, 300, 50);
		SearchPage te = new SearchPage();

		numberOfRooms = new JSlider(JSlider.HORIZONTAL, 0, 10, 1);
		numberOfRooms.setMajorTickSpacing(2);
		numberOfRooms.setMinorTickSpacing(1);
		numberOfRooms.setPaintTicks(true);
		numberOfRooms.setPaintLabels(true);
		numberOfRooms.setBounds(384, 260, 200, 50);
		numberOfRooms.setBackground(new Color(0, 51, 51));
		numberOfRooms.setForeground(new Color(255, 250, 250));

		numberOfPeople = new JSlider(JSlider.HORIZONTAL, 0, 10, 1);
		numberOfPeople.setMajorTickSpacing(2);
		numberOfPeople.setMinorTickSpacing(1);
		numberOfPeople.setPaintTicks(true);
		numberOfPeople.setPaintLabels(true);
		numberOfPeople.setBounds(384, 340, 200, 50);
		numberOfPeople.setBackground(new Color(0, 51, 51));
		numberOfPeople.setForeground(new Color(255, 250, 250));

		btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSearch.setBounds(454, 430, 200, 45);

		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnBack.setBounds(246, 430, 200, 45);

		labelWrongCredentials = new JLabel("");
		labelWrongCredentials.setBounds(50, 400, 800, 50);
		labelWrongCredentials.setForeground(new Color(255, 0, 0));
		labelWrongCredentials.setFont(new Font("Tahoma", Font.BOLD, 28));

		btnSearch.addActionListener(te);
		btnBack.addActionListener(te);
		panelTop.add(labelHeading);

		panelBottom.add(labelLocation);
		panelBottom.add(labelCheckIn);
		panelBottom.add(labelCheckOut);
		panelBottom.add(labelNumberOfRooms);
		panelBottom.add(labelNumberOfPeople);
		panelBottom.add(location);
		panelBottom.add(calenderCheckIn);
		panelBottom.add(calenderCheckOut);
		panelBottom.add(labelWrongCredentials);
		panelBottom.add(numberOfRooms);
		panelBottom.add(numberOfPeople);
		panelBottom.add(btnSearch);
		panelBottom.add(btnBack);
		// set the size of frame

		frmSearch.setVisible(true);

		// f.show();
	}

	// if the vutton is pressed
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		String checkIn = ((JTextField) (calenderCheckIn.getDateEditor().getUiComponent())).getText();// Go Backend and
		// Initiate new
		// Frame
		String checkOut = ((JTextField) (calenderCheckOut.getDateEditor().getUiComponent())).getText();
		String locationString = (String) location.getSelectedItem();

		if (s.equals("Back")) {
			frmSearch.setVisible(false);
			
			HomePage.main(new String[] {passingUserName});
		}
		if (locationString.isEmpty() || checkIn.isEmpty() || checkOut.isEmpty()) {
			labelWrongCredentials.setText("Fill in all the fields!");
		} else {
			long ab = System.currentTimeMillis();
			Date start = Date.valueOf(checkIn);
			Date end = Date.valueOf(checkOut);
			
			if ((start.getTime() < end.getTime())&&((start.getTime()-ab)>0)) {
				long Duration = end.getTime() - start.getTime();
				long days = Duration / (24 * 60 * 60 * 1000);
				System.out.println(days);
				if (s.equals("Search")) {
 
					ShowAllHotels.main(new String[] { passingUserName, locationString, checkIn, checkOut,
							String.valueOf(numberOfRooms.getValue()), String.valueOf(numberOfPeople.getValue()),
							String.valueOf(days)});
					/*
					 * s try { if (validateUser.validate(userNameField.getText(), password )) {
					 * //System.out.println("FUCK YEAH"); // Go TO Main Page } else {
					 * labelWrongCredentials.setText("Username or Password entered is Incorrect.");
					 * } } catch (NoSuchAlgorithmException e1) { e1.printStackTrace(); }
					 */
				}
			} else {
				labelWrongCredentials.setText("Check Out Dates should be after Check In date!");
			}
		}

	}
}
