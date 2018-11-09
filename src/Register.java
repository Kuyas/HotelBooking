import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class Register extends JFrame implements ActionListener {
    // JTextField
    static JTextField fullNameField;
    static JTextField emailField;
    static JTextField userNameField;
    // JFrame
    static JPanel contentPane;
    static String dateOfBirth;

    static JFrame frmRegister;
    static JPasswordField passwordField;
    // JButton
    static JDateChooser calenderField;

    static JTextArea addressField;

    static JButton btnSignUp;
    static JButton back;
    static JPanel panelTop;

    static JPanel panelBottom;

    // labelHeading to diaplay text
    static JLabel labelHeading;
    static JLabel labelDateOfBirth;
    static JLabel labelAddress;
    static JLabel labelPassword;
    static JLabel labelFullName;
    static JLabel labelEmail;
    static JLabel labelUserName;
    static JLabel labelWrongCredentials;

    // default constructor
    Register()
    {
    }

    // main class
    public static void main(String[] args)
    {
        // create a new frame to stor text field and button
        frmRegister = new JFrame();
        frmRegister.setTitle("Hotel Booking");
        //frmRegister.setResizable(false);
        frmRegister.setBounds(100,100,900,600);

        //frmRegister.pack(); // Important line!!!
        //frmRegister.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //frmRegister.setUndecorated(true);
        frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmRegister.getContentPane().setLayout(null);
        // create a labelHeading to display text
        labelFullName = new JLabel("Full Name:");
        labelFullName.setForeground(new Color(255,250,250));
        //labelUserName.setBounds(83,34,111,27);
        labelFullName.setBounds(166,20,200,50);
        labelFullName.setFont(new Font("Tahoma",Font.BOLD,28));

        labelDateOfBirth = new JLabel("DOB:");
        labelDateOfBirth.setForeground(new Color(255,250,250));
        //labelUserName.setBounds(83,34,111,27);
        labelDateOfBirth.setBounds(166,70,200,50);
        labelDateOfBirth.setFont(new Font("Tahoma",Font.BOLD,28));

        passwordField = new JPasswordField();
        //passwordField.setBounds(192,92,143,20);
        passwordField.setBounds(384,330,300,40);
        passwordField.setFont(new Font("Tahoma",Font.BOLD,28));

        labelAddress = new JLabel("Address:");
        labelAddress.setForeground(new Color(255,250,250));
        //labelPassword.setBounds(83,86,111,27);
        labelAddress.setBounds(166,120,200,50);
        labelAddress.setFont(new Font("Tahoma",Font.BOLD,28));

        labelWrongCredentials = new JLabel("");
        //labelWrongCredentials.setBounds(141,133,175,14);
        labelWrongCredentials.setBounds(50,380,800,50);
        labelWrongCredentials.setForeground(new Color(255,0,0));
        labelWrongCredentials.setFont(new Font("Tahoma",Font.BOLD,28));


        labelHeading =  new JLabel("REGISTER",SwingConstants.LEFT);
        labelHeading.setForeground(new Color(255,250,250));
        labelHeading.setBounds(10,2,200,46);
        labelHeading.setFont(new Font("Tahoma",Font.BOLD,30));

        panelTop = new  JPanel();
        //panelTop.setBounds(0,0,frmRegister.getContentPane().getSize().width,46);
        panelTop.setBounds(0,0,900,60);
        panelTop.setBackground(new Color(255,165,0));
        frmRegister.getContentPane().add(panelTop);
        panelTop.setLayout(null);

        panelBottom = new JPanel();
        panelBottom.setBounds(0,60,900,540);
        panelBottom.setBackground(new Color(112,128,144));
        frmRegister.getContentPane().add(panelBottom);
        panelBottom.setLayout(null);
        // create a new button
        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBackground(new Color(255,255,255));
        btnSignUp.setFont(new Font("Tahoma",Font.BOLD,30));
        //btnSignUp.setBounds(227,158,89,23);
        btnSignUp.setBounds(454,450,200,50);

        back = new JButton("Back");
        back.setBackground(new Color(255,255,255));
        back.setFont(new Font("Tahoma",Font.BOLD,30));
        //btnSignUp.setBounds(227,158,89,23);
        back.setBounds(246,450,200,50);

        fullNameField = new JTextField();
        fullNameField.setFont(new Font("Tahoma",Font.PLAIN,28));
        //textField.setBounds(192,40,143,20);
        fullNameField.setBounds(384,20,300,40);

        addressField = new JTextArea();
        addressField.setFont(new Font("Tahoma",Font.PLAIN,24));
        //textField.setBounds(192,40,143,20);
        addressField.setBounds(384,120,300,100);

        labelEmail = new JLabel("E-mail:");
        labelEmail.setForeground(new Color(255,250,250));
        //labelUserName.setBounds(83,34,111,27);
        labelEmail.setBounds(166,230,200,50);
        labelEmail.setFont(new Font("Tahoma",Font.BOLD,28));

        emailField = new JTextField();
        emailField.setFont(new Font("Tahoma",Font.PLAIN,28));
        //textField.setBounds(192,40,143,20);
        emailField.setBounds(384,230,300,40);

        labelUserName = new JLabel("Username:");
        labelUserName.setForeground(new Color(255,250,250));
        //labelUserName.setBounds(83,34,111,27);
        labelUserName.setBounds(166,280,200,50);
        labelUserName.setFont(new Font("Tahoma",Font.BOLD,28));

        userNameField = new JTextField();
        userNameField.setFont(new Font("Tahoma",Font.PLAIN,28));
        //textField.setBounds(192,40,143,20);
        userNameField.setBounds(384,280,300,40);

        labelPassword = new JLabel("Password:");
        labelPassword.setForeground(new Color(255,250,250));
        //labelPassword.setBounds(83,86,111,27);
        labelPassword.setBounds(166,330,200,50);
        labelPassword.setFont(new Font("Tahoma",Font.BOLD,28));

        contentPane = new JPanel();
    		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    		//frmRegister.setContentPane(contentPane);
    		//contentPane.setLayout(null);
        calenderField = new JDateChooser();

        calenderField.setDateFormatString("yyyy-MM-dd");
		    calenderField.setBounds(384, 70, 300, 40);

		    panelBottom.add(calenderField);

    		// create a object of the text class
        Register te = new Register();

        btnSignUp.addActionListener(te);
        back.addActionListener(te);
        calenderField.getCalendarButton().addActionListener(te);


        panelTop.add(labelHeading);

        panelBottom.add(passwordField);
        panelBottom.add(labelFullName);
        panelBottom.add(btnSignUp);
        panelBottom.add(fullNameField);
        panelBottom.add(labelPassword);
        panelBottom.add(labelWrongCredentials);
        panelBottom.add(labelDateOfBirth);
        panelBottom.add(addressField);
        panelBottom.add(labelAddress);
        panelBottom.add(labelEmail);
        panelBottom.add(emailField);
        panelBottom.add(labelUserName);
        panelBottom.add(userNameField);
        panelBottom.add(back);

        // set the size of frame

        frmRegister.setVisible(true);
        //f.show();
    }

    // if the button is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("Sign Up")) {
            dateOfBirth = ((JTextField)(calenderField.getDateEditor().getUiComponent())).getText();//Go Backend and Initiate new Frame
            if (validateUser.checkEmail(emailField.getText()))
            {
              if (validateUser.validate(userNameField.getText()))
              {
                addUser.add(fullNameField.getText(), addressField.getText(), emailField.getText(), userNameField.getText(), String.copyValueOf(passwordField.getPassword()), dateOfBirth);
              }
              else
              {
                labelWrongCredentials.setText("Username already exists");
              }
            }
            else
            {
              labelWrongCredentials.setText("Email ID is Incorrect");
            }

        }
        if (s.equals("Back")){
          frmRegister.setVisible(false);
          Login.main(new  String[] {"a", "b", "c"});
        }
    }



}
