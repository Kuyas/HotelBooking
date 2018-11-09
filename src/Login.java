import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Login extends JFrame implements ActionListener {
    // JTextField
    static JTextField userNameField;
    // JFrame
    static JFrame frmLogin;
    static JPasswordField passwordField;
    // JButton
    static JButton btnSignIn;
    static JButton btnSignUp;
    static JPanel panelTop;
    static JPanel panelBottom;

    // labelHeading to display text
    static JLabel labelHeading;
    static JLabel labelPassword;
    static JLabel labelUserName;
    static JLabel labelWrongCredentials;

    // default constructor
    Login()
    {
    }

    // main class
    public static void main(String[] args)
    {
        // create a new frame to stor text field and button
        frmLogin = new JFrame();
        frmLogin.setTitle("Hotel Booking");
        frmLogin.setBounds(100,100,900,600);

        frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLogin.getContentPane().setLayout(null);
        // create a labelHeading to display text
        labelUserName = new JLabel("Username:");
        labelUserName.setForeground(new Color(255,250,250));
        //labelUserName.setBounds(83,34,111,27);
        labelUserName.setBounds(166,68,200,50);
        labelUserName.setFont(new Font("Tahoma",Font.BOLD,28));

        passwordField = new JPasswordField();
        //passwordField.setBounds(192,92,143,20);
        passwordField.setBounds(384,172,300,40);
        passwordField.setFont(new Font("Tahoma",Font.PLAIN,28));

        labelPassword = new JLabel("Password:");
        labelPassword.setForeground(new Color(255,250,250));
        //labelPassword.setBounds(83,86,111,27);
        labelPassword.setBounds(166,172,200,50);
        labelPassword.setFont(new Font("Tahoma",Font.BOLD,28));

        labelWrongCredentials = new JLabel("");
        //labelWrongCredentials.setBounds(141,133,175,14);
        labelWrongCredentials.setBounds(50,266,800,50);
        labelWrongCredentials.setForeground(new Color(255,0,0));
        labelWrongCredentials.setFont(new Font("Tahoma",Font.BOLD,28));


        labelHeading =  new JLabel("LOGIN",SwingConstants.LEFT);
        labelHeading.setForeground(new Color(255,250,250));
        labelHeading.setBounds(10,2,200,46);
        labelHeading.setFont(new Font("Tahoma",Font.BOLD,30));

        panelTop = new  JPanel();
        //panelTop.setBounds(0,0,frmLogin.getContentPane().getSize().width,46);
        panelTop.setBounds(0,0,900,60);
        panelTop.setBackground(new Color(255,165,0));
        frmLogin.getContentPane().add(panelTop);
        panelTop.setLayout(null);

        panelBottom = new JPanel();
        panelBottom.setBounds(0,60,900,540);
        panelBottom.setBackground(new Color(112,128,144));
        frmLogin.getContentPane().add(panelBottom);
        panelBottom.setLayout(null);
        // create a new button

        btnSignIn = new JButton("Sign In");
        btnSignIn.setBackground(new Color(255,255,255));
        btnSignIn.setFont(new Font("Tahoma",Font.BOLD,30));
        //btnSignIn.setBounds(85,158,89,23);
        btnSignIn.setBounds(170,316,200,50);

        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBackground(new Color(255,255,255));
        btnSignUp.setFont(new Font("Tahoma",Font.BOLD,30));
        //btnSignUp.setBounds(227,158,89,23);
        btnSignUp.setBounds(454,316,200,50);

        userNameField = new JTextField();
        userNameField.setFont(new Font("Tahoma",Font.PLAIN,28));
        //userNameField.setBounds(192,40,143,20);
        userNameField.setBounds(384,68,300,40);

        // create a object of the text class
        Login te = new Login();

        // addActionListener to button
        btnSignIn.addActionListener(te);
        btnSignUp.addActionListener(te);


        panelTop.add(labelHeading);

        panelBottom.add(passwordField);
        panelBottom.add(labelUserName);
        panelBottom.add(btnSignIn);
        panelBottom.add(btnSignUp);
        panelBottom.add(userNameField);
        panelBottom.add(labelPassword);
        panelBottom.add(labelWrongCredentials);

        // set the size of frame

        frmLogin.setVisible(true);

        //f.show();
    }

    // if the vutton is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("Sign In")) {
            labelWrongCredentials.setText("Sign In");

            String password = String.copyValueOf(passwordField.getPassword());
            /*
            try
            {
              if (validateUser.validateLogin(userNameField.getText(), password ))
              {
                //System.out.println("FUCK YEAH");
                // Go TO Main Page
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
        if (s.equals("Sign Up"))
        {
            frmLogin.setVisible(false);
            Register.main(new  String[] {"a", "b", "c"});
        }
    }

}
