package cm;

import javax.swing.*;

/**
 * Created by kaval on 02.07.2017.
 */
public class Game {
    public static void main(String[] args) {
        Panel panel = new Panel();
        JFrame wFrame = new JFrame("Shooter");
        wFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        wFrame.setContentPane(panel);
        wFrame.pack();
        wFrame.setLocationRelativeTo(null);
        wFrame.setVisible(true);
        panel.start();
    }
}
