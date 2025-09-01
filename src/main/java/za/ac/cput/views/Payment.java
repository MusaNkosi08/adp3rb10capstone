package za.ac.cput.views;

import javax.swing.*;
import java.awt.*;

public class Payment extends JPanel {
    private JRadioButton creditCardBtn, paypalBtn;
    private JTextField cardNumberField, expiryField, cvvField;
    private JLabel totalLabel;
    private JButton payButton;

    public Payment(double totalAmount) {
       /*
        setTitle("Add/Edit Supplier");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        */

        setSize(400, 300);


        // Payment methods
        creditCardBtn = new JRadioButton("Credit Card", true);
        paypalBtn = new JRadioButton("PayPal");

        ButtonGroup group = new ButtonGroup();
        group.add(creditCardBtn);
        group.add(paypalBtn);

        JPanel paymentMethodsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        paymentMethodsPanel.add(creditCardBtn);
        paymentMethodsPanel.add(paypalBtn);

        // Card details fields
        cardNumberField = new JTextField(15);
        expiryField = new JTextField(5);
        cvvField = new JTextField(3);

        // Labels
        JLabel cardLabel = new JLabel("Card Number:");
        JLabel expiryLabel = new JLabel("Expiry Date:");
        JLabel cvvLabel = new JLabel("CVV:");

        // Total
        totalLabel = new JLabel("TOTAL: R" + totalAmount);

        // Pay button
        payButton = new JButton("Pay Now");
        payButton.addActionListener(e -> processPayment(totalAmount));

        // Radio button action listeners
        creditCardBtn.addActionListener(e -> toggleCardFields(true));
        paypalBtn.addActionListener(e -> toggleCardFields(false));

        // Layout
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 0 - Payment methods
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        centerPanel.add(paymentMethodsPanel, gbc);

        // Row 1 - Card number
        gbc.gridy++;
        gbc.gridwidth = 1;
        centerPanel.add(cardLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(cardNumberField, gbc);

        // Row 2 - Expiry
        gbc.gridx = 0;
        gbc.gridy++;
        centerPanel.add(expiryLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(expiryField, gbc);

        // Row 3 - CVV
        gbc.gridx = 0;
        gbc.gridy++;
        centerPanel.add(cvvLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(cvvField, gbc);

        // Row 4 - Total and Pay button
        gbc.gridx = 0;
        gbc.gridy++;
        centerPanel.add(totalLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(payButton, gbc);

        add(centerPanel, BorderLayout.CENTER);

        toggleCardFields(true); // initially show card fields
        setVisible(true);
    }

    private void toggleCardFields(boolean show) {
        cardNumberField.setEnabled(show);
        expiryField.setEnabled(show);
        cvvField.setEnabled(show);
    }

    private void processPayment(double totalAmount) {
        if (creditCardBtn.isSelected()) {
            if (cardNumberField.getText().isEmpty() || expiryField.getText().isEmpty() || cvvField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all card details.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(this,
                "Payment of R" + totalAmount + " successful!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);

    }

}
