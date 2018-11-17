import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class CancelLayout extends JFrame implements ActionListener {
	
	static JFrame frmCancel;	
	static JPanel homePanel;
	static JButton titleLabel;
	static JPanel homePanel_1;
	static JButton btnCancel1;
	static JTextField bookingRefField;
	static JLabel labelBookingRef;
	static JButton btnSignOut;
	static JButton btnBook;
	static JButton btnFeedBack;
	static JButton btnCurrent;
	static JButton btnCancel;
	static String passingUserName;
	static JButton btnModify;
	static JLabel labelWrongCredentials;
	
	
	
	CancelLayout()
	{	
	}
	
	public static void main(String args[]) {
		
		frmCancel = new JFrame();
		frmCancel.setTitle("Cancel Bookings");
		frmCancel.setBounds(100,100,900,600);
		
		passingUserName = args[0];
		
		
		frmCancel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCancel.getContentPane().setLayout(null);
        
        
        
        titleLabel = new JButton("POPPINS");
		titleLabel.setForeground(new Color(255,250,250));
		titleLabel.setBackground(new Color(0,0,0));
		titleLabel.setBounds(0,0,900,60);
		titleLabel.setFont(new Font("Impact",Font.ITALIC,40));


        
        homePanel = new JPanel();
		homePanel.setBounds(0,0,900,60);
        homePanel.setBackground(new Color(0,0,0));
        frmCancel.getContentPane().add(homePanel);
        homePanel.setLayout(null);
        homePanel.add(titleLabel);
        frmCancel.getContentPane().add(homePanel);
        
        homePanel_1 = new JPanel();
        homePanel_1.setBounds(0,60,900,540);
        homePanel_1.setBackground(new Color(0,204,204));
        frmCancel.getContentPane().add(homePanel_1);
        homePanel_1.setLayout(null);
        
        btnCancel1 = new JButton("Cancel Order");
        btnCancel1.setBackground(new Color(255,255,255));
        btnCancel1.setFont(new Font("Tahoma",Font.BOLD,15));
        btnCancel1.setBounds(450,250,150,40);
        
        btnModify = new JButton("Modify Order");
        btnModify.setBackground(new Color(255,255,255));
        btnModify.setFont(new Font("Tahoma",Font.BOLD,15));
        btnModify.setBounds(200,250,150,40);
        
        
        CancelLayout te = new CancelLayout();
        btnCancel1.addActionListener(te);
        btnModify.addActionListener(te);
        
        homePanel_1.add(btnCancel1);
        homePanel_1.add(btnModify);
        
        bookingRefField = new JTextField();
        bookingRefField.setFont(new Font("Tahoma",Font.PLAIN,28));
        //userNameField.setBounds(192,40,143,20);
        bookingRefField.setBounds(384,68,300,40);

        homePanel_1.add(bookingRefField);
        
        labelBookingRef = new JLabel("Booking ID:");
        labelBookingRef.setForeground(new Color(255,250,250));
        //labelUserName.setBounds(83,34,111,27);
        labelBookingRef.setBounds(166,68,200,50);
        labelBookingRef.setFont(new Font("Tahoma",Font.BOLD,28));
        
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
        
        
        btnCurrent.addActionListener(te);
        btnSignOut.addActionListener(te);
        btnFeedBack.addActionListener(te);
        btnBook.addActionListener(te);
        titleLabel.addActionListener(te);
        
        labelWrongCredentials = new JLabel("");
		labelWrongCredentials.setBounds(50, 400, 800, 50);
		labelWrongCredentials.setForeground(new Color(255, 0, 0));
		labelWrongCredentials.setFont(new Font("Tahoma", Font.BOLD, 28));

        
        homePanel_1.add(btnCurrent);
        homePanel_1.add(btnCancel);
        homePanel_1.add(btnSignOut);
        homePanel_1.add(btnBook);
        homePanel_1.add(btnFeedBack);
        homePanel_1.add(labelWrongCredentials);
        
        homePanel_1.add(labelBookingRef);
        
        frmCancel.setVisible(true);
        
       }
	
	
	public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(bookingRefField.getText().isEmpty())  {
        	labelWrongCredentials.setText("Fill in all the fields!");
        }
        else {
        	
        if(s.equals("Modify Order"))
        {
        	frmCancel.setVisible(false);
        	ModifyLayout.main(new String[] {passingUserName, bookingRefField.getText()});
        }
        else if (s.equals("Cancel Order"))
        {
//       	frmCancel.setVisible(false);
            Cancel.main(new String[] {passingUserName, bookingRefField.getText()});
        
        }}
        if (s.equals("Current Orders")) 
        {
        	frmCancel.setVisible(false);
            CurrentOrders.main(new String[] {passingUserName});
        }
        if(s.equals("Sign Out"))
        {
        	frmCancel.setVisible(false);
        	Login.main(new String[] {"Successfully logged out"});
        }
        if(s.equals("Rate The Stay"))
		{
			frmCancel.setVisible(false);
			Rating.main(new String[] {passingUserName});
		}
        if(s.equals("Book Now"))
		{
			frmCancel.setVisible(false);
			SearchPage.main(new String[] {passingUserName," "});
		}
        if(s.equals("POPPINS")) {
			frmCancel.setVisible(false);
			HomePage.main(new String[] {passingUserName});
		}
	
	
	
	
	
	
	
	
}
}