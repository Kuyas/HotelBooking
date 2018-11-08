import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class Register extends JFrame implements ActionListener {
    // JTextField
    static JTextField fullName;
    static JTextField email;
    static JTextField username;
    // JFrame
    static JPanel contentPane;
    static String dob;

    static JFrame frmLogin;
    static JPasswordField passwordField;
    // JButton
    static JDateChooser dp;

    static JTextArea tx;

    static JButton btnSignUp;
    static JPanel panel;

    static JPanel panel_1;

    // label to diaplay text
    static JLabel label;
    static JLabel lbDob;
    static JLabel lbladd;
    static JLabel lblPassword;
    static JLabel lbluse;
    static JLabel lblemail;
    static JLabel lblNewLabel;
    static JLabel pswdIncorrect;

    // default constructor
    Register()
    {
    }

    // main class
    public static void main(String[] args)
    {
        // create a new frame to stor text field and button
        frmLogin = new JFrame();
        frmLogin.setTitle("Hotel Booking");
        //frmLogin.setResizable(false);
        frmLogin.setBounds(100,100,900,600);

        //frmLogin.pack(); // Important line!!!
        //frmLogin.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //frmLogin.setUndecorated(true);
        frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLogin.getContentPane().setLayout(null);
        // create a label to display text
        lblNewLabel = new JLabel("Full Name:");
        lblNewLabel.setForeground(new Color(255,250,250));
        //lblNewLabel.setBounds(83,34,111,27);
        lblNewLabel.setBounds(166,20,200,50);
        lblNewLabel.setFont(new Font("Tahoma",Font.BOLD,28));

        lbDob = new JLabel("DOB:");
        lbDob.setForeground(new Color(255,250,250));
        //lblNewLabel.setBounds(83,34,111,27);
        lbDob.setBounds(166,70,200,50);
        lbDob.setFont(new Font("Tahoma",Font.BOLD,28));

        passwordField = new JPasswordField();
        //passwordField.setBounds(192,92,143,20);
        passwordField.setBounds(384,330,300,40);
        passwordField.setFont(new Font("Tahoma",Font.BOLD,28));

        lbladd = new JLabel("Address:");
        lbladd.setForeground(new Color(255,250,250));
        //lblPassword.setBounds(83,86,111,27);
        lbladd.setBounds(166,120,200,50);
        lbladd.setFont(new Font("Tahoma",Font.BOLD,28));

        pswdIncorrect = new JLabel("");
        //pswdIncorrect.setBounds(141,133,175,14);
        pswdIncorrect.setBounds(282,266,200,50);
        pswdIncorrect.setForeground(new Color(255,0,0));
        pswdIncorrect.setFont(new Font("Tahoma",Font.BOLD,28));


        label =  new JLabel("REGISTER",SwingConstants.LEFT);
        label.setForeground(new Color(255,250,250));
        label.setBounds(10,2,200,46);
        label.setFont(new Font("Tahoma",Font.BOLD,30));

        panel = new  JPanel();
        //panel.setBounds(0,0,frmLogin.getContentPane().getSize().width,46);
        panel.setBounds(0,0,900,60);
        panel.setBackground(new Color(255,165,0));
        frmLogin.getContentPane().add(panel);
        panel.setLayout(null);

        panel_1 = new JPanel();
        panel_1.setBounds(0,60,900,540);
        panel_1.setBackground(new Color(112,128,144));
        frmLogin.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        // create a new button

        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBackground(new Color(255,255,255));
        btnSignUp.setFont(new Font("Tahoma",Font.BOLD,30));
        //btnSignUp.setBounds(227,158,89,23);
        btnSignUp.setBounds(454,380,200,50);

        fullName = new JTextField();
        fullName.setFont(new Font("Tahoma",Font.PLAIN,28));
        //textField.setBounds(192,40,143,20);
        fullName.setBounds(384,20,300,40);

        tx = new JTextArea();
        tx.setFont(new Font("Tahoma",Font.PLAIN,24));
        //textField.setBounds(192,40,143,20);
        tx.setBounds(384,120,300,100);

        lblemail = new JLabel("Email:");
        lblemail.setForeground(new Color(255,250,250));
        //lblNewLabel.setBounds(83,34,111,27);
        lblemail.setBounds(166,230,200,50);
        lblemail.setFont(new Font("Tahoma",Font.BOLD,28));

        email = new JTextField();
        email.setFont(new Font("Tahoma",Font.PLAIN,28));
        //textField.setBounds(192,40,143,20);
        email.setBounds(384,230,300,40);

        lbluse = new JLabel("Username:");
        lbluse.setForeground(new Color(255,250,250));
        //lblNewLabel.setBounds(83,34,111,27);
        lbluse.setBounds(166,280,200,50);
        lbluse.setFont(new Font("Tahoma",Font.BOLD,28));

        username = new JTextField();
        username.setFont(new Font("Tahoma",Font.PLAIN,28));
        //textField.setBounds(192,40,143,20);
        username.setBounds(384,280,300,40);

        lblPassword = new JLabel("Password:");
        lblPassword.setForeground(new Color(255,250,250));
        //lblPassword.setBounds(83,86,111,27);
        lblPassword.setBounds(166,330,200,50);
        lblPassword.setFont(new Font("Tahoma",Font.BOLD,28));

        contentPane = new JPanel();
    		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    		//frmLogin.setContentPane(contentPane);
    		//contentPane.setLayout(null);
        dp = new JDateChooser();

        dp.setDateFormatString("yyyy-MM-dd");
		    dp.setBounds(384, 70, 300, 40);

		    panel_1.add(dp);

    		// create a object of the text class
        Register te = new Register();

        btnSignUp.addActionListener(te);
        dp.getCalendarButton().addActionListener(te);


        panel.add(label);

        panel_1.add(passwordField);
        panel_1.add(lblNewLabel);
        panel_1.add(btnSignUp);
        panel_1.add(fullName);
        panel_1.add(lblPassword);
        panel_1.add(pswdIncorrect);
        panel_1.add(lbDob);
        panel_1.add(tx);
        panel_1.add(lbladd);
        panel_1.add(lblemail);
        panel_1.add(email);
        panel_1.add(lbluse);
        panel_1.add(username);

        // set the size of frame

        frmLogin.setVisible(true);
        //f.show();
    }

    // if the vutton is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("Sign Up")) {
            pswdIncorrect.setText("Sign In");
            dob = ((JTextField)(dp.getDateEditor().getUiComponent())).getText();//Go Backend and Initiate new Frame
            System.out.println(dob);
        }
    }



}
