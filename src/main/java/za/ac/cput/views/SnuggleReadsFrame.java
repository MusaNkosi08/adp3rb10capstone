package za.ac.cput.views;

import org.springframework.boot.SpringApplication;
import za.ac.cput.Main;
import za.ac.cput.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SnuggleReadsFrame extends JFrame implements ActionListener {
//Data
User activeUser;
    //Pages
    JPanel pages;
    static CardLayout cl = new CardLayout();
    private AddEmployeeGUI addEmp;
    private AddSupplierGUI addSup;
    private BookCatalogueGUI catalogue;
    private BusinessReportGUI report;
    private Cart cart;
    private CreateSupplyOrderGUI createSup;
    private LoginGUI login;
    private HomepageGUI home;
    private Payment payment;
    private SignupGUI signup;
   // private SupplyItemGUI supplyItem;

    //Constructor
    public SnuggleReadsFrame(){
        createPages();
        createActionListeners();
        showPage("home");
    }

    public static void main(String[] args) {
        SnuggleReadsFrame frame = new SnuggleReadsFrame();
    }

    public void createPages() {
        pages = new JPanel();

        pages.setLayout(cl);
        addEmp = new AddEmployeeGUI();
        addSup = new AddSupplierGUI();
        catalogue = new BookCatalogueGUI();
        report = new BusinessReportGUI();
        cart = new Cart();
        createSup = new CreateSupplyOrderGUI();
        login = new LoginGUI();
        home = new HomepageGUI();

        signup = new SignupGUI();
     //   supplyItem = new SupplyItemGUI();

        this.add(pages);
        pages.add(addEmp);
        pages.add(addSup);
        pages.add(catalogue);
        pages.add(report);
        pages.add(cart);
        pages.add(createSup);
        pages.add(login);
        pages.add(home);
        pages.add(signup);
      //  pages.add(supplyItem);

        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void showPage(String pageName) {
        cl.show(pages, pageName);
    }

    public void setActiveUser(User active) {

        activeUser = active;

    }

    public void createActionListeners(){
        home.btnLogin.addActionListener(this);
        home.btnSignup.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
