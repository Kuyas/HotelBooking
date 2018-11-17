import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Rating extends JFrame implements ActionListener {
	// JTextField
	static JComboBox<String> HotelsStayedIn;
	// JFrame
	static JFrame frmRating;
	// JButton
	static JSlider givenRating;
	static JPanel panelTop;
	static JPanel panelBottom;
	static JButton btnSubmit;

	// labelHeading to diaplay text
	static JButton titleLabel;
	static JLabel labelRating;
	static JLabel labelHotelName;
	static JLabel labelWrongCredentials;
	static JButton btnSignOut;
	static JButton btnBook;
	static JButton btnFeedBack;
	static JButton btnCurrent;
	static JButton btnCancel;
	static String passingUserName;
	static int rating;

	// default constructor
	Rating() {
	}

	// main class
	public static void main(String[] args) {
		// create a new frame to stor text field and button
		frmRating = new JFrame();
		frmRating.setTitle("Hotel Booking");
		frmRating.setBounds(100, 100, 900, 600);

		passingUserName = args[0];

		frmRating.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRating.getContentPane().setLayout(null);
		// create a labelHeading to display text
		labelHotelName = new JLabel("Hotel :");
		// labelHotelName: .setBounds(83,34,111,27);
		labelHotelName.setBounds(166, 68, 200, 50);
		labelHotelName.setFont(new Font("Tahoma", Font.BOLD, 28));

		labelRating = new JLabel("Rating :");
		// labelRating.setBounds(83,86,111,27);
		labelRating.setBounds(166, 172, 200, 50);
		labelRating.setFont(new Font("Tahoma", Font.BOLD, 28));

		labelWrongCredentials = new JLabel("");
		// labelWrongCredentials.setBounds(141,133,175,14);
		labelWrongCredentials.setBounds(50, 266, 800, 50);
		labelWrongCredentials.setForeground(new Color(255, 0, 0));
		labelWrongCredentials.setFont(new Font("Tahoma", Font.BOLD, 28));

		titleLabel = new JButton("POPPINS");
		titleLabel.setForeground(new Color(255, 250, 250));
		titleLabel.setBackground(new Color(0, 0, 0));
		titleLabel.setBounds(0, 0, 900, 60);
		titleLabel.setFont(new Font("Impact", Font.ITALIC, 40));

		panelTop = new JPanel();
		// panelTop.setBounds(0,0,frmRating.getContentPane().getSize().width,46);
		panelTop.setBounds(0, 0, 900, 60);
		panelTop.setBackground(new Color(0, 0, 0));
		frmRating.getContentPane().add(panelTop);
		panelTop.setLayout(null);

		panelBottom = new JPanel();
		panelBottom.setBounds(0, 60, 900, 540);
		panelBottom.setBackground(new Color(0, 255, 255));
		frmRating.getContentPane().add(panelBottom);
		panelBottom.setLayout(null);
		// create a new button
		givenRating = new JSlider(JSlider.HORIZONTAL, 0, 5, 1);
		givenRating.setMajorTickSpacing(1);
		givenRating.setPaintTicks(true);
		givenRating.setPaintLabels(true);
		givenRating.setBounds(384, 172, 200, 50);
		givenRating.setBackground(new Color(0,255, 255));
		givenRating.setForeground(new Color(0, 0, 0));

		String[] Hotels = DisplayAll.hotelList(passingUserName);
		HotelsStayedIn = new JComboBox<String>(Hotels);
		HotelsStayedIn.setBounds(384, 68, 200, 50);

		btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(new Color(255, 255, 255));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSubmit.setBounds(454, 300, 200, 50);

		labelWrongCredentials = new JLabel("");
		labelWrongCredentials.setBounds(50, 250, 800, 50);
		labelWrongCredentials.setForeground(new Color(255, 0, 0));
		labelWrongCredentials.setFont(new Font("Tahoma", Font.BOLD, 28));

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

		btnFeedBack = new JButton("Rate The Stay");
		btnFeedBack.setBackground(new Color(0, 255, 255));
		btnFeedBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnFeedBack.setBounds(740, 300, 150, 108);

		Rating te = new Rating();
		btnSubmit.addActionListener(te);
		btnCurrent.addActionListener(te);
		btnCancel.addActionListener(te);
		btnSignOut.addActionListener(te);
		btnBook.addActionListener(te);
		btnFeedBack.addActionListener(te);
		titleLabel.addActionListener(te);

		panelTop.add(titleLabel);

		panelBottom.add(labelHotelName);
		panelBottom.add(HotelsStayedIn);
		panelBottom.add(givenRating);
		panelBottom.add(labelRating);
		panelBottom.add(labelWrongCredentials);
		panelBottom.add(btnSubmit);
		panelBottom.add(btnCurrent);
		panelBottom.add(btnCancel);
		panelBottom.add(btnSignOut);
		panelBottom.add(btnBook);
		panelBottom.add(btnFeedBack);
		// set the size of frame

		frmRating.setVisible(true);

		// f.show();
	}

	// if the vutton is pressed
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		String hotel = (String) HotelsStayedIn.getSelectedItem();

		if (hotel.isEmpty()) {
			labelWrongCredentials.setText("Fill in all the fields!!");
		} else {
			if (s.equals("Submit")) {
				rating = (givenRating.getValue());
				mysqlconnect my = new mysqlconnect();
				Connection c = my.connectToDB();
				Statement st;
				try {
					st = c.createStatement();
					int rs = st.executeUpdate("UPDATE `rating` SET `rating`=`rating`+" + rating
							+ ",`total_ratings`=`total_ratings`+1 WHERE hotel='"+hotel+"'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				HomePage.main(new String[] {passingUserName});
			}
		}
		if (s.equals("Current Orders")) {
			frmRating.setVisible(false);
			CurrentOrders.main(new String[] { passingUserName });
		}
		if (s.equals("Cancel Order")) {
			frmRating.setVisible(false);
			CancelLayout.main(new String[] { passingUserName });
		}
		if (s.equals("Sign Out")) {
			frmRating.setVisible(false);
			Login.main(new String[] { "Successfully logged out" });
		}
		if (s.equals("Book Now")) {
			frmRating.setVisible(false);
			SearchPage.main(new String[] { passingUserName, " " });
		}
		if (s.equals("Rate The Stay")) {
			frmRating.setVisible(false);
			Rating.main(new String[] { passingUserName });
		}
		if (s.equals("POPPINS")) {
			frmRating.setVisible(false);
			HomePage.main(new String[] { passingUserName });
		}

	}

}
