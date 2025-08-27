package za.ac.cput.views;

import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import za.ac.cput.views.HomepageGUI;

public class runHomePage {
    public static void main(String[] args) {

        // Create and show the GUI on the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(() -> {

            HomepageGUI hpg = new HomepageGUI();
            hpg.setVisible(true);
            hpg.setExtendedState(JFrame.MAXIMIZED_BOTH);
            //hpg.setSize(500,500);
            hpg.isResizable();
            hpg.setDefaultCloseOperation(EXIT_ON_CLOSE);

        });

    }
}
