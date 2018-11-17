import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class DisplayAll {
	int user_id;
	
	public static String bookingId(String username)
	{
		mysqlconnect my = new mysqlconnect();
		Connection c = my.connectToDB();
		try{
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT booking_ref from booking WHERE username ='"+username+"'");
			String ids=" ";
			
			while(rs.next()) { 
			 ids = ids +"   "+ rs.getString(1)+"<br>";
			 
			 
			 
			
			}
			return ids;
			}
			catch(Exception e) {
				System.out.println(e);
				return ("error");
				}

	}
	
	public static String[] list(String username)
	{
		mysqlconnect my = new mysqlconnect();
		Connection c = my.connectToDB();
		try{
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT booking_ref from booking WHERE username ='"+username+"'");
			String[] ids=new String[100];
			int i = 0;
			while(rs.next()) { 
			 ids[i]=rs.getString(1);
			 System.out.println(ids[i]);
			 i++;
			}
			return ids;
	
			}
			catch(Exception e) {
				System.out.println(e);
				return (new String[] {"error"});
				}

	}
	
	
	
	public static String hotelBooked(String username)
	{
		mysqlconnect my = new mysqlconnect();
		Connection c = my.connectToDB();
		try{
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT hotel from booking WHERE username ='"+username+"'");
			String hotelbook=" ";
			while(rs.next()) { 
			 hotelbook = hotelbook +"   "+ rs.getString(1)
			 +"<br>";
							}
			return hotelbook;
			}
			catch(Exception e) {
				System.out.println(e);
				return ("error");
				}

	}
	
	public static String[] hotelList(String username)
	{
		mysqlconnect my = new mysqlconnect();
		Connection c = my.connectToDB();
		try{
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT DISTINCT hotel from booking WHERE username ='"+username+"'");
			String[] ids=new String[100];
			int i =0;
			while(rs.next()) { 
				ids[i]=rs.getString(1);
				 System.out.println(ids[i]);
				 i++;	
				 System.out.println(ids[i]);
				 }
			return ids;
			}
			catch(Exception e) {
				System.out.println(e);
				return (new String[] {"error"});
				}

	}
	public static String status(String username)
	{
		mysqlconnect my = new mysqlconnect();
		Connection c = my.connectToDB();
		try{
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT status from booking WHERE username ='"+username+"'");
			String ids=" ";
			String stats = null; 
			while(rs.next()) {
				if(rs.getString(1).equals("1")) {
					stats = "Booked";
				}
				else if(rs.getString(1).equals("0")) {
					stats = "Waitlist";
				}
				else if(rs.getString(1).equals("-1")) {
					stats = "Cancelled";
				}
			 ids = ids +"   "+ stats+"<br>";
			 
			 
			 
			
			}
			return ids;
			}
			catch(Exception e) {
				System.out.println(e);
				return ("error");
				}

	}
	
	public static String cost(String username)
	{
		mysqlconnect my = new mysqlconnect();
		Connection c = my.connectToDB();
		try{
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT total_cost from booking WHERE username ='"+username+"'");
			String ids=" ";
			
			while(rs.next()) { 
			 ids = ids +"   "+ rs.getString(1)+"<br>";
			 
			 
			 
			
			}
			return ids;
			}
			catch(Exception e) {
				System.out.println(e);
				return ("error");
				}

	}
	public static String checkIn(String username)
	{
		mysqlconnect my = new mysqlconnect();
		Connection c = my.connectToDB();
		try{
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT check_in from booking WHERE username ='"+username+"'");
			String hotelbook=" ";
			while(rs.next()) { 
			 hotelbook = hotelbook +"   "+ rs.getString(1)
			 +"<br>";
							}
			return hotelbook;
			}
			catch(Exception e) {
				System.out.println(e);
				return ("error");
				}

	}
}

