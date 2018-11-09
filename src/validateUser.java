import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

public class validateUser {

	static boolean validate(String username, String password) throws NoSuchAlgorithmException {

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
	static boolean validate(String username) {
		if(username.isEmpty()) {
			return false;
		}
		mysqlconnect my = new mysqlconnect();
		Connection c = my.connectToDB();
		try {
				Statement st = c.createStatement();
				ResultSet rs = st.executeQuery("SELECT user_id from users WHERE username ='"+username+"'");
				while(rs.next()) {
					String userid = rs.getString(1);
					int uid = Integer.parseInt(userid);
					if(uid > -1) {
						return true;
					}else {
						return false;
					}			
				}
			}catch(Exception e) {
			System.out.println(e);
			}
		
		return false;
	}

	static boolean checkEmail(String email) {
		if(email.isEmpty())
		{
			return false;
		}
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		if (pat.matcher(email).matches())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
