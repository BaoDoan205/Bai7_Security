package Bai1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginForm() {
        setTitle("Login");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel jPanel_North = new JPanel();
        jPanel_North.setLayout(new GridLayout(2, 2, 20, 20));
        
        JPanel jPanel_South = new JPanel();
        jPanel_South.setLayout(new GridLayout(1, 3, 20, 20));

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        JLabel jLabel_user = new JLabel("UserName: ");
        JLabel jLabel_pass = new JLabel("PassWord: ");
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        jPanel_North.add(jLabel_user);
        jPanel_North.add(usernameField);
        jPanel_North.add(jLabel_pass);
        jPanel_North.add(passwordField);

        jPanel_South.add(jLabel1);
        jPanel_South.add(loginButton);
        jPanel_South.add(jLabel2);
        add(loginButton);
        
        this.add(jPanel_North, BorderLayout.CENTER);
        this.add(jPanel_South, BorderLayout.SOUTH);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                try {
                    if (AuthController.loginUser(username, password)) {
                        JOptionPane.showMessageDialog(LoginForm.this, "Login successful! Welcome " + username);
                        new WelcomeForm(username);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(LoginForm.this, "Invalid username or password");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(LoginForm.this, "Error: " + ex.getMessage());
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
