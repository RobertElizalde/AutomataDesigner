package automatedrawer;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Robert Elizalde
 */
public class AutomateDrawer {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame fm = new JFrame("Automate");
        Drawer dr = new Drawer();
        dr.addState(200, 200, 50 , "q1");
        dr.addState(100, 100, 50 , "q2");
        dr.addState(300, 100, 50 , "q3");
        dr.addState(100, 300, 50 , "q4");
        dr.addState(300, 300, 50 , "q5");
        
        dr.connectStates("q1","q2","1");
        dr.connectStates("q1","q3","1");
        dr.connectStates("q1","q4","1");
        dr.connectStates("q1","q5","0");
        dr.connectStates("q2","q4","0");
        dr.connectStates("q5","q3","1");
        ArrayList<String> conexions = dr.getConnectionsOfState("q1");
        for (int i = 0; i < conexions.size(); i++) {
            System.out.println(conexions.get(i));
        }
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fm.setSize(400, 400);
        fm.setBackground(Color.yellow);
        fm.setVisible(true);
        fm.add(dr);
    }
}
