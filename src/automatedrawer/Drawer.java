package automatedrawer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Robert Elizalde
 */
public class Drawer extends JPanel{
    private ArrayList<State> st;
    private ArrayList<Arrow> ar;
    public Drawer(){
        this.st = new ArrayList<State>();
        this.ar = new ArrayList<Arrow>();
    }
    public void addState(int x, int y, int r, String id){
        st.add(new State(x, y, r, id));
        repaint();
    }
    public void connectStates(String a1Id, String a2Id){
        int a1ConnectionPoint[] = null;
        int a2ConnectionPoint[] = null;
        int rxa1 = 0;
        int rxa2 = 0;
        
        for (int i = 0; i < st.size(); i++) {
            if (st.get(i).getId().equals(a1Id)) {
                rxa1 = st.get(i).getX();
            }
            if (st.get(i).getId().equals(a2Id)){
                rxa2 = st.get(i).getX();
            }
        }
        for (int i = 0; i < st.size(); i++) {
            if (st.get(i).getId().equals(a1Id)) {
                a1ConnectionPoint = st.get(i).getPointOfConnection(rxa2);
            }
            if (st.get(i).getId().equals(a2Id)){
                a2ConnectionPoint = st.get(i).getPointOfConnection(rxa1);
            }
        }
        if (a1ConnectionPoint != null && a2ConnectionPoint != null ) {
            ar.add(new Arrow(a1ConnectionPoint, a2ConnectionPoint));
        }
        
    }
    public void connectStates(String a1Id, String a2Id, String condition){
        int a1ConnectionPoint[] = null;
        int a2ConnectionPoint[] = null;
        int rxa1 = 0;
        int rxa2 = 0;
        
        for (int i = 0; i < st.size(); i++) {
            if (st.get(i).getId().equals(a1Id)) {
                rxa1 = st.get(i).getX();
            }
            if (st.get(i).getId().equals(a2Id)){
                rxa2 = st.get(i).getX();
            }
        }
        for (int i = 0; i < st.size(); i++) {
            if (st.get(i).getId().equals(a1Id)) {
                a1ConnectionPoint = st.get(i).getPointOfConnection(rxa2);
            }
            if (st.get(i).getId().equals(a2Id)){
                a2ConnectionPoint = st.get(i).getPointOfConnection(rxa1);
            }
        }
        if (a1ConnectionPoint != null && a2ConnectionPoint != null ) {
            ar.add(new Arrow(a1ConnectionPoint, a2ConnectionPoint, condition));
        }
        
    }
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.red);
        g2.setStroke( new BasicStroke( 3.0f ) );
        for (int i = 0; i < this.st.size(); i++) {
            g2.drawOval(st.get(i).getX(), st.get(i).getY(), st.get(i).gerD(), st.get(i).gerD());
            g2.drawString(st.get(i).getId(), st.get(i).getIdX(), st.get(i).getIdY());
        }
        
        for (int j = 0; j < ar.size(); j++) {
            g2.setColor(Color.BLUE);
            g2.drawLine(ar.get(j).getBegin()[0], ar.get(j).getBegin()[1], ar.get(j).getEnd()[0], ar.get(j).getEnd()[1]);
            g2.setColor(Color.BLACK);
            g2.drawOval(ar.get(j).getEnd()[0], ar.get(j).getEnd()[1], 4, 4);
            g2.drawString(ar.get(j).getCondition(), ar.get(j).getCoditonCordinates()[0], ar.get(j).getCoditonCordinates()[1]);
        }
    }
}
