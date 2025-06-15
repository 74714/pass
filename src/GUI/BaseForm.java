package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class BaseForm extends JFrame {
    protected JTextField usernameField;
    protected JPasswordField passwordField;
    protected JCheckBox passwordVisibilityCheckBox;
    protected JButton registerButton;
    protected JButton signInButton;

    public BaseForm(String title) {
        setTitle(title);
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setBackground(Color.BLACK);

        // Username field
        usernameField = new JTextField(20);
        usernameField.setBounds(150, 100, 200, 40);
        usernameField.setForeground(new Color(0, 255, 0));
        usernameField.setBackground(Color.black);
        usernameField.setFont(new Font("Consolas", Font.PLAIN, 18));
        usernameField.setCaretColor(new Color(0, 255, 0));
        usernameField.setBorder(new LineBorder(new Color(0, 255, 0), 2));

        // Password field
        passwordField = new JPasswordField(20);
        passwordField.setBounds(150, 160, 200, 40);
        passwordField.setForeground(new Color(0, 255, 0));
        passwordField.setBackground(Color.black);
        passwordField.setFont(new Font("Consolas", Font.PLAIN, 18));
        passwordField.setCaretColor(new Color(0, 255, 0));
        passwordField.setBorder(new LineBorder(new Color(0, 255, 0), 2));

        // checkbox
        passwordVisibilityCheckBox = new JCheckBox("Show Password");
        passwordVisibilityCheckBox.setBounds(150, 210, 200, 30);
        passwordVisibilityCheckBox.setForeground(new Color(0, 255, 0));
        passwordVisibilityCheckBox.setBackground(Color.BLACK);


        // Register button
        registerButton = new JButton("Register");
        registerButton.setBounds(150, 260, 100, 50);
        registerButton.setForeground(Color.BLACK);
        registerButton.setBackground(new Color(0, 255, 0));
        registerButton.setBorder(new LineBorder(new Color(0, 255, 0), 2));

        // Sign-In button
        signInButton = new JButton("Sign Up");
        signInButton.setBounds(270, 260, 100, 50);
        signInButton.setForeground(Color.BLACK);
        signInButton.setBackground(new Color(0, 255, 0));
        signInButton.setBorder(new LineBorder(new Color(0, 255, 0), 2));

        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(passwordVisibilityCheckBox);
        add(registerButton);
        add(signInButton);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 100, 100, 40);
        usernameLabel.setForeground(new Color(0, 255, 0));
        usernameLabel.setFont(new Font("Consolas", Font.PLAIN, 18));

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 160, 100, 40);
        passwordLabel.setForeground(new Color(0, 255, 0));
        passwordLabel.setFont(new Font("Consolas", Font.PLAIN, 18));

        add(usernameLabel);
        add(passwordLabel);
        setComponentGlowEffect();
    }

    //flicker
    private void setComponentGlowEffect() {
        Timer glowTimer = new Timer(24, e -> {

            Color glowColor = new Color(
                    (int) (Math.random() * 256), // R
                    (int) (Math.random() * 256), // G
                    (int) (Math.random() * 256)  // B
            );

            usernameField.setForeground(glowColor);
            passwordField.setForeground(glowColor);
        });

        glowTimer.start();
    }

}
