package automatedrawer;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author reves
 */
public class AutomateDrawer {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame fm = new JFrame("Automate");
        Drawer dr = new Drawer();
        dr.addState(100, 150, 50 , "q1");
        dr.addState(200, 250, 50 , "q2");
        dr.addState(300, 50, 50 , "q3");
        dr.connectStates("q1","q2","1");
        dr.connectStates("q1","q3","0");
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fm.setSize(400, 400);
        fm.setBackground(Color.yellow);
        fm.setVisible(true);
        fm.add(dr);
    }
}
