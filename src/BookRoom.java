import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookRoom {
	public static void book(String args[]) {

		String username = args[0];
		String noOfPeople = args[1];
		String noOfRooms = args[2];
		String totalCost = args[3];
		String roomID = args[4];
		String cid = args[5];
		java.sql.Date checkInDate = java.sql.Date.valueOf(cid);
		String cod = args[6];
		java.sql.Date checkOutDate = java.sql.Date.valueOf(cod);
		String location = args[7];
		String hotelName = args[10];
		String idProofType = args[9];
		String idProof = args[8];
		int waitlist_no = 0;
		int roomCheck = 0;
		int noOfRoomsLeft = -1;
		int totalRoom = 0;

		// String checkInDate;
		// SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		// Date checkInDate = sdf1.parse(args[5]);
		// SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
		// Date checkInDate = sdf1.parse(args[6]);
		// String checkOutDate
		// String location;
		// System.out.println(args[10]);
		// System.out.println(args[1]);
		// System.out.println(args[2]);
		// System.out.println(args[3]);
		// System.out.println(args[4]);
		// System.out.println(args[5]);
		// System.out.println(args[6]);
		// System.out.println(args[7]);
		// System.out.println(args[8]);
		// System.out.println(args[9]);
		int flagRoom = 0; 
		int waitlistcheck = 0;

		mysqlconnect my = new mysqlconnect();
		Connection c = my.connectToDB();
		Statement st;
		try {
			st = c.createStatement();
			ResultSet rs1 = st.executeQuery("SELECT * from booking WHERE room_id = '" + roomID
					+ "' AND status = '1' OR status = '0' ORDER BY waitlist_no DESC");
			System.out.println("IN");
			Statement roomavailst = c.createStatement();
			ResultSet roomavailrs1 = roomavailst
					.executeQuery("SELECT rooms_available from room_details WHERE room_id = '" + roomID + "'");
			int initialroomsAvailable = -1;
			while (roomavailrs1.next()) {
				initialroomsAvailable = Integer.parseInt(roomavailrs1.getString(1));
			}
			while (rs1.next()) {
				Date checkInDateChecker = rs1.getDate(7);
				Date checkOutDateChecker = rs1.getDate(8);
				flagRoom = 1;
				if (checkInDate.compareTo(checkInDateChecker) <= 0 && checkOutDate.compareTo(checkInDateChecker) <= 0
						|| checkInDate.compareTo(checkOutDateChecker) >= 0
						&& checkOutDate.compareTo(checkOutDateChecker) >= 0
						|| initialroomsAvailable > 0) {
					flagRoom = 0;
					int waitlist = Integer.parseInt(rs1.getString(12));
					if (waitlist >= 0 && waitlistcheck == 0) {
						waitlist_no = waitlist + 1;
						waitlistcheck = 1;
					}
				} else {
					flagRoom = 2;// ADD TO WAILIST FLAG
					int waitlist = Integer.parseInt(rs1.getString(12));
					if (waitlist >= 0 && waitlistcheck == 0) {
						waitlist_no = waitlist + 1;
						waitlistcheck = 1;
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			flagRoom = 0;

		} finally {
			// System.out.println("damn");
			// Homepage.main()
		}

		if (flagRoom == 0) {

			System.out.println("IN0");
			// PUSH TO DB
			mysqlconnect my1 = new mysqlconnect();
			Connection c1 = my1.connectToDB();
			int id;
			if (idProofType.equals("PAN")) {
				id = 0;
			} else {
				id = 1;

			}

			Statement st11;
			try {

				Statement roomcheckst = c.createStatement();
				ResultSet roomcheckrs = roomcheckst
						.executeQuery("SELECT rooms_available from room_details WHERE room_id = '" + roomID + "'");
				while (roomcheckrs.next()) {
					totalRoom = Integer.parseInt(roomcheckrs.getString(1));
				}
				int roomAvailable = totalRoom - Integer.parseInt(noOfRooms);
				if (roomAvailable >= 0) {
					Statement roomcheckst1 = c.createStatement();
					int roomcheckrs1 = roomcheckst1.executeUpdate("UPDATE `room_details` SET `rooms_available`='"
							+ roomAvailable + "' WHERE room_id = '" + roomID + "'");
					totalRoom = Integer.parseInt(noOfRooms);
				} else {
					Statement roomcheckst1 = c.createStatement();
					int roomcheckrs1 = roomcheckst1.executeUpdate(
							"UPDATE `room_details` SET `rooms_available`='0' WHERE room_id = '" + roomID + "'");
					noOfRoomsLeft = -(totalRoom - Integer.parseInt(noOfRooms));
					// noOfRooms = String.valueOf(noOfRoomsLeft);
				}

				st11 = c.createStatement();
				int costTotal;
				costTotal = Integer.parseInt(totalCost);
				costTotal = (costTotal / Integer.parseInt(noOfRooms)) * totalRoom;
				int rs = st11.executeUpdate(
						"INSERT INTO `booking`(`username`, `hotel`, `room_id`, `no_of_rooms`, `no_of_people`, `check_in`, `check_out`, `id_proof`, `id_no`, `status`, `waitlist_no`, `total_cost`) "
								+ "VALUES ('" + username + "','" + hotelName + "','" + roomID + "','" + totalRoom
								+ "','" + noOfPeople + "','" + checkInDate + "','" + checkOutDate + "','" + id + "','"
								+ idProof + "','1','0','" + costTotal + "')");
				if (rs == 1) {

					// DO NOTHING
				}
				System.out.println("OUT");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (noOfRoomsLeft > 0) {
					try {
						int costTotal;
						costTotal = Integer.parseInt(totalCost);
						costTotal = (costTotal / Integer.parseInt(noOfRooms)) * noOfRoomsLeft;

						Statement leftoverst = c.createStatement();
						int leftoverrs;
						leftoverrs = leftoverst.executeUpdate(
								"INSERT INTO `booking`(`username`, `hotel`, `room_id`, `no_of_rooms`, `no_of_people`, `check_in`, `check_out`, `id_proof`, `id_no`, `status`, `waitlist_no`, `total_cost`) "
										+ "VALUES ('" + username + "','" + hotelName + "','" + roomID + "','"
										+ noOfRoomsLeft + "','" + noOfPeople + "','" + checkInDate + "','"
										+ checkOutDate + "','" + id + "','" + idProof + "','2','" + waitlist_no + "','"
										+ costTotal + "')");
						if (leftoverrs == 1) {

							// DO NOTHING
						}
						System.out.println("OUT");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}

		} else if (flagRoom == 2) {

			System.out.println("IN");
			// PUSH TO DB
			mysqlconnect my1 = new mysqlconnect();
			Connection c1 = my1.connectToDB();
			int id;
			if (idProofType.equals("PAN")) {
				id = 0;
			} else {
				id = 1;

			}

			Statement st11;
			try {
				st11 = c.createStatement();
				int rs = st11.executeUpdate(
						"INSERT INTO `booking`(`username`, `hotel`, `room_id`, `no_of_rooms`, `no_of_people`, `check_in`, `check_out`, `id_proof`, `id_no`, `status`, `waitlist_no`, `total_cost`) "
								+ "VALUES ('" + username + "','" + hotelName + "','" + roomID + "','" + noOfRooms
								+ "','" + noOfPeople + "','" + checkInDate + "','" + checkOutDate + "','" + id + "','"
								+ idProof + "','2','" + waitlist_no + "','" + totalCost + "')");
				if (rs == 1) {
					// st12 = c.createStatement();
				}
				System.out.println("OUT");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
