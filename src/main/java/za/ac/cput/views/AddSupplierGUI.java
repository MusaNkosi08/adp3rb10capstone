package za.ac.cput.views;

import javax.swing.*;
import java.awt.*;

public class AddSupplierGUI extends JPanel {

    public AddSupplierGUI() {
        /*
        setTitle("Add/Edit Supplier");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        */
        setSize(750, 600);


        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(250, 245, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel title = new JLabel("Add/Edit Supplier");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;

        // Supplier Name
        gbc.gridy++;
        panel.add(new JLabel("Supplier Name:"), gbc);
        gbc.gridx = 1;
        JTextField supplierField = new JTextField(15);
        panel.add(supplierField, gbc);

        // Contact Name
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Contact Name:"), gbc);
        gbc.gridx = 1;
        JTextField contactField = new JTextField(15);
        panel.add(contactField, gbc);

        // Phone Number
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Phone Number:"), gbc);
        gbc.gridx = 1;
        JTextField phoneField = new JTextField(17);
        panel.add(phoneField, gbc);

        // Address
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Address:"), gbc);
        gbc.gridx = 1;
        JTextField addressField = new JTextField(17);
        panel.add(addressField, gbc);

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
        JButton saveBtn = new JButton("Save");
        saveBtn.setBackground(Color.DARK_GRAY);
        saveBtn.setForeground(Color.WHITE);
        panel.add(saveBtn, gbc);

        gbc.gridx = 1;
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBackground(new Color(200, 230, 200));
        panel.add(cancelBtn, gbc);

        add(panel);
    }
    /*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AddSupplierGUI().setVisible(true);
        });
    }
    */
}
