import java.awt.event.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class ModifyLayout extends JFrame implements ActionListener {

	static JFrame frmModify;
	static JPanel homePanel;
	static JLabel titleLabel;
	static JPanel homePanel_1;

	static JLabel labelCheckIn;
	static JLabel labelCheckOut;

	static JButton btnCancel;
	static JButton btnSignOut;
	static JButton btnBook;
	static JButton btnFeedBack;
	static JButton btnCurrent;

	static JButton btnModify;

	static JPanel contentPane1;
	static JPanel contentPane2;

	static JDateChooser calenderCheckIn;
	static JDateChooser calenderCheckOut;

	static String passingUserName;
	static String bookingRef;

	static String noOfPeople;
	static String noOfRooms;
	static String totalCost;
	static String roomID;
	static String checkIn;
	static String checkOut;
	static String location;
	static String idProof;
	static String idProofType;
	static String hotelName;
	static String[] modify;
	static JLabel labelWrongCredentials;
	static int key;
	static String checkInPrevious;

	ModifyLayout() {
	}

	public static void main(String args[]) {

		frmModify = new JFrame();
		frmModify.setTitle("Cancel Bookings");
		frmModify.setBounds(100, 100, 900, 600);

		passingUserName = args[0];
		bookingRef = args[1];

		frmModify.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModify.getContentPane().setLayout(null);

		titleLabel = new JLabel("Modify Orders", SwingConstants.LEFT);
		titleLabel.setForeground(new Color(255, 250, 250));
		titleLabel.setBounds(10, 2, 500, 46);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 30));

		labelCheckIn = new JLabel("Check In:");
		labelCheckIn.setForeground(new Color(255, 250, 250));
		// labelUserName.setBounds(83,34,111,27);
		labelCheckIn.setBounds(166, 100, 200, 50);
		labelCheckIn.setFont(new Font("Tahoma", Font.BOLD, 28));

		btnCurrent = new JButton("Current Orders");
		btnCurrent.setBackground(new Color(0, 0, 0));
		btnCurrent.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCurrent.setForeground(new Color(255, 250, 250));
		btnCurrent.setBounds(740, 0, 150, 108);

		btnCancel = new JButton("Cancel Order");
		btnCancel.setBackground(new Color(0, 204, 204));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBounds(740, 200, 150, 108);

		btnSignOut = new JButton("Sign Out");
		btnSignOut.setBackground(new Color(255, 255, 255));
		btnSignOut.setForeground(new Color(0, 0, 0));
		btnSignOut.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSignOut.setBounds(740, 400, 150, 108);

		btnBook = new JButton("Book Now");
		btnBook.setBackground(new Color(0, 51, 51));
		btnBook.setForeground(new Color(192, 192, 192));
		btnBook.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBook.setBounds(740, 100, 150, 108);

		btnFeedBack = new JButton("Feed Back");
		btnFeedBack.setBackground(new Color(0, 255, 255));
		btnFeedBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnFeedBack.setBounds(740, 300, 150, 108);

		labelCheckOut = new JLabel("Check Out:");
		labelCheckOut.setForeground(new Color(255, 250, 250));
		// labelUserName.setBounds(83,34,111,27);
		labelCheckOut.setBounds(166, 180, 200, 50);
		labelCheckOut.setFont(new Font("Tahoma", Font.BOLD, 28));
		homePanel = new JPanel();
		homePanel.setBounds(0, 0, 900, 60);
		homePanel.setBackground(new Color(0, 0, 0));
		frmModify.getContentPane().add(homePanel);
		homePanel.setLayout(null);
		homePanel.add(titleLabel);
		frmModify.getContentPane().add(homePanel);

		homePanel_1 = new JPanel();
		homePanel_1.setBounds(0, 60, 900, 540);
		homePanel_1.setBackground(new Color(0, 204, 204));
		frmModify.getContentPane().add(homePanel_1);
		homePanel_1.setLayout(null);

		labelWrongCredentials = new JLabel("");
		labelWrongCredentials.setBounds(50, 400, 800, 50);
		labelWrongCredentials.setForeground(new Color(255, 0, 0));
		labelWrongCredentials.setFont(new Font("Tahoma", Font.BOLD, 28));

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

		btnModify = new JButton("Modify");
		btnModify.setBackground(new Color(255, 255, 255));
		btnModify.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnModify.setBounds(454, 350, 200, 50);

		ModifyLayout te = new ModifyLayout();
		btnModify.addActionListener(te);
		btnCurrent.addActionListener(te);
		btnSignOut.addActionListener(te);
		btnFeedBack.addActionListener(te);
		btnCancel.addActionListener(te);
		btnBook.addActionListener(te);

		homePanel_1.add(calenderCheckIn);
		homePanel_1.add(calenderCheckOut);
		homePanel_1.add(labelCheckIn);
		homePanel_1.add(labelCheckOut);
		homePanel_1.add(btnModify);
		homePanel_1.add(btnCurrent);
		homePanel_1.add(btnSignOut);
		homePanel_1.add(btnFeedBack);
		homePanel_1.add(btnCancel);
		homePanel_1.add(btnBook);
		homePanel_1.add(labelWrongCredentials);
		frmModify.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();

		if (s.equals("Current Orders")) {
			CurrentOrders.main(new String[] { passingUserName });
		}
		if (s.equals("Sign Out")) {
			Login.main(new String[] { "Successfully logged out" });
		}
		if (s.equals("Book Now")) {
			frmModify.setVisible(false);
			SearchPage.main(new String[] { passingUserName, " " });
		}
		if (s.equals("Rate The Stay")) {
			frmModify.setVisible(false);
			Rating.main(new String[] { passingUserName });
		}
		if (s.equals("Rate The Stay")) {
			frmModify.setVisible(false);
			Rating.main(new String[] { passingUserName });
		}
		if (((JTextField) (calenderCheckIn.getDateEditor().getUiComponent())).getText().isEmpty()
				|| ((JTextField) (calenderCheckOut.getDateEditor().getUiComponent())).getText().isEmpty()) {
			labelWrongCredentials.setText("Fill in all the fields!");}
		else {
			String checkIn = ((JTextField) (calenderCheckIn.getDateEditor().getUiComponent())).getText();// Go Backend and
			// Initiate new
			// Frame
			String checkOut = ((JTextField) (calenderCheckOut.getDateEditor().getUiComponent())).getText();
			long ab = System.currentTimeMillis();
			Date start = Date.valueOf(checkIn);
			Date end = Date.valueOf(checkOut);
			if ((start.getTime() < end.getTime())&&((start.getTime()-ab)>0))
			{
				if (s.equals("Modify")) {
					mysqlconnect my = new mysqlconnect();
					Connection c = my.connectToDB();
					try {
						Statement st = c.createStatement();
						ResultSet rs = st.executeQuery("SELECT * from booking WHERE booking_ref ='" + bookingRef + "'");
						while (rs.next()) {
							noOfPeople = rs.getString(6);
							noOfRooms = rs.getString(5);
							totalCost = rs.getString(13);
							roomID = rs.getString(4);
							checkIn = ((JTextField) (calenderCheckIn.getDateEditor().getUiComponent())).getText();
							checkOut = ((JTextField) (calenderCheckOut.getDateEditor().getUiComponent())).getText();
							location = "";
							idProof = rs.getString(10);
							idProofType = rs.getString(9);
							hotelName = rs.getString(3);
							checkInPrevious = rs.getString(7);
						}
						key = AmountPaid.Span(new String[] {checkInPrevious});
						modify = new String[] { passingUserName, noOfPeople, noOfRooms, totalCost, roomID, checkIn,
								checkOut, location, idProof, idProofType, hotelName };
					} catch (Exception e1) {
						System.out.println(e1);

					}
					CancelBackend.cancelled(new String[] {bookingRef,String.valueOf(key)});
					BookRoom.book(modify);
					HomePage.main(new String[] { passingUserName });

				}
			}
			else
			{
				labelWrongCredentials.setText("Dates are Invalid!");
			}
			
				
		}
		
			}
		

	}

