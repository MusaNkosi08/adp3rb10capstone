package za.ac.cput.views;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author aimee
 */
public class LoginGUI extends JFrame implements ActionListener{

    private JPanel pnlGreeting = new JPanel();
    private JPanel pnl = new JPanel();
    private JPanel pnlBtn = new JPanel();

    private JLabel lblGreeting = new JLabel("WELCOME BACK TO SNUGGLEREADS!");
    private JLabel lblName = new JLabel("Name: ");
    private JLabel lblSname = new JLabel("Surname: ");
    private JLabel lblEmail = new JLabel("Email: ");
    private JLabel lblPsword = new JLabel("Password: ");

    private JTextField txtName = new JTextField(10);
    private JTextField txtSname = new JTextField(10);
    private JTextField txtEmail = new JTextField(10);
    private JTextField txtPsword = new JTextField(10);

    private JButton btnLogin = new JButton("Login");

    public LoginGUI(){
        super("Login");

        // Panel layout
        pnlGreeting.setLayout(new BorderLayout());

        pnl.setLayout(new GridLayout(4, 2, 2, 5));
        pnlBtn.setLayout(new BorderLayout());
        pnlGreeting.setBackground(Color.cyan);
        pnl.setBackground(Color.cyan);
        pnlBtn.setBackground(Color.cyan);

        // Set margins for labels so that they are close to txtfields
        lblName.setBorder(new EmptyBorder(0, 0, 0, 5));
        lblSname.setBorder(new EmptyBorder(0, 0, 0, 5));
        lblEmail.setBorder(new EmptyBorder(0, 0, 0, 5));
        lblPsword.setBorder(new EmptyBorder(0, 0, 0, 5));

        //Padding to the pnlGreeting to create space
        pnlGreeting.setBorder(new EmptyBorder(20, 0, 30, 0));


        lblGreeting.setSize(300,300);
        btnLogin.setBackground(Color.black);
        btnLogin.setOpaque(true);
        btnLogin.setBorderPainted(false);//removes default border
        btnLogin.setForeground(Color.white);

        pnlGreeting.add(lblGreeting, BorderLayout.CENTER);

        pnl.add(lblName);
        pnl.add(txtName);
        pnl.add(lblSname);
        pnl.add(txtSname);
        pnl.add(lblEmail);
        pnl.add(txtEmail);
        pnl.add(lblPsword);
        pnl.add(txtPsword);

        pnlBtn.add(btnLogin);

        // Padding to the form panel to create more space
        pnl.setBorder(new EmptyBorder(0, 20, 0, 20));

        // Panels on frame layout
        setLayout(new BorderLayout());
        add(pnlGreeting, BorderLayout.NORTH);
        add(pnl, BorderLayout.CENTER);
        add(pnlBtn, BorderLayout.SOUTH);

        // Add ActionListeners
        btnLogin.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String successMsg = "Login Successful!";
            JOptionPane.showMessageDialog(null, successMsg);
        }
    }


}