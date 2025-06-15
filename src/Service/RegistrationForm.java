package Service;

import GUI.BaseForm;
import GUI.UserListWindow;
import Model.User;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationForm extends BaseForm {
    private List<User> users;
    private UserListWindow userListWindow;
    private StringBuilder hexPasswordBuilder;

    private SignInWindow signInWindowInstance;

    public RegistrationForm() {
        super("Model.User Registration");

        users = new ArrayList<>();
        hexPasswordBuilder = new StringBuilder();

        userListWindow = new UserListWindow();
        userListWindow.setVisible(true);

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
                    updateHexValue(e);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    updateHexValueForBackspace();
                }
            }
        });

        passwordVisibilityCheckBox.addActionListener(e -> {
            if (passwordVisibilityCheckBox.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        });

        registerButton.addActionListener(e -> registerUser());

        signInButton.addActionListener(e -> openSignInWindow(users));
    }

    private void updateHexValue(KeyEvent e) {
        char typedChar = e.getKeyChar();
        hexPasswordBuilder.append(String.format("%02X ", (int) typedChar));
        System.out.println("Hex Password: " + hexPasswordBuilder.toString().trim());
    }

    private void updateHexValueForBackspace() {
        hexPasswordBuilder.append("08 ");
        System.out.println("Hex Password (backspace pressed): " + hexPasswordBuilder.toString().trim());
    }

    // Register
    private void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username and password must not be empty!");
            return;
        }

        // Check if username is unique
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                JOptionPane.showMessageDialog(this, "Username already exists!");
                return;
            }
        }

        // Store the user
        users.add(new User(username, password, hexPasswordBuilder.toString().trim()));

        usernameField.setText("");
        passwordField.setText("");
        hexPasswordBuilder.setLength(0);

        userListWindow.updateUserList(users);
    }

    private void openSignInWindow(List<User> users) {

        if (signInWindowInstance == null || !signInWindowInstance.isVisible()) {
            signInWindowInstance = new SignInWindow(users);
            signInWindowInstance.setVisible(true);
        } else {
            signInWindowInstance.toFront();
        }
    }
}
