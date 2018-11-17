import java.awt.event.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.*;
import java.sql.Date;

public class CancelBackend {
	static String currentDate;
	static String checkInDate;
	static String totalCost;
	static String roomID;
	static int noOfRooms;
	static int roomAvailable;
	static int updatedCost;
	static int key = 0;
	static int waitlistNo;

	public static String[] cancelled(String[] args) {
		
		 String bookingRef = args[0];
		 key = Integer.parseInt(args[1]);
		
		
		
		// function
		// return String[] check in date, cost of the room, number of nights
		mysqlconnect my = new mysqlconnect();
		Connection c = my.connectToDB();
		Statement st;
		try {
			st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from booking WHERE booking_ref = '" + bookingRef + "'");
			while (rs.next()) {
				checkInDate = rs.getString(7);
				totalCost = rs.getString(13);
				roomID = rs.getString(4);
				noOfRooms = Integer.parseInt(rs.getString(5));
				waitlistNo = rs.getInt(12);
				int cancelrs;
				if (key == 0) {
					updatedCost = 0;
					Statement cancelst = c.createStatement();
					cancelrs = cancelst.executeUpdate("UPDATE `booking` SET `status`='-1', total_cost='" + updatedCost
							+ "' WHERE booking_ref = '" + bookingRef + "'");
				} else {
					Statement cancelst = c.createStatement();
					updatedCost = Integer.parseInt(totalCost);
					updatedCost = updatedCost / 2;
					cancelrs = cancelst.executeUpdate("UPDATE `booking` SET `status`='-1', total_cost='" + updatedCost
							+ "' WHERE booking_ref = '" + bookingRef + "'");

				}
				if (cancelrs == 1) {

					Statement st1 = c.createStatement();
					ResultSet rs1 = st1
							.executeQuery("SELECT rooms_available from room_details WHERE room_id = '" + roomID + "'");
					while (rs1.next()) {
						roomAvailable = Integer.parseInt(rs1.getString(1));
					}
					roomAvailable = roomAvailable + noOfRooms;
					System.out.println("IN3");
					Statement restorst = c.createStatement();
					int addrs = restorst.executeUpdate("UPDATE room_details SET rooms_available = '" + roomAvailable
							+ "' WHERE room_id = '" + roomID + "'");
					
					
					Statement updwaitlist = c.createStatement();
					if(waitlistNo>0) {

						int upwt = updwaitlist
								.executeUpdate("UPDATE `booking` SET `waitlist_no`= `waitlist_no`-1 WHERE room_id = '"
										+ roomID + "' AND status = '" + 0 + "' AND waitlist_no >'"+waitlistNo+"'");
					}
						else if(waitlistNo == 0) {
							int upwt = updwaitlist
									.executeUpdate("UPDATE `booking` SET `waitlist_no`= '0', status = '1' WHERE room_id = '"
											+ roomID + "' AND status = '" + 0 + "' AND waitlist_no ='1'");
							Statement updwaitlist1 = c.createStatement();
							int upwt1 = updwaitlist1
									.executeUpdate("UPDATE `booking` SET `waitlist_no`= `waitlist_no`-1 WHERE room_id = '"
											+ roomID + "' AND status = '" + 0 + "' AND waitlist_no >'"+1+"'");
						}
					System.out.println("Cancellation Succesful");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new String[] { checkInDate, totalCost };
	}

}