import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends JFrame implements ActionListener {

    JTextField txtUsername;
    JPasswordField txtPassword;
    JButton btnLogin;

    public LoginScreen() {

        setTitle("Login");
        setSize(350, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Username Label
        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(50, 50, 80, 25);
        add(lblUser);

        // Username Field
        txtUsername = new JTextField();
        txtUsername.setBounds(140, 50, 150, 25);
        add(txtUsername);

        // Password Label
        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(50, 90, 80, 25);
        add(lblPass);

        // Password Field
        txtPassword = new JPasswordField();
        txtPassword.setBounds(140, 90, 150, 25);
        add(txtPassword);

        // Login Button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(120, 140, 100, 30);
        btnLogin.addActionListener(this);
        add(btnLogin);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        // Simple validation
        if (username.equals("admin") && password.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Login Successful ✅");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Username or Password ❌");
        }
    }

    public static void main(String[] args) {
        new LoginScreen();
    }
}