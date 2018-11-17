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


public class addUser
{
    static public void add(String name, String address, String emailAddress, String userName, String password,String dob)
    {
      mysqlconnect my = new mysqlconnect();
      Connection c = my.connectToDB();
      try {
      Statement st = c.createStatement();
          try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // Change this to UTF-16 if needed
            md.update(password.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();
            String hex = String.format("%064x", new BigInteger(1, digest));
            password = hex;
          }catch(Exception e1){
            e1.printStackTrace();
          }
      int rs = st.executeUpdate("INSERT INTO `users`(`name`, `dob`, `address`, `email`, `username`, `password`) "
          + "VALUES ('"+ name +"','" + dob +"', '"+ address +"','" + emailAddress+"','"+userName+"','"+password+"')");
	      if(rs == 1) {
	    	  System.out.println("Sign up succesful");
	      }
      }
      catch (SQLException e1) {
      // TODO Auto-generated catch block
      System.out.println("FILL ALL THE FUCKING DETAILS");
      e1.printStackTrace();
      }
    }

}
