import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Login extends JFrame implements ActionListener {
    // JTextField
    static JTextField textField;
    // JFrame
    static JFrame frmLogin;
    static JPasswordField passwordField;
    // JButton
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
    Login()
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
        lblNewLabel = new JLabel("Username:");
        lblNewLabel.setForeground(new Color(255,250,250));
        //lblNewLabel.setBounds(83,34,111,27);
        lblNewLabel.setBounds(166,68,200,50);
        lblNewLabel.setFont(new Font("Tahoma",Font.BOLD,28));

        passwordField = new JPasswordField();
        //passwordField.setBounds(192,92,143,20);
        passwordField.setBounds(384,172,300,40);
        passwordField.setFont(new Font("Tahoma",Font.PLAIN,28));

        lblPassword = new JLabel("Password:");
        lblPassword.setForeground(new Color(255,250,250));
        //lblPassword.setBounds(83,86,111,27);
        lblPassword.setBounds(166,172,200,50);
        lblPassword.setFont(new Font("Tahoma",Font.BOLD,28));

        pswdIncorrect = new JLabel("");
        //pswdIncorrect.setBounds(141,133,175,14);
        pswdIncorrect.setBounds(282,266,200,50);
        pswdIncorrect.setForeground(new Color(255,0,0));
        pswdIncorrect.setFont(new Font("Tahoma",Font.BOLD,28));


        label =  new JLabel("LOGIN",SwingConstants.LEFT);
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

        textField = new JTextField();
        textField.setFont(new Font("Tahoma",Font.PLAIN,28));
        //textField.setBounds(192,40,143,20);
        textField.setBounds(384,68,300,40);

        // create a object of the text class
        Login te = new Login();

        // addActionListener to button
        btnSignIn.addActionListener(te);
        btnSignUp.addActionListener(te);


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

    // if the vutton is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("Sign In")) {
            pswdIncorrect.setText("Sign In");
            /*
            if (validateUser.validate(textField.getText(), passwordField.getText())
            {
              // Go to Home Frame
            }
            */
        }
        if (s.equals("Sign Up"))
        {
            frmLogin.setVisible(false);
            Register.main();
        }
    }

}
