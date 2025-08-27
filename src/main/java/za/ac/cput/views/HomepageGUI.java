package za.ac.cput.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


    public class HomepageGUI extends JFrame implements ActionListener
    {
        private JPanel pnl = new JPanel();
        private JPanel pnlLogo = new JPanel() {
            private BufferedImage image;

            {
                try {
                    // Load from classpath - this is the correct way
                    image = ImageIO.read(getClass().getResource("/Logo.jpeg"));
                } catch (IOException ex) {
                    Logger.getLogger(HomepageGUI.class.getName()).log(Level.SEVERE, null, ex);
                    System.err.println("Could not load background image!");
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null) {
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        private JButton  btnSignup = new JButton("Signup");
        private JButton  btnLogin = new JButton("Login");


        public HomepageGUI(){
            super("SnuggleReads");

            //Panel layout
            pnl.setLayout(new GridLayout(1,2,1,1));
            pnlLogo.setLayout(new BorderLayout());

            //Customising buttons
            btnSignup.setBackground(Color.black);
            btnSignup.setOpaque(true);
            btnSignup.setBorderPainted(false);
            btnSignup.setForeground(Color.white);//removes the default border

            btnLogin.setBackground(Color.black);
            btnLogin.setOpaque(true);
            btnLogin.setBorderPainted(false);
            btnLogin.setForeground(Color.white);


            pnl.add( btnSignup);
            pnl.add(btnLogin);

            //panels on frame layout
            setLayout(new BorderLayout());
            add(pnlLogo, BorderLayout.CENTER);
            add(pnl, BorderLayout.SOUTH);

            //addActionListeners
            btnSignup.addActionListener(this);
            btnLogin.addActionListener(this);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btnSignup) {
                SignupGUI sg = new SignupGUI();
                sg.setVisible(true);
                sg.setSize(600,600);
                sg.isResizable();
                sg.setDefaultCloseOperation(EXIT_ON_CLOSE);


            }

            if (e.getSource() == btnLogin) {
                LoginGUI lg = new LoginGUI();
                lg.setVisible(true);
                lg.setSize(600,600);
                lg.isResizable();
                lg.setDefaultCloseOperation(EXIT_ON_CLOSE);

            }

        }




    }
