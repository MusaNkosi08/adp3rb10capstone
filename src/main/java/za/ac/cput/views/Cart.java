package za.ac.cput.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Cart extends JFrame {
    private JTable cartTable;
    private JLabel subtotalLabel, totalLabel;
    private JButton payNowButton, removeButton, addButton;
    private DefaultTableModel model;

    public Cart() {
        setTitle("Cart");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Table columns
        String[] columns = {"Item", "Quantity", "Price"};
        model = new DefaultTableModel(columns, 0);
        cartTable = new JTable(model);
        cartTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // select one row at a time
        JScrollPane scrollPane = new JScrollPane(cartTable);

        // Labels
        subtotalLabel = new JLabel("Sub Total: R0.00");
        totalLabel = new JLabel("Total: R0.00");

        // Buttons
        addButton = new JButton("Add Item");
        removeButton = new JButton("Remove Selected");
        payNowButton = new JButton("Pay Now");

        // Add button action
        addButton.addActionListener(e -> {
            JTextField itemField = new JTextField();
            JTextField quantityField = new JTextField();
            JTextField priceField = new JTextField();

            Object[] message = {
                    "Item Name:", itemField,
                    "Quantity:", quantityField,
                    "Price:", priceField
            };

            int option = JOptionPane.showConfirmDialog(this, message, "Add New Item", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                try {
                    String item = itemField.getText();
                    int quantity = Integer.parseInt(quantityField.getText());
                    double price = Double.parseDouble(priceField.getText());
                    model.addRow(new Object[]{item, quantity, price});
                    updateTotals();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid quantity or price.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Remove button action
        removeButton.addActionListener(e -> {
            int selectedRow = cartTable.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
                updateTotals();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to remove.", "No selection", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Pay Now button action
        payNowButton.addActionListener(e -> {
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Cart is empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double total = calculateTotal();
            dispose();
            new Payment(total);
        });

        // Bottom panel layout
        JPanel bottomPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        bottomPanel.add(subtotalLabel);
        bottomPanel.add(totalLabel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(payNowButton);
        bottomPanel.add(buttonPanel);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void updateTotals() {
        double total = calculateTotal();
        subtotalLabel.setText("Sub Total: R" + String.format("%.2f", total));
        totalLabel.setText("Total: R" + String.format("%.2f", total));
    }

    private double calculateTotal() {
        double total = 0.0;
        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                double price = Double.parseDouble(model.getValueAt(i, 2).toString());
                int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());
                total += price * quantity;
            } catch (NumberFormatException ignored) {}
        }
        return total;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Cart::new);
    }
}
