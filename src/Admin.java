import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

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
        btnViewHotels.setBounds(700,10,200,100);

        btnViewBookings = new JButton("<html>"+"View<br>Bookings"+"</html>");
        btnViewBookings.setBackground(new Color(255,255,255));
        btnViewBookings.setFont(new Font("Tahoma",Font.BOLD,30));
        //btnAddHotels.setBounds(227,158,89,23);
        btnViewBookings.setBounds(700,115,200,100);


        btnEditHotels = new JButton("<html>"+"Edit<br>Hotels"+"</html>");
        btnEditHotels.setBackground(new Color(255,255,255));
        btnEditHotels.setFont(new Font("Tahoma",Font.BOLD,30));
        //btnEditHotels.setBounds(85,158,89,23);
        btnEditHotels.setBounds(700,220,200,100);

        btnAddHotels = new JButton("<html>"+"Add<br>Hotels"+"</html>");
        btnAddHotels.setBackground(new Color(255,255,255));
        btnAddHotels.setFont(new Font("Tahoma",Font.BOLD,30));
        //btnAddHotels.setBounds(227,158,89,23);
        btnAddHotels.setBounds(700,325,200,100);

        btnSignOut = new JButton("<html>"+"Sign<br>Out"+"</html>");
        btnSignOut.setBackground(new Color(255,255,255));
        btnSignOut.setFont(new Font("Tahoma",Font.BOLD,30));
        //btnAddHotels.setBounds(227,158,89,23);
        btnSignOut.setBounds(700,430,200,100);

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

            /*

            try
            {
              if (validateUser.validate(userNameField.getText(), password ))
              {
                MainPage.main(new String[] {userNameField.getText()});
              }
              else
              {
                labelWrongCredentials.setText("Username or Password entered is Incorrect.");
              }
      			} catch (NoSuchAlgorithmException e1)
            {
      				e1.printStackTrace();
      			}
            */


        }
        else if (s.equals("View Bookings")) {

            /*

            try
            {
              if (validateUser.validate(userNameField.getText(), password ))
              {
                MainPage.main(new String[] {userNameField.getText()});
              }
              else
              {
                labelWrongCredentials.setText("Username or Password entered is Incorrect.");
              }
      			} catch (NoSuchAlgorithmException e1)
            {
      				e1.printStackTrace();
      			}
            */


        }
        else if (s.equals("<html>"+"Edit<br>Hotels"+"</html>")) {

            /*

            try
            {
              if (validateUser.validate(userNameField.getText(), password ))
              {
                MainPage.main(new String[] {userNameField.getText()});
              }
              else
              {
                labelWrongCredentials.setText("Username or Password entered is Incorrect.");
              }
      			} catch (NoSuchAlgorithmException e1)
            {
      				e1.printStackTrace();
      			}
            */


        }
        else if (s.equals("<html>"+"Add<br>Hotels"+"</html>")) {

            /*

            try
            {
              if (validateUser.validate(userNameField.getText(), password ))
              {
                MainPage.main(new String[] {userNameField.getText()});
              }
              else
              {
                labelWrongCredentials.setText("Username or Password entered is Incorrect.");
              }
      			} catch (NoSuchAlgorithmException e1)
            {
      				e1.printStackTrace();
      			}
            */


        }
        else if (s.equals("<html>"+"Sign<br>Out"+"</html>"))
        {
            frmAdmin.setVisible(false);
            Login.main(new  String[] {"a", "b", "c"});
        }
    }

}
