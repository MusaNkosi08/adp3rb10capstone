package za.ac.cput.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BusinessReportGUI extends JFrame {

    public BusinessReportGUI() {
        setTitle("SnuggleReads • View Report of Business Progress");
        setSize(1200, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel main = new JPanel(new BorderLayout(16, 16));
        main.setBorder(new EmptyBorder(16, 16, 16, 16));
        add(main);

        // Sidebar
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(220, getHeight()));
        sidebar.setBackground(new Color(248, 248, 248));
        sidebar.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));

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
        JButton businessReportsBtn = navButton("Business Reports");
        businessReportsBtn.setBackground(new Color(240, 240, 240));

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
        sidebar.add(Box.createVerticalStrut(6));
        sidebar.add(businessReportsBtn);
        sidebar.add(Box.createVerticalGlue());
        main.add(sidebar, BorderLayout.WEST);

        // Center Panel
        JPanel center = new JPanel(new BorderLayout(16, 16));
        main.add(center, BorderLayout.CENTER);

        // Top header
        JPanel top = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Business Reports");
        title.setFont(new Font("SansSerif", Font.BOLD, 22));

        JLabel subtitle = new JLabel("Comprehensive analytics and insights for your bookstore performance.");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subtitle.setForeground(new Color(100, 100, 100));

        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        titlePanel.setOpaque(false);
        titlePanel.add(title);
        titlePanel.add(subtitle);

        String[] options = {"Last Month", "Last 3 Months", "Last 6 Months", "Last Year"};
        JComboBox<String> timeFilter = new JComboBox<>(options);
        JButton exportBtn = new JButton("Export Report");

        JPanel rightTop = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightTop.setOpaque(false);
        rightTop.add(timeFilter);
        rightTop.add(exportBtn);

        top.add(titlePanel, BorderLayout.WEST);
        top.add(rightTop, BorderLayout.EAST);

        center.add(top, BorderLayout.NORTH);

        // Tabs (Overview, Sales Analytics, Product Performance, Customer Insights)
        JTabbedPane tabs = new JTabbedPane();
        JPanel overviewTab = new JPanel(new BorderLayout(12, 12));

        // Cards with KPIs
        JPanel kpiPanel = new JPanel(new GridLayout(1, 4, 12, 12));
        kpiPanel.add(kpiCard("Total Revenue", "$97,400", "+18.2% vs last period"));
        kpiPanel.add(kpiCard("Total Orders", "1,249", "+12.5% vs last period"));
        kpiPanel.add(kpiCard("Active Customers", "2,131", "+8.1% vs last period"));
        kpiPanel.add(kpiCard("Books Sold", "3,847", "+15.3% vs last period"));
        overviewTab.add(kpiPanel, BorderLayout.NORTH);

        // Graphs (placeholder panels)
        JPanel graphs = new JPanel(new GridLayout(1, 2, 12, 12));

        JPanel revenueGraph = cardPanel("Revenue & Profit Trends");
        revenueGraph.add(new JLabel("📈 Revenue & Profit chart placeholder", JLabel.CENTER), BorderLayout.CENTER);

        JPanel orderGraph = cardPanel("Order Volume");
        orderGraph.add(new JLabel("📊 Order Volume chart placeholder", JLabel.CENTER), BorderLayout.CENTER);

        graphs.add(revenueGraph);
        graphs.add(orderGraph);

        overviewTab.add(graphs, BorderLayout.CENTER);

        tabs.addTab("Overview", overviewTab);
        tabs.addTab("Sales Analytics", new JLabel("Sales Analytics page placeholder", JLabel.CENTER));
        tabs.addTab("Product Performance", new JLabel("Product Performance page placeholder", JLabel.CENTER));
        tabs.addTab("Customer Insights", new JLabel("Customer Insights page placeholder", JLabel.CENTER));

        center.add(tabs, BorderLayout.CENTER);
    }

    // --- Helpers ---
    private static JButton navButton(String text) {
        JButton b = new JButton(text);
        b.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
        b.setAlignmentX(Component.LEFT_ALIGNMENT);
        b.setFocusPainted(false);
        b.setBackground(Color.WHITE);
        b.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(230, 230, 230)),
                new EmptyBorder(8, 12, 8, 12)
        ));
        return b;
    }

    private static JPanel kpiCard(String title, String value, String change) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220)),
                new EmptyBorder(12, 12, 12, 12)
        ));

        JLabel titleLbl = new JLabel(title);
        titleLbl.setFont(new Font("SansSerif", Font.PLAIN, 13));
        JLabel valueLbl = new JLabel(value);
        valueLbl.setFont(new Font("SansSerif", Font.BOLD, 20));
        JLabel changeLbl = new JLabel(change);
        changeLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
        changeLbl.setForeground(new Color(0, 150, 0));

        card.add(titleLbl, BorderLayout.NORTH);
        card.add(valueLbl, BorderLayout.CENTER);
        card.add(changeLbl, BorderLayout.SOUTH);
        return card;
    }

    private static JPanel cardPanel(String title) {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(230, 230, 230)),
                new EmptyBorder(12, 12, 12, 12)
        ));
        JLabel header = new JLabel(title);
        header.setFont(new Font("SansSerif", Font.BOLD, 14));
        p.add(header, BorderLayout.NORTH);
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BusinessReportGUI().setVisible(true));
    }
}

