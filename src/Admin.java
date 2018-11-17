import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.net.*;
import  java.io.*;

public class Admin extends JFrame implements ActionListener {
    // JTextField
    // JFrame
    static JFrame frmAdmin;
    // JButton
    static JButton btnEditHotels;
    static JButton btnAddHotels;
    static JButton btnViewHotels;
    static JButton btnSignOut;
    static JButton btnViewBookings;
    static JPanel panelTop;
    static JPanel panelBottom;

    // labelHeading to diaplay text
    static JLabel labelHeading;
    // default constructor
    Admin()
    {
    }

    // main class
    public static void main(String[] args)
    {
        // create a new frame to stor text field and button
        frmAdmin = new JFrame();
        frmAdmin.setTitle("Hotel Booking");
        frmAdmin.setBounds(100,100,900,600);

        frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAdmin.getContentPane().setLayout(null);
        // create a labelHeading to display text

        labelHeading =  new JLabel("Hello, Admin",SwingConstants.LEFT);
        labelHeading.setForeground(new Color(255,250,250));
        labelHeading.setBounds(10,2,900,46);
        labelHeading.setFont(new Font("Tahoma",Font.BOLD,30));

        panelTop = new  JPanel();
        //panelTop.setBounds(0,0,frmAdmin.getContentPane().getSize().width,46);
        panelTop.setBounds(0,0,900,60);
        panelTop.setBackground(new Color(255,165,0));
        frmAdmin.getContentPane().add(panelTop);
        panelTop.setLayout(null);

        panelBottom = new JPanel();
        panelBottom.setBounds(0,60,900,540);
        panelBottom.setBackground(new Color(112,128,144));
        frmAdmin.getContentPane().add(panelBottom);
        panelBottom.setLayout(null);
        // create a new button
        btnViewHotels = new JButton("<html>"+"View<br>Hotels"+"</html>");
        btnViewHotels.setBackground(new Color(255,255,255));
        btnViewHotels.setFont(new Font("Tahoma",Font.BOLD,30));
        //btnEditHotels.setBounds(85,158,89,23);
        btnViewHotels.setBounds(740,0,150,108);

        btnViewBookings = new JButton("<html>"+"View<br>Bookings"+"</html>");
        btnViewBookings.setBackground(new Color(255,255,255));
        btnViewBookings.setFont(new Font("Tahoma",Font.BOLD,30));
        //btnAddHotels.setBounds(227,158,89,23);
        btnViewBookings.setBounds(740,100,150,108);


        btnEditHotels = new JButton("<html>"+"View<br>Users"+"</html>");
        btnEditHotels.setBackground(new Color(255,255,255));
        btnEditHotels.setFont(new Font("Tahoma",Font.BOLD,30));
        //btnEditHotels.setBounds(85,158,89,23);
        btnEditHotels.setBounds(740,200,150,108);

        btnAddHotels = new JButton("<html>"+"View<br>Ratings"+"</html>");
        btnAddHotels.setBackground(new Color(255,255,255));
        btnAddHotels.setFont(new Font("Tahoma",Font.BOLD,30));
        //btnAddHotels.setBounds(227,158,89,23);
        btnAddHotels.setBounds(740,300,150,108);

        btnSignOut = new JButton("<html>"+"Sign<br>Out"+"</html>");
        btnSignOut.setBackground(new Color(255,255,255));
        btnSignOut.setFont(new Font("Tahoma",Font.BOLD,30));
        //btnAddHotels.setBounds(227,158,89,23);
        btnSignOut.setBounds(740,400,150,108);

        // create a object of the text class
        Admin te = new Admin();

        // addActionListener to button
        btnEditHotels.addActionListener(te);
        btnAddHotels.addActionListener(te);
        btnViewHotels.addActionListener(te);
        btnViewBookings.addActionListener(te);
        btnSignOut.addActionListener(te);


        panelTop.add(labelHeading);

        panelBottom.add(btnEditHotels);
        panelBottom.add(btnAddHotels);
        panelBottom.add(btnViewHotels);
        panelBottom.add(btnViewBookings);
        panelBottom.add(btnSignOut);

        // set the size of frame

        frmAdmin.setVisible(true);

        //f.show();
    }

    // if the vutton is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("<html>"+"View<br>Bookings"+"</html>")) {
          try {
            String url_open = "http://localhost/phpmyadmin/sql.php?server=1&db=hotel_management&table=booking&pos=0";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
          } catch (Exception urlException) {
          }
        }
        else if (s.equals("<html>"+"View<br>Hotels"+"</html>")) {
          try {
            String url_open = "http://localhost/phpmyadmin/sql.php?server=1&db=hotel_management&table=room_details&pos=0";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
          } catch (Exception urlException) {
          }

        }
        else if (s.equals("<html>"+"View<br>Users"+"</html>")) {
          try {
            String url_open = "http://localhost/phpmyadmin/sql.php?server=1&db=hotel_management&table=users&pos=0";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
          } catch (Exception urlException) {
          }
        }
        else if (s.equals("<html>"+"View<br>Ratings"+"</html>")) {
          try {
            String url_open = "http://localhost/phpmyadmin/sql.php?server=1&db=hotel_management&table=rating&pos=0";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
          } catch (Exception urlException) {
          }
        }
        else if (s.equals("<html>"+"Sign<br>Out"+"</html>"))
        {
            frmAdmin.setVisible(false);
            Login.main(new  String[] {"a", "b", "c"});
        }
    }

}
