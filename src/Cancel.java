import java.awt.event.*;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.time.*;

public class Cancel extends JFrame implements ActionListener {

	static JFrame frmFinalCancel;
	static JPasswordField passwordField;
	static JLabel labelPassword;
	static JButton btnCancel;
	static JPanel homePanel;
	static String passingUserName;
	static String bookingRef;
	static int key;
	static String checkIn;
	
	Cancel()
	{
		}
	
	

	public static void main(String args[]) {

		frmFinalCancel = new JFrame();
		frmFinalCancel.setTitle("Warning!");
		frmFinalCancel.setBounds(200,200,400,300);
		
		passingUserName = args[0];
		bookingRef = args[1];

		
		frmFinalCancel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmFinalCancel.getContentPane().setLayout(null);
        
        homePanel = new JPanel();
		homePanel.setBounds(0,0,400,300);
        homePanel.setBackground(new Color(0,205,205));
        frmFinalCancel.getContentPane().add(homePanel);
        homePanel.setLayout(null);
		
        passwordField = new JPasswordField();
        //passwordField.setBounds(192,92,143,20);
        passwordField.setBounds(0,80,300,40);
        passwordField.setFont(new Font("Tahoma",Font.PLAIN,14));
		
        labelPassword = new JLabel("Password:");
        labelPassword.setForeground(new Color(255,250,250));
        //labelPassword.setBounds(83,86,111,27);
        labelPassword.setBounds(0,30,100,50);
        labelPassword.setFont(new Font("Tahoma",Font.BOLD,14));
		
        btnCancel = new JButton("Cancel Order");
        btnCancel.setBackground(new Color(255,255,255));
        btnCancel.setFont(new Font("Tahoma",Font.BOLD,15));
        btnCancel.setBounds(150,150,150,40);
        
        Cancel te = new Cancel();
        btnCancel.addActionListener(te);
        
        homePanel.add(btnCancel);
        homePanel.add(labelPassword);
        homePanel.add(passwordField);
        
        frmFinalCancel.setVisible(true);
        
        
		
	}
	public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("Cancel Order"))
        {	
        	String password = String.copyValueOf(passwordField.getPassword());
        	try {
				if(validateUser.validate(passingUserName, password)) {
					mysqlconnect my = new mysqlconnect();
					Connection c = my.connectToDB();
					try {
						Statement st = c.createStatement();
						ResultSet rs = st.executeQuery("SELECT * from booking WHERE booking_ref ='" + bookingRef + "'");
						while (rs.next()) {
							checkIn = rs.getString(7);
						}}
					catch (Exception e1) {
							System.out.println(e1);

						}
					key = AmountPaid.Span(new String[] {checkIn});
					CancelBackend.cancelled(new String[] {bookingRef,String.valueOf(key)});
					
					HomePage.main(new String[] {passingUserName});
					}
				else {
					
				}
				
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        }
    }
}