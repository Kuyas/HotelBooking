import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;

public class showHotelData{
	static JFrame frameHotelData;
	static JLabel hotelName;
	static JPanel panelTop;
	static JPanel panelBottom;
	static JPanel panelHotel;
	static JLabel labelHotel;
	static JLabel labelHotel1;
	static JLabel labelHotel2;
	
	public static void main(String[] args) {
				 
	
	// create a new frame to store text field and button
		frameHotelData = new JFrame();
		frameHotelData.setTitle("Hotel Booking");
		frameHotelData.setBounds(100,100,900,600);
		frameHotelData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameHotelData.getContentPane().setLayout(null);
		frameHotelData.getContentPane().setBackground(new Color(255, 0, 165));
		
		 panelTop = new  JPanel();
	     //panelTop.setBounds(0,0,frmRegister.getContentPane().getSize().width,46);
	     panelTop.setBounds(0,0,900,60);
	     panelTop.setBackground(new Color(255,165,0));
	     frameHotelData.getContentPane().add(panelTop);
	     panelTop.setLayout(null);
	     
	     panelBottom = new JPanel();
	     panelBottom.setBounds(0,60,900,540);
	     panelBottom.setBackground(new Color(112,128,144));
	     frameHotelData.getContentPane().add(panelBottom);
	     panelBottom.setLayout(new BorderLayout());
	     panelBottom.setBorder(LineBorder.createBlackLineBorder());
	    

		
//	        labelHotel = new JLabel("<html><div>\r\n" + 
//	        		"<div>\r\n" + 
//	        		"<h1>HOTEL NAME</h1>\r\n" + 
//	        		"</div>\r\n" + 
//	        		"</div>\r\n" + 
//	        		"<div>\r\n" + 
//	        		"<div>\r\n" + 
//	        		"<h2>Room Type</h2>\r\n" + 
//	        		"<table width=\"10%\" align=\"left\">\r\n" + 
//	        		"<tbody>\r\n" + 
//	        		"<tr>\r\n" + 
//	        		"<th>Amenities</th>\r\n" + 
//	        		"</tr>\r\n" + 
//	        		"<tr>\r\n" + 
//	        		"<td>Germany</td>\r\n" + 
//	        		"</tr>\r\n" + 
//	        		"<tr>\r\n" + 
//	        		"<td>Germany</td>\r\n" + 
//	        		"</tr>\r\n" + 
//	        		"<tr>\r\n" + 
//	        		"<td>Germany</td>\r\n" + 
//	        		"</tr>\r\n" + 
//	        		"</tbody>\r\n" + 
//	        		"</table><br><br>"+
//	        		"Book for <br />Rs. 3000/ Night\r\n" + 
//	        		"<p>Rating</p>\r\n" + 
//	        		"</div> </html>");
//	        labelHotel.setForeground(new Color(255,250,250));
//	        //labelUserName.setBounds(83,34,111,27);
//	        labelHotel.setBounds(0,0,450,540);
//	        labelHotel.setFont(new Font("Tahoma",Font.BOLD,10));
//	        
//			
//	        labelHotel1 = new JLabel("<html><div>\r\n" + 
//	        		"<div>\r\n" + 
//	        		"<h1>HOTEL NAME</h1>\r\n" + 
//	        		"</div>\r\n" + 
//	        		"</div>\r\n" + 
//	        		"<div>\r\n" + 
//	        		"<div>\r\n" + 
//	        		"<h2>Room Type</h2>\r\n" + 
//	        		"<table width=\"10%\" align=\"left\">\r\n" + 
//	        		"<tbody>\r\n" + 
//	        		"<tr>\r\n" + 
//	        		"<th>Amenities</th>\r\n" + 
//	        		"</tr>\r\n" + 
//	        		"<tr>\r\n" + 
//	        		"<td>Germany</td>\r\n" + 
//	        		"</tr>\r\n" + 
//	        		"<tr>\r\n" + 
//	        		"<td>Germany</td>\r\n" + 
//	        		"</tr>\r\n" + 
//	        		"<tr>\r\n" + 
//	        		"<td>Germany</td>\r\n" + 
//	        		"</tr>\r\n" + 
//	        		"</tbody>\r\n" + 
//	        		"</table><br><br>"+
//	        		"Book for <br />Rs. 3000/ Night\r\n" + 
//	        		"<p>Rating</p>\r\n" + 
//	        		"</div> </html>");
//	        labelHotel1.setForeground(new Color(255,250,250));
//	        //labelUserName.setBounds(83,34,111,27);
//	        labelHotel1.setBounds(450,0,900,540);
//	        labelHotel1.setFont(new Font("Tahoma",Font.BOLD,10));
//	        
//	        labelHotel2 = new JLabel("<html><div>\r\n" + 
//	        		"<div>\r\n" + 
//	        		"<h1>HOTEL NAME</h1>\r\n" + 
//	        		"</div>\r\n" + 
//	        		"</div>\r\n" + 
//	        		"<div>\r\n" + 
//	        		"<div>\r\n" + 
//	        		"<h2>Room Type</h2>\r\n" + 
//	        		"<table width=\"10%\" align=\"left\">\r\n" + 
//	        		"<tbody>\r\n" + 
//	        		"<tr>\r\n" + 
//	        		"<th>Amenities</th>\r\n" + 
//	        		"</tr>\r\n" + 
//	        		"<tr>\r\n" + 
//	        		"<td>Germany</td>\r\n" + 
//	        		"</tr>\r\n" + 
//	        		"<tr>\r\n" + 
//	        		"<td>Germany</td>\r\n" + 
//	        		"</tr>\r\n" + 
//	        		"<tr>\r\n" + 
//	        		"<td>Germany</td>\r\n" + 
//	        		"</tr>\r\n" + 
//	        		"</tbody>\r\n" + 
//	        		"</table><br><br>"+
//	        		"Book for <br />Rs. 3000/ Night\r\n" + 
//	        		"<p>Rating</p>\r\n" + 
//	        		"</div> </html>");
//	        labelHotel2.setForeground(new Color(255,250,250));
//	        //labelUserName.setBounds(83,34,111,27);
//	        labelHotel2.setBounds(450,0,900,540);
//	        labelHotel2.setFont(new Font("Tahoma",Font.BOLD,10));
//	        
//	        panelBottom.add(labelHotel); 
//	        panelBottom.add(labelHotel1);
//	        panelBottom.add(labelHotel2);

	     panelHotel = new JPanel();
	     panelHotel.setBounds(0,60,1000,600);
	     panelHotel.setBackground(new Color(112,128,144));
	     panelHotel.setLayout(new GridLayout(3,3));
	     panelHotel.setPreferredSize(new Dimension(800,600));
	     panelHotel.setBorder(LineBorder.createBlackLineBorder());
	    
	        for(int i = 0 ; i < 3 ; i++) {
	            for( int j = 0 ; j < 3 ; j++  ) {
	            	labelHotel = new JLabel("<html><div>\r\n" + 
	            			"<h2>HOTEL NAME</h2>\r\n" + 
	            			"Room Type\r\n" + 
	            			"  (Rating)\r\n" + 
	            			"<h4>\r\n" + 
	            			"  Amenities\r\n" + 
	            			"  </h4>\r\n" + 
	            			"  <ul>\r\n" + 
	            			"    <li>Amenity1</li>\r\n" + 
	            			"    <li>Amenity1</li>\r\n" + 
	            			"    <li>Amenity1</li>\r\n" + 
	            			"  </ul>\r\n" + 
	            			"</div></html>");
	            	labelHotel.setForeground(new Color(255,250,250));
//	    	        //labelUserName.setBounds(83,34,111,27);
	    	        //labelHotel.setBounds(0,0,450,540);
	    	        labelHotel.setFont(new Font("Tahoma",Font.PLAIN,10));
	    	        labelHotel.setBorder(LineBorder.createBlackLineBorder());
	    	        panelHotel.add(labelHotel);
	            }
	        }
	        JScrollPane scrollPane = new JScrollPane(panelHotel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
	    	        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	     scrollPane.setPreferredSize(new Dimension(400, 300));
	    
	     // Add panel to frame
//	     frameConstraints.gridx = 0;
//	     frameConstraints.gridy = 1;
//	     frameConstraints.weighty = 1;
	     panelBottom.add(panelHotel);
	     panelBottom.add(scrollPane); // add acrollpane to frame

		frameHotelData.setVisible(true);
		
		
		
	}
}
