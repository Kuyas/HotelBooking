import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HomePage extends JFrame implements ActionListener {

	static JFrame frmHome;
	static JLabel homeLabel_1;
	static JPanel homePanel;
	static JPanel homePanel_1;
	static JButton btnCurrent;
	static JButton btnCancel;
	static JLabel current_1;
	static JButton titleLabel;
	static JLabel current_2;
	static JButton btnSignOut;
	static JButton btnBook;
	static JButton btnFeedBack;
	static String passingUserName;
	static String fullName;


	HomePage()
	{		
	}


	public static void main(String args[]) {
		frmHome = new JFrame();
		frmHome.setTitle("Home Page");
		frmHome.setBounds(100,100,900,600);

		passingUserName = args[0];


		mysqlconnect my = new mysqlconnect();
		Connection c = my.connectToDB();

		try {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT name from users WHERE username ='"+args[0]+"'");
			while(rs.next()) {
				fullName = rs.getString(1);
			}
		}catch(Exception e) {
			System.out.println(e);
			fullName=" ";
		}


		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHome.getContentPane().setLayout(null);

		homeLabel_1 = new JLabel("<html>Hello Mr "+fullName+",<br> Welcome to POPPINS<html>");
		homeLabel_1.setForeground(new Color(0,51,51));
		homeLabel_1.setBounds(83,250,500,150);
		homeLabel_1.setFont(new Font("Impact",Font.PLAIN,30));

		titleLabel = new JButton("POPPINS");
		titleLabel.setForeground(new Color(255,250,250));
		titleLabel.setBackground(new Color(0,0,0));
		titleLabel.setBounds(0,0,900,60);
		titleLabel.setFont(new Font("Impact",Font.ITALIC,40));

		homePanel = new JPanel();
		homePanel.setBounds(0,0,900,60);
		homePanel.setBackground(new Color(0,0,0));
		frmHome.getContentPane().add(homePanel);
		homePanel.setLayout(null);
		homePanel.add(titleLabel);

		homePanel_1 = new JPanel();
		homePanel_1.setBounds(0,60,900,540);
		homePanel_1.setBackground(new Color(0,153,153));
		frmHome.getContentPane().add(homePanel_1);
		homePanel_1.setLayout(null);

		btnCurrent = new JButton("Current Orders");
		btnCurrent.setBackground(new Color(0,0,0));
		btnCurrent.setFont(new Font("Tahoma",Font.BOLD,15));
		btnCurrent.setForeground(new Color(255,250,250));
		btnCurrent.setBounds(740,0,150,108);

		btnCancel = new JButton("Cancel Order");
		btnCancel.setBackground(new Color(0,204,204));
		btnCancel.setFont(new Font("Tahoma",Font.BOLD,15));
		btnCancel.setBounds(740,200,150,108);

		btnSignOut = new JButton("Sign Out");
		btnSignOut.setBackground(new Color(255,255,255));
		btnSignOut.setForeground(new Color(0,0,0));
		btnSignOut.setFont(new Font("Tahoma",Font.BOLD,15));
		btnSignOut.setBounds(740,400,150,108);

		btnBook = new JButton("Book Now");
		btnBook.setBackground(new Color(0,51,51));
		btnBook.setForeground(new Color(192,192,192));
		btnBook.setFont(new Font("Tahoma",Font.BOLD,15));
		btnBook.setBounds(740,100,150,108);

		btnFeedBack = new JButton("Rate The Stay");
		btnFeedBack.setBackground(new Color(0,255,255));
		btnFeedBack.setFont(new Font("Tahoma",Font.BOLD,15));
		btnFeedBack.setBounds(740,300,150,108);


		HomePage te = new HomePage();

		btnCurrent.addActionListener(te);
		btnCancel.addActionListener(te);
		btnSignOut.addActionListener(te);
		btnBook.addActionListener(te);
		btnFeedBack.addActionListener(te);
		titleLabel.addActionListener(te);
		
		homePanel_1.add(btnCurrent);
		homePanel_1.add(btnCancel);
		homePanel_1.add(btnSignOut);
		homePanel_1.add(btnBook);
		homePanel_1.add(btnFeedBack);
		homePanel_1.add(homeLabel_1);

		current_1 = new JLabel("");
		current_1.setBounds(100,100,175,14);

		current_2 = new JLabel("");
		current_2.setBounds(100,120,175,14);


		homePanel_1.add(current_1);
		homePanel_1.add(current_2);

		frmHome.setVisible(true);


	}

	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		if (s.equals("Current Orders")) {
			frmHome.setVisible(false);
			CurrentOrders.main(new String[] {passingUserName});
		}
		if (s.equals("Cancel Order"))
		{
			frmHome.setVisible(false);
			CancelLayout.main(new String[] {passingUserName});
		}
		if(s.equals("Sign Out"))
		{
			frmHome.setVisible(false);
			Login.main(new String[] {"Successfully logged out"});
		}
		if(s.equals("Book Now"))
		{
			frmHome.setVisible(false);
			SearchPage.main(new String[] {passingUserName,fullName});
		}
		if(s.equals("Rate The Stay"))
		{
			frmHome.setVisible(false);
			Rating.main(new String[] {passingUserName});
		}
		if(s.equals("POPPINS")) {
			frmHome.setVisible(false);
			HomePage.main(new String[] {passingUserName});
		}
	}







}