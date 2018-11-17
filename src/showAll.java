import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Frame extends JFrame {

	Frame()
	{
		setTitle("Book Hotels");
		setLayout(new FlowLayout());
		setJPanelandComponent();
		setSize(900,600);
		setBounds(0,60,900,540);
		setVisible(true);
//		getContentPane().setBackground(new Color(255, 165, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setJPanelandComponent()
	{
//		JPanel panelTop = new JPanel();
//		panelTop = new  JPanel();
//		//panelTop.setBounds(0,0,frmRegister.getContentPane().getSize().width,46);
//		panelTop.setBounds(0,0,900,60);
//		panelTop.setBackground(new Color(255,165,0));
//		add(panelTop);
//		panelTop.setLayout(null);
		JPanel jp = new JPanel();
		jp.setPreferredSize(new Dimension(1000,5000));
		jp.setBackground(new Color(0, 51,51));
		mysqlconnect my = new mysqlconnect();
		Connection c = my.connectToDB();
		Statement st;
		try {
			st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from room_details WHERE location ='Hyderabad' ORDER BY cost_per_night ASC");
			boolean controlColor = false;

			for(int i=0;i<10;i++)
			{
				for(int j =0; j<13;j++) {
					if(rs.next()) {
						String hotelName = rs.getString(1);
						String roomID = rs.getString(2);
						String roomType;
						if(roomID.substring(0,1).equals("L")) {
							roomType = "Luxury";
						}else if(roomID.substring(0,1).equals("D")) {
							roomType = "Deluxe";
						}else {
							roomType = "Executive";
						}
						int cost = Integer.parseInt(rs.getString(3));
						String amenities = rs.getString(4);
						JLabel labelHotel = new JLabel("<html><hr><div text-align:\"left\">" + 
								"<h2 align:\"left\">"+hotelName+"|" + 
								"<i>"+ roomType +" Room</i>|" + 
								"  (Rating)</h2><hr>" + 
								"<table align=\"left\">" + 
								"<tbody>" + 
								"<tr>" + 
								"<th><h3><u>Amenities</u></h3></th>" + 
								"</tr>" + 
								"<tr>" + 
								"<td><h4>"+amenities+"</h4></td>" + 
								"</tr>\r\n" + 
								"<tr>\r\n" + 
								"<td><h4>Air Conditioning|Cable|Ceiling Fan|Newspapers| Hot / Cold Running Water|Housekeeping|Mirror|Attached Bathroom|Dustbins</td>\r\n" + 
								"</h4></tr>\r\n" + 
								"</tbody>\r\n" + 
								"</table> \r\n" + 
								"</div></html>");
						
						labelHotel.setForeground(new Color(250,250,250));
						//	        //labelUserName.setBounds(83,34,111,27);
						labelHotel.setPreferredSize(new Dimension(600,250));
						labelHotel.setBounds(0,0,450,540);
						labelHotel.setFont(new Font("Tahoma",Font.PLAIN,10));
						if(controlColor == false) {
							labelHotel.setBackground(new Color(00,200,200));
							controlColor = true;
						}else{
							labelHotel.setBackground(new Color(100,00,200));
							controlColor = false;
						}
						labelHotel.setBorder(LineBorder.createGrayLineBorder());

						JButton bookHotel = new JButton("<html><h3>Book Room<br><u>Rs. "+cost+"/night      </u></h3></html>");
						bookHotel.setBackground(new Color(5,255,255));
//						bookHotel.setFont(new Font("Tahoma"));
						jp.add(labelHotel);
						jp.add(bookHotel);
					}
				}
			}

			JScrollPane js = new JScrollPane(jp,
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			js.setPreferredSize(new Dimension(900,600));
			add(js);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

public class showAll {
	public static void main(String[] args) {

		Frame fr = new Frame();
		//Will get number of rooms and number of people
	}
}
