import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.sql.Connection;

public class CurrentOrders extends JFrame implements ActionListener {
	
	static JFrame frmHome;
	static JLabel labelCheckIn;
	static JLabel labelHotelBooked;
	static JLabel labelBookingRef;
	static JLabel labelStatus;
	static JLabel labelCost;
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
	
	
	CurrentOrders()
	{		
	}
	
	
	public static void main(String args[]) {
		frmHome = new JFrame();
		frmHome.setTitle("Home Page");
		frmHome.setBounds(100,100,900,600);
		
		passingUserName = args[0];
		
		
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmHome.getContentPane().setLayout(null);
		
        labelHotelBooked = new JLabel(" ");
        if(DisplayAll.hotelBooked(passingUserName)!="error")
        {labelHotelBooked.setText("<html>" +"Hotel Name<br>"+DisplayAll.hotelBooked(passingUserName)+"</html>");
        labelHotelBooked.setBounds(100,0,400,500);}
        else
        {labelHotelBooked.setText("");
        labelHotelBooked.setBounds(0,0,0,0);}
        labelHotelBooked.setForeground(new Color(255,250,250));
        labelHotelBooked.setFont(new Font("Calibri",Font.ITALIC,20));
        
        labelCheckIn = new JLabel(" ");
        if(DisplayAll.hotelBooked(passingUserName)!="error")
        {labelCheckIn.setText("<html>" +"Check- In<br>"+DisplayAll.checkIn(passingUserName)+"</html>");
        labelCheckIn.setBounds(550,0,400,500);}
        else
        {labelCheckIn.setText("");
        labelCheckIn.setBounds(0,0,0,0);}
        labelCheckIn.setForeground(new Color(255,250,250));
        labelCheckIn.setFont(new Font("Calibri",Font.ITALIC,20));
        
        labelBookingRef = new JLabel("");
        if(DisplayAll.bookingId(passingUserName).equals(" "))
        {	
        labelBookingRef.setText("No Bookings Made");
        labelBookingRef.setBounds(80,100,300,500);}
        else
        {labelBookingRef.setText("<html>" +"Book Ref<br>"+DisplayAll.bookingId(passingUserName)+"</html>");
        labelBookingRef.setBounds(0,0,100,500);}
        labelBookingRef.setForeground(new Color(255,250,250));
        labelBookingRef.setFont(new Font("Calibri",Font.ITALIC,20));
        
        labelStatus = new JLabel("");
        if(DisplayAll.status(passingUserName)!="error")
        {labelStatus.setText("<html>" +"Status<br>"+DisplayAll.status(passingUserName)+"</html>");
        labelStatus.setBounds(400,0,80,500);}
        else
        {labelStatus.setText("");
        labelStatus.setBounds(0,0,0,0);}
        labelStatus.setForeground(new Color(255,250,250));
        labelStatus.setFont(new Font("Calibri",Font.ITALIC,20));
        
        labelCost = new JLabel(" ");
        if(DisplayAll.hotelBooked(passingUserName)!="error")
        {labelCost.setText("<html>" +"Cost<br>"+DisplayAll.cost(passingUserName)+"</html>");
        labelCost.setBounds(490,0,60,500);}
        else
        {labelCost.setText("");
        labelCost.setBounds(0,0,0,0);}
        labelCost.setForeground(new Color(255,250,250));
        labelCost.setFont(new Font("Calibri",Font.ITALIC,20));
		
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
        homePanel_1.setBackground(new Color(0,0,0));
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
        
        
        CurrentOrders te = new CurrentOrders();
        
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
        homePanel_1.add(labelHotelBooked);
        homePanel_1.add(labelBookingRef);
        homePanel_1.add(labelStatus);
        homePanel_1.add(labelCost);
        homePanel_1.add(labelCheckIn);
        
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
        	SearchPage.main(new String[] {passingUserName," "});
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