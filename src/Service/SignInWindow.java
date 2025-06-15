package Service;

import GUI.BaseForm;
import Model.User;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class SignInWindow extends BaseForm {
    private List<User> users;
    private StringBuilder hexPasswordChecker = new StringBuilder();

    private static SignInWindow signInWindowInstance;

    public SignInWindow(List<User> users) {
        super("Sign In");
        this.users = users;

        removeSignInButton();
        remove(registerButton);
        removePasswordVisibilityCheckbox();

        JButton okButton = new JButton("OK");
        add(okButton, BorderLayout.SOUTH);

        okButton.setBounds(150, 260, 100, 50);
        okButton.setForeground(Color.BLACK);
        okButton.setBackground(new Color(0, 255, 0));
        okButton.setFont(new Font("Consolas", Font.BOLD, 16));
        okButton.setFocusPainted(false);
        okButton.setBorder(new LineBorder(new Color(0, 255, 0), 2));

        okButton.addActionListener(e -> signInUser());


        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                checkHexValue(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Capture backspace or any other key press
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    checkHexValueForBackspace();
                }
            }
        });
    }

    private void removeSignInButton() {
        if (signInButton != null) {
            remove(signInButton);
        }
    }

    private void removePasswordVisibilityCheckbox() {
        if (passwordVisibilityCheckBox != null) {
            remove(passwordVisibilityCheckBox);
        }
    }

    //sign-In
    private void signInUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username and password must not be empty!");
            return;
        }


        String hexPassword = PasswordConverter.convertToHex(password);
        System.out.println("typed hex: " + hexPassword);

        // Validation
        boolean usernameExists = false;

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                usernameExists = true;

                System.out.println("Stored Hex: " + user.getHexPassword());

                if (user.getHexPassword().equals(hexPasswordChecker.toString().trim())) {
                    JOptionPane.showMessageDialog(this, "Sign In Successful!");
                    dispose();
                    System.out.println("THE END :3");
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Password hex mismatch!");
                    break;
                }
            }
        }

        if (!usernameExists) { JOptionPane.showMessageDialog(this, "Username doesn't exist!");}

        usernameField.setText("");
        passwordField.setText("");
        hexPasswordChecker.setLength(0);
    }

    private void checkHexValue(KeyEvent e) {
        char typedChar = e.getKeyChar();
        hexPasswordChecker.append(String.format("%02X ", (int) typedChar));
        System.out.println("Hex Password Check: " + hexPasswordChecker.toString().trim());
    }

    private void checkHexValueForBackspace() {
        System.out.println("Hex Password Check (backspace pressed): " + hexPasswordChecker.toString().trim());
    }

}




