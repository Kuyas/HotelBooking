import java.sql.Connection;
import java.sql.DriverManager;
public class mysqlconnect {
	String url = "jdbc:mysql://127.0.0.1:3306/";
	String dbName = "hotel_management";
	String driver = "com.mysql.jdbc.Driver";
	String userName = "root";
	String dbpassword = "";
	
	Connection connectToDB() {
		try {
			// loading driver
			Class.forName(driver);
			// Connection set up with database named as user
			Connection c = DriverManager.getConnection(url+dbName,userName,dbpassword);
			return c;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

}
