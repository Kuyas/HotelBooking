import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class validateUser {

	static boolean validateLogin(String username, String password) throws NoSuchAlgorithmException {

		if(username.isEmpty() || password.isEmpty()) {
			return false;
		}
		mysqlconnect my = new mysqlconnect();
		Connection c = my.connectToDB();
		if(c != null) {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			// Change this to UTF-16 if needed
			md.update(password.getBytes(StandardCharsets.UTF_8));
			byte[] digest = md.digest();

			String hex = String.format("%064x", new BigInteger(1, digest));
			password = hex;
			try {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT password from users WHERE username ='"+username+"'");
			while(rs.next()) {
				String pass = rs.getString(1);
				if(pass.equals(password)) {
					return true;

				}else {
					return false;
				}
			}
			}catch(Exception e) {
			System.out.println(e);
			}

		}else {
			return false;
		}
		return false;
	}

}
