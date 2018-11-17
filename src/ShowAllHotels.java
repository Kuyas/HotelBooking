import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowAllHotels {

	class Frame extends JFrame {

		JPanel bookingPanel = new JPanel();
		int noOfRooms;
		int noOfPeople;
		int noOfDays;
		long totalCost;
		String username;
		String checkInDate = null;
		String checkOutDate = null;
		String location = null;
		String idProofType = null;
		String idProof = null;
		double rating = 0;
		long totalPeople = 0;
		String avRate = "No Rating";
		String formatRate = null;
		// private int numberOfButtons;
		JButton bookHotelbuttons[] = new JButton[100];

		Frame(String a, String b, String c, String d, String e, String f, String g) {
			username = a;
			location = b;
			checkInDate = c;
			checkOutDate = d;
			noOfRooms = Integer.parseInt(e);
			noOfPeople = Integer.parseInt(f);
			noOfDays = Integer.parseInt(g);
			setTitle("Book Hotels");
			setLayout(new FlowLayout());
			setJPanelandComponent();
			setSize(1000, 1000);
			setBounds(100, 100, 900, 600);
			setVisible(true);
			getContentPane().setBackground(new Color(153, 153, 0));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		private void setJPanelandComponent() {
			// JPanel panelTop = new JPanel();
			// panelTop = new JPanel();
			// panelTop.setBounds(0,0,frmRegister.getContentPane().getSize().width,46);
			// panelTop.setBounds(0,0,900,60);
			// panelTop.setBackground(new Color(255,165,0));
			// add(panelTop);
			// panelTop.setLayout(null);

			ButtonHandler handler = new ButtonHandler();
			bookingPanel.setPreferredSize(new Dimension(1000, 5000));
			bookingPanel.setBackground(new Color(0, 51, 51));
			mysqlconnect my = new mysqlconnect();
			Connection c = my.connectToDB();
			Statement st;
			try {
				st = c.createStatement();
				ResultSet rs = st.executeQuery(
						"SELECT * from room_details WHERE location ='" + location + "' ORDER BY cost_per_night ASC");
				boolean controlColor = false;
				int imageControl = 1;

				for (int i = 0; i < 15; i++) {
					// for(int j =0; j<13;j++) {
					if (rs.next()) {
						String hotelName = rs.getString(1);
						String roomID = rs.getString(2);
						String roomType;
						if (roomID.substring(0, 1).equals("L")) {
							roomType = "Luxury";
						} else if (roomID.substring(0, 1).equals("D")) {
							roomType = "Deluxe";
						} else {
							roomType = "Executive";
						}
						String hotelImagePath;
						if (imageControl <= 5) {
							hotelImagePath = "hotel" + imageControl + ".jpg";
							imageControl++;
						} else {
							hotelImagePath = "hotel4.jpg";
							imageControl = 1;
						}
						Statement ratest = c.createStatement();
						ResultSet rs1 = ratest.executeQuery("SELECT * from rating WHERE hotel ='" + hotelName + "'");
						while (rs1.next()) {
							rating = rs1.getInt(3);
							totalPeople = rs1.getInt(4);
							rating = (rating / totalPeople);
							


						}
						if (rating == 0) {
							avRate = "No Rating";
						} else {
//							avRate = String.valueOf(rating);
							avRate = String.format("%.2f",rating);
						}
						int cost = Integer.parseInt(rs.getString(3));
						String amenities = rs.getString(4);
						JLabel labelHotel = new JLabel("<html><hr><div text-align:\"left\">" + "<h3 align:\"left\">"
								+ hotelName + "|" + "<i>" + roomType + " Room</i>|Rating:<u>" + "  " + avRate + "/5</u>("+totalPeople+" ratings)</h3><hr>"
								+ "<div align=\"center\"><img align=\"center\" src=\"file:D:\\Shreyas\\eclipse-workspace\\HotelBooking\\src\\images\\"
								+ hotelImagePath + "\" width=\"30%\" height=\"30%\"></div>" + "<table align=\"left\">"
								+ "<tbody>" + "<tr>" + "<th><h3><u>Amenities</u></h3></th>" + "</tr>" + "<tr>"
								+ "<td><h4>" + amenities + "</h4></td>" + "</tr>\r\n" + "<tr>\r\n"
								+ "<td><h4>Air Conditioning|Cable|Ceiling Fan|Newspapers| Hot / Cold Running Water|Housekeeping|Mirror|Attached Bathroom|Dustbins</td>\r\n"
								+ "</h4></tr>\r\n" + "</tbody>\r\n" + "</table> \r\n" + "</div><br></html>");

						// Adding Image
						labelHotel.setForeground(new Color(250, 250, 250));
						// //labelUserName.setBounds(83,34,111,27);
						labelHotel.setPreferredSize(new Dimension(600, 550));
						labelHotel.setBounds(0, 0, 450, 540);
						labelHotel.setFont(new Font("Tahoma", Font.PLAIN, 10));
						if (controlColor == false) {
							labelHotel.setBackground(new Color(00, 200, 200));
							controlColor = true;
						} else {
							labelHotel.setBackground(new Color(100, 00, 200));
							controlColor = false;
						}
						labelHotel.setBorder(LineBorder.createGrayLineBorder());

						bookHotelbuttons[i] = new JButton(
								"<html><h3>Book Room<br><u>Rs. " + cost + "/night</u></h3></html>");
						bookHotelbuttons[i].addActionListener(handler);
						bookHotelbuttons[i].putClientProperty("roomid", roomID);
						bookHotelbuttons[i].putClientProperty("hotel", hotelName);
						bookHotelbuttons[i].setBackground(new Color(5, 255, 255));
						// bookHotel.setFont(new Font("Tahoma"));
						bookingPanel.add(labelHotel);
						// bookingPanel.add(imagelabel);
						bookingPanel.add(bookHotelbuttons[i]);
					}
					// }
				}

				JScrollPane js = new JScrollPane(bookingPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				js.setPreferredSize(new Dimension(890, 600));
				add(js);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public class ButtonHandler implements ActionListener {
			private JDialog idProofDialog;

			// This method is called in case an action event occurs.For example you click on
			// the
			// button
			int costPerNight = 0;

			public void actionPerformed(ActionEvent event) {
				JButton button = (JButton) event.getSource();
				String roomID = (String) button.getClientProperty("roomid");
				String hotelName = (String) button.getClientProperty("hotel");
				String retrieveCost = new String(event.getActionCommand());
				int index = retrieveCost.indexOf("/");
				String subString;
				if (index != -1) {
					// System.out.println(idProof);
					// System.out.println(idProofType);
					subString = retrieveCost.substring(30, index);// This will give the cost
					costPerNight = Integer.parseInt(subString);
				}
				totalCost = costPerNight * noOfDays * noOfRooms;
				// SHOW DIALOG BOX FOR PAN/AADHAR
				String[] idString = { "PAN", "AADHAR" };
				JFrame idProofFrame = new JFrame();
				// idProofFrame.setSize(300, 300);
				idProofFrame.setLayout(null);
				idProofFrame.setBounds(200, 200, 400, 300);
				idProofFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				idProofDialog = new JDialog(idProofFrame, "Enter ID Proof Details", true);
				idProofDialog.setLayout(null);
				idProofDialog.setBounds(200, 200, 600, 300);

				JLabel error = new JLabel();
				error.setBounds(80, 150, 200, 40);
				error.setForeground(new Color(255, 0, 0));
				error.setFont(new Font("Tahoma", Font.PLAIN, 20));

				JLabel totalCostLabel = new JLabel();
				totalCostLabel.setBounds(100, 150, 200, 40);
				totalCostLabel.setForeground(new Color(255, 0, 0));
				totalCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				totalCostLabel.setText("<html>Total Cost:<br>" + totalCost + "</html>");

				// DROPDOWN
				JComboBox idList = new JComboBox(idString);
				idList.setBounds(20, 30, 80, 40);
				idList.setSelectedIndex(0);
				// idList.addActionListener(this);
				idList.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						idList.setSelectedIndex(idList.getSelectedIndex());
					}
				});

				JLabel idNo = new JLabel("<html>Enter ID Number<br><html>");
				JTextField idNoField = new JTextField();
				// idNoField.setFont(new Font("Tahoma",Font.PLAIN,28));
				idNoField.setBounds(120, 30, 150, 40);
				idNoField.setFont(new Font("Tahoma", Font.PLAIN, 20));
				JButton submitID = new JButton("Submit");
				submitID.setBounds(20, 100, 80, 40);
				// idProofDialog.add( new JLabel ("<html>Click button to continue."));
				submitID.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						idProofType = (String) idList.getSelectedItem();
						idProof = (String) idNoField.getText();
						if (idProof.isEmpty()) {
							error.setText("Enter the ID No.");
						}

						if (idProofType.equals(null)) {
							idProofType = "PAN";
						}
						if (!idProof.equals("") && !idProofType.equals("")) {
							idProofFrame.setVisible(false);
							HomePage.main(new String[] { username });
						}

					}
				});
				idProofDialog.add(idList);
				// idProofDialog.add(idNo);
				idProofDialog.add(idNoField);
				idProofDialog.add(submitID);
				idProofDialog.add(error);
				idProofDialog.add(totalCostLabel);
				idProofDialog.setSize(300, 300);
				idProofDialog.setVisible(true);

				// gets the name of the button and displays in the label.
				// JButton button = (JButton) event.getSource();
				// String roomID = (String) button.getClientProperty("roomid");
				// String hotelName = (String) button.getClientProperty("hotel");
				// String retrieveCost = new String(event.getActionCommand());
				// int index = retrieveCost.indexOf("/");
				// String subString;

				if (index != -1) {
					// System.out.println(idProof);
					// System.out.println(idProofType);
					// subString = retrieveCost.substring(30, index);// This will give the cost
					// int costPerNight = Integer.parseInt(subString);
					// setVisible(false);
					BookRoom.book(new String[] { username, String.valueOf(noOfPeople), String.valueOf(noOfRooms),
							String.valueOf(totalCost), roomID, checkInDate, checkOutDate, location, idProof,
							idProofType, hotelName });
				}

			}
		}

	}

	public static void main(String args[]) {
		String username = args[0];
		String locationString = args[1];
		String checkIn = args[2];
		String checkOut = args[3];
		String numberOfRooms = args[4];
		String numberOfPeople = args[5];
		String noOfDays = args[6];
		// System.out.println(username);
		// System.out.println(locationString);
		// System.out.println(checkIn);
		// System.out.println(checkOut);
		// System.out.println(numberOfRooms);
		// System.out.println(numberOfPeople);
		ShowAllHotels S = new ShowAllHotels();
		Frame fr = S.new Frame(username, locationString, checkIn, checkOut, numberOfRooms, numberOfPeople, noOfDays);
		// Will get number of rooms and number of people

	}
}
