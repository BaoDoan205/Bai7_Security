package Bai1;

import javax.swing.*;

public class WelcomeForm extends JFrame {
    public WelcomeForm(String username) {
        setTitle("Welcome");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        add(welcomeLabel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
