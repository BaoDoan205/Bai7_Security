package Bai1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegisterForm() {
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
        registerButton = new JButton("Login");
        JLabel jLabel_user = new JLabel("UserName: ");
        JLabel jLabel_pass = new JLabel("PassWord: ");
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        jPanel_North.add(jLabel_user);
        jPanel_North.add(usernameField);
        jPanel_North.add(jLabel_pass);
        jPanel_North.add(passwordField);

        jPanel_South.add(jLabel1);
        jPanel_South.add(registerButton);
        jPanel_South.add(jLabel2);
        add(registerButton);
        
        this.add(jPanel_North, BorderLayout.CENTER);
        this.add(jPanel_South, BorderLayout.SOUTH);


        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                try {
                    AuthController.registerUser(username, password);
                    JOptionPane.showMessageDialog(RegisterForm.this, "Registration successful!");
                    new LoginForm();
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(RegisterForm.this, "Error: " + ex.getMessage());
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
