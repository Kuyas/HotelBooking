import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class Register extends JFrame implements ActionListener {
    // JTextField
    static JTextField textField;
    // JFrame
    static JPanel contentPane;
    static String dob;

    static JFrame frmLogin;
    static JPasswordField passwordField;
    // JButton
    static JDateChooser dp;

    static JButton btnSignIn;
    static JButton btnSignUp;
    static JPanel panel;

    static JPanel panel_1;

    // label to diaplay text
    static JLabel label;
    static JLabel lblPassword;
    static JLabel lblNewLabel;
    static JLabel pswdIncorrect;

    // default constructor
    Register()
    {
    }

    // main class
    public static void main()
    {
        // create a new frame to store text field and button
        frmLogin = new JFrame();
        frmLogin.setTitle("Hotel Booking");
        //frmLogin.setResizable(false);
        frmLogin.setBounds(100,100,900,600);

        //frmLogin.pack(); // Important line!!!
        //frmLogin.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frmLogin.setVisible(true);

        //frmLogin.setUndecorated(true);
        frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLogin.getContentPane().setLayout(null);
        // create a label to display text
        lblNewLabel = new JLabel("Username:");
        lblNewLabel.setForeground(new Color(255,250,250));
        lblNewLabel.setBounds(83,34,111,27);
        lblNewLabel.setFont(new Font("Tahoma",Font.BOLD,17));

        passwordField = new JPasswordField();
        passwordField.setBounds(192,92,143,20);
        lblPassword = new JLabel("Password:");
        lblPassword.setForeground(new Color(255,250,250));
        lblPassword.setBounds(83,86,111,27);
        lblPassword.setFont(new Font("Tahoma",Font.BOLD,17));

        pswdIncorrect = new JLabel("");
        pswdIncorrect.setBounds(141,133,175,14);

        label =  new JLabel("LOGIN",SwingConstants.LEFT);
        label.setForeground(new Color(255,250,250));
        label.setBounds(10,0,71,46);
        label.setFont(new Font("Tahoma",Font.BOLD,20));

        panel = new  JPanel();
        //panel.setBounds(0,0,frmLogin.getContentPane().getSize().width,46);
        panel.setBounds(0,0,900,46);
        panel.setBackground(new Color(255,165,0));
        frmLogin.getContentPane().add(panel);
        panel.setLayout(null);

        panel_1 = new JPanel();
        panel_1.setBounds(0,46,900,554);
        panel_1.setBackground(new Color(112,128,144));
        frmLogin.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        // create a new button
        btnSignIn = new JButton("Sign In");
        btnSignIn.setBackground(new Color(153,50,204));
        btnSignIn.setBounds(85,158,89,23);

        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBackground(new Color(153,50,204));
        btnSignUp.setBounds(227,158,89,23);

        textField = new JTextField(10);
        textField.setBounds(192,40,143,20);

        contentPane = new JPanel();
    		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    		//frmLogin.setContentPane(contentPane);
    		//contentPane.setLayout(null);
        dp = new JDateChooser();

        dp.setDateFormatString("yyyy-MM-dd");
		    dp.setBounds(135, 32, 167, 20);
		    panel_1.add(dp);

    		// create a object of the text class
        Register te = new Register();

        // addActionListener to button
        btnSignIn.addActionListener(te);
        btnSignUp.addActionListener(te);
        dp.getCalendarButton().addActionListener(te);


        panel.add(label);

        panel_1.add(passwordField);
        panel_1.add(lblNewLabel);
        panel_1.add(btnSignIn);
        panel_1.add(btnSignUp);
        panel_1.add(textField);
        panel_1.add(lblPassword);
        panel_1.add(pswdIncorrect);

        // set the size of frame

        frmLogin.setVisible(true);
        //f.show();
    }

    // if the button is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("Sign In")) {
            pswdIncorrect.setText("Sign In");
            dob = ((JTextField)(dp.getDateEditor().getUiComponent())).getText();//Go Backend and Initiate new Frame
            System.out.println(dob);
        }
        if (s.equals("Sign Up"))
        {
            Register.main();
        }
    }



}