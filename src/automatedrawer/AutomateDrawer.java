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
        dr.addState(50, 50, 50 , "q1");
        dr.addState(100, 100, 50 , "q21");
        dr.addState(100, 200, 50 , "q31");
        dr.addState(300, 100, 50 , "q41");
        dr.addState(300, 300, 50 , "q5");
        
        
        dr.connectStates("q1","q21","1");
        dr.connectStates("q1","q31","1");
        dr.connectStates("q1","q41","1");
        
        dr.connectStates("q2","q4","0");
        dr.connectStates("q5","q5","1");
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
