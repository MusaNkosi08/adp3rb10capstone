package za.ac.cput.views;

import javax.swing.*;
import java.awt.*;

public class AddEmployeeGUI extends JPanel {
    public JButton saveBtn;
    public JButton cancelBtn;

    public AddEmployeeGUI() {
        /*
        setTitle("Add Employee");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        */
       // setSize(500, 500);


        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(250, 245, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel title = new JLabel("Add Employee");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;

        // Employee Name
        gbc.gridy++;
        panel.add(new JLabel("Employee Name:"), gbc);
        gbc.gridx = 1;
        JTextField nameField = new JTextField(17);
        panel.add(nameField, gbc);

        // Email
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        JTextField emailField = new JTextField(17);
        panel.add(emailField, gbc);

        // Phone Number
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Phone Number:"), gbc);
        gbc.gridx = 1;
        JTextField phoneField = new JTextField(17);
        panel.add(phoneField, gbc);

        // Role
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Role:"), gbc);
        gbc.gridx = 1;
        String[] roles = {"Admin", "Employee"};
        JComboBox<String> roleBox = new JComboBox<>(roles);
        panel.add(roleBox, gbc);

        // Status
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Status:"), gbc);
        gbc.gridx = 1;
        String[] statuses = {"Active", "Inactive"};
        JComboBox<String> statusBox = new JComboBox<>(statuses);
        panel.add(statusBox, gbc);

        // Buttons
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 0.5;   // half-half
        gbc.fill = GridBagConstraints.BOTH;

        saveBtn = new JButton("Save");
        saveBtn.setBackground(Color.DARK_GRAY);
        saveBtn.setForeground(Color.WHITE);
        panel.add(saveBtn, gbc);

        gbc.gridx = 1;

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBackground(new Color(200, 230, 200));
        panel.add(cancelBtn, gbc);

        add(panel);
    }

    /*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AddEmployeeGUI().setVisible(true);
        });
    }
    */
}
