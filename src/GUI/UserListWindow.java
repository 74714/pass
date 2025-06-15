package GUI;

import Model.User;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UserListWindow extends JFrame {
    private JPanel userPanel;

    public UserListWindow() {

        setTitle("User List");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);

        userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
        userPanel.setBackground(Color.BLACK);

        add(new JScrollPane(userPanel));
    }

    //update UI
    public void updateUserList(List<User> users) {
        userPanel.removeAll();

        if (users == null || users.isEmpty()) {
            JLabel noUsersLabel = new JLabel("No users available.");
            noUsersLabel.setForeground(Color.GREEN);
            noUsersLabel.setFont(new Font("Consolas", Font.PLAIN, 16));
            userPanel.add(noUsersLabel);
        } else {
            for (User user : users) {

                String hexValue = user.getHexPassword();

                String highlightedHex = hexValue.replaceAll(

                        "\\b(08|09|0D|1B|20|7F|0A)\\b",
                        "<span style='color: red;'>$1</span>");

                String labelText = String.format(
                        "Username: %s | Password: %s | Hex: %s",
                        user.getUsername(),
                        user.getPassword(),
                        highlightedHex
                );

                JLabel userLabel = new JLabel("<html>" + labelText + "</html>");
                userLabel.setFont(new Font("Consolas", Font.PLAIN, 16));
                userLabel.setForeground(Color.GREEN);
                userPanel.add(userLabel);
            }

        }

        userPanel.revalidate();
        userPanel.repaint();
    }
}
