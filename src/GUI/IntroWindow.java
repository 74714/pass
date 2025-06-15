package GUI;

import Service.RegistrationForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IntroWindow extends JFrame {
    private JButton startButton;

    // welcome message
    public IntroWindow() {
        setTitle("Welcome to the Program");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());


        JLabel introLabel = new JLabel("<html><center> Welcome <br>" +
                " This tool enables you to create passwords by using any sequence of characters <br>" +
                "including control keys </center></html>");
        introLabel.setForeground(new Color(0, 255, 0));
        introLabel.setFont(new Font("Consolas", Font.PLAIN, 16));

        startButton = new JButton("Start");
        startButton.setFont(new Font("Consolas", Font.BOLD, 16));
        startButton.setBackground(new Color(0, 255, 0));
        startButton.setForeground(Color.BLACK);
        startButton.setFocusPainted(false);
        startButton.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 0), 2));

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.out.print("To register user do not press 'enter' - it will be considered as a part of a Password");
                new RegistrationForm().setVisible(true);
            }
        });

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.BLACK);

        contentPanel.add(introLabel, BorderLayout.CENTER);
        contentPanel.add(startButton, BorderLayout.SOUTH);

        add(contentPanel, BorderLayout.CENTER);
    }
}
