package za.ac.cput.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CreateSupplyOrderGUI extends JPanel {

    public CreateSupplyOrderGUI() {
        /*
        setTitle("Add/Edit Supplier");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        */
        setSize(1080, 680);


        JPanel main = new JPanel(new BorderLayout(16, 16));
        main.setBorder(new EmptyBorder(16, 16, 16, 16));
        add(main);

        // Sidebar
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(220, getHeight()));
        sidebar.setBackground(new Color(248, 248, 248));
        sidebar.setBorder(BorderFactory.createLineBorder(new Color(235, 235, 235)));

        JLabel brand = new JLabel("📚  SnuggleReads");
        brand.setFont(new Font("SansSerif", Font.BOLD, 18));
        brand.setBorder(new EmptyBorder(18, 16, 4, 16));

        JLabel slogan = new JLabel("<html><i>“Where every book feels like a warm hug.”</i></html>");
        slogan.setFont(new Font("SansSerif", Font.PLAIN, 12));
        slogan.setForeground(new Color(110, 110, 110));
        slogan.setBorder(new EmptyBorder(0, 16, 18, 16));

        JButton dashboardBtn = navButton("Dashboard");
        JButton createOrderBtn = navButton("Create Order");
        JButton manageOrdersBtn = navButton("Manage Orders");
        JButton bookCatalogBtn = navButton("Book Catalog");
        JButton supplyOrdersBtn = navButton("Supply Orders");
        supplyOrdersBtn.setBackground(new Color(240, 240, 240));

        sidebar.add(Box.createVerticalStrut(4));
        sidebar.add(brand);
        sidebar.add(slogan);
        sidebar.add(dashboardBtn);
        sidebar.add(Box.createVerticalStrut(6));
        sidebar.add(createOrderBtn);
        sidebar.add(Box.createVerticalStrut(6));
        sidebar.add(manageOrdersBtn);
        sidebar.add(Box.createVerticalStrut(6));
        sidebar.add(bookCatalogBtn);
        sidebar.add(Box.createVerticalStrut(6));
        sidebar.add(supplyOrdersBtn);
        sidebar.add(Box.createVerticalGlue());
        main.add(sidebar, BorderLayout.WEST);

        // Center
        JPanel center = new JPanel(new BorderLayout(16, 16));
        main.add(center, BorderLayout.CENTER);

        // Top bar
        JPanel top = new JPanel(new BorderLayout());
        JButton back = new JButton("← Back to Supply Orders");
        styleButton(back);
        JLabel title = new JLabel("Create Supply Order");
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        title.setBorder(new EmptyBorder(0, 8, 0, 0));
        top.add(back, BorderLayout.WEST);
        top.add(title, BorderLayout.CENTER);
        center.add(top, BorderLayout.NORTH);

        // Mid split: Order Details | Quick Add
        JPanel mid = new JPanel(new GridLayout(1, 2, 16, 16));

        // Left: Order Details card
        JPanel orderDetails = cardPanel("Order Details");
        orderDetails.setLayout(new BoxLayout(orderDetails, BoxLayout.Y_AXIS));

        JLabel supLbl = fieldLabel("Supplier");
        JComboBox<String> supplier = new JComboBox<>(new String[]{
                "Select supplier", "Pearson SA", "Penguin Random House", "Macmillan", "Pan Macmillan"
        });
        supplier.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));

        JLabel dateLbl = fieldLabel("Expected Delivery Date");
        JTextField date = new JTextField("08/22/2025");
        date.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));

        JLabel notesLbl = fieldLabel("Order Notes");
        JTextArea notes = new JTextArea("Any special instructions...");
        notes.setLineWrap(true);
        notes.setWrapStyleWord(true);
        JScrollPane notesScroll = new JScrollPane(notes);
        notesScroll.setPreferredSize(new Dimension(200, 100));

        orderDetails.add(supLbl);      orderDetails.add(supplier);
        orderDetails.add(Box.createVerticalStrut(10));
        orderDetails.add(dateLbl);     orderDetails.add(date);
        orderDetails.add(Box.createVerticalStrut(10));
        orderDetails.add(notesLbl);    orderDetails.add(notesScroll);

        // Right: Quick Add
        JPanel quickAdd = cardPanel("Quick Add from Low Stock");
        quickAdd.setLayout(new BoxLayout(quickAdd, BoxLayout.Y_AXIS));

        String[][] low = {
                {"Pride and Prejudice", "12", "Add 25"},
                {"The Catcher in the Rye", "8", "Add 30"},
                {"Brave New World", "5", "Add 20"},
                {"Lord of the Flies", "3", "Add 35"}
        };
        for (String[] row : low) {
            quickAdd.add(lowStockRow(row[0], row[1], row[2]));
            quickAdd.add(Box.createVerticalStrut(10));
        }

        mid.add(orderDetails);
        mid.add(quickAdd);
        center.add(mid, BorderLayout.CENTER);

        // Bottom: Order Items
        JPanel itemsCard = cardPanel("Order Items");
        itemsCard.setLayout(new BorderLayout(10, 10));

        JPanel addRow = new JPanel(new GridLayout(1, 5, 8, 8));
        JTextField titleField = new JTextField();
        titleField.setToolTipText("Book Title");
        titleField.putClientProperty("JComponent.sizeVariant", "regular");
        titleField.setBorder(BorderFactory.createTitledBorder("Book Title"));

        JTextField isbnField = new JTextField();
        isbnField.setBorder(BorderFactory.createTitledBorder("ISBN"));

        JSpinner qtyField = new JSpinner(new SpinnerNumberModel(0, 0, 10000, 1));
        JPanel qtyWrap = titledWrap(qtyField, "Quantity");

        JSpinner costField = new JSpinner(new SpinnerNumberModel(0.00, 0.00, 100000.00, 0.50));
        JPanel costWrap = titledWrap(costField, "Unit Cost");

        JButton addItem = new JButton("+ Add Item");
        addItem.setPreferredSize(new Dimension(120, 36));
        addItem.setFocusPainted(false);

        addRow.add(titleField);
        addRow.add(isbnField);
        addRow.add(qtyWrap);
        addRow.add(costWrap);
        addRow.add(addItem);

        JTextArea tablePlaceholder = new JTextArea("No items added yet. Add books to create your supply order.");
        tablePlaceholder.setEditable(false);
        tablePlaceholder.setForeground(new Color(120, 120, 120));
        tablePlaceholder.setBackground(Color.WHITE);
        tablePlaceholder.setBorder(BorderFactory.createEmptyBorder(18, 12, 18, 12));

        itemsCard.add(addRow, BorderLayout.NORTH);
        itemsCard.add(new JScrollPane(tablePlaceholder), BorderLayout.CENTER);

        center.add(itemsCard, BorderLayout.SOUTH);
    }

    // --- Helpers ---
    private static JButton navButton(String text) {
        JButton b = new JButton(text);
        b.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
        b.setAlignmentX(Component.LEFT_ALIGNMENT);
        styleButton(b);
        return b;
    }

    private static void styleButton(AbstractButton b) {
        b.setFocusPainted(false);
        b.setContentAreaFilled(true);
        b.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(230, 230, 230)),
                new EmptyBorder(8, 12, 8, 12)
        ));
        b.setBackground(Color.WHITE);
    }

    private static JPanel cardPanel(String title) {
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(232, 232, 232)),
                new EmptyBorder(14, 14, 14, 14)
        ));
        p.add(new JLabel()); // keeps box layout spacing clean if used
        p.setLayout(new BorderLayout());
        JLabel t = new JLabel("  " + title);
        t.setFont(new Font("SansSerif", Font.BOLD, 14));
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);
        header.add(t, BorderLayout.WEST);

        JPanel wrap = new JPanel();
        wrap.setBackground(Color.WHITE);
        wrap.setLayout(new BoxLayout(wrap, BoxLayout.Y_AXIS));

        JPanel outer = new JPanel(new BorderLayout(8, 8));
        outer.setBackground(Color.WHITE);
        outer.add(header, BorderLayout.NORTH);
        outer.add(wrap, BorderLayout.CENTER);
        outer.setBorder(new EmptyBorder(2, 2, 2, 2));

        // Return the inner content panel but keep title visible
        JPanel container = new JPanel(new BorderLayout());
        container.setBackground(Color.WHITE);
        container.setBorder(BorderFactory.createEmptyBorder());
        container.add(outer, BorderLayout.CENTER);
        return container;
    }

    private static JLabel fieldLabel(String text) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("SansSerif", Font.PLAIN, 13));
        l.setBorder(new EmptyBorder(8, 0, 4, 0));
        return l;
    }

    private static JPanel titledWrap(JComponent inner, String title) {
        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(BorderFactory.createTitledBorder(title));
        p.add(inner, BorderLayout.CENTER);
        return p;
    }

    private static JPanel lowStockRow(String title, String stock, String btnText) {
        JPanel row = new JPanel(new BorderLayout(8, 8));
        row.setBackground(Color.WHITE);
        row.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(236, 236, 236)),
                new EmptyBorder(10, 12, 10, 12)
        ));

        JLabel left = new JLabel("⚠  " + title + "   •  Stock: " + stock);
        left.setFont(new Font("SansSerif", Font.PLAIN, 13));
        left.setForeground(new Color(70, 70, 70));

        JButton add = new JButton(btnText);
        styleButton(add);

        row.add(left, BorderLayout.CENTER);
        row.add(add, BorderLayout.EAST);
        return row;
    }
    /*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CreateSupplyOrderGUI().setVisible(true));
    }
    */
}
