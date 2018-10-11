package automatedrawer;
/**
 *
 * @author reves
 */
public class State {
    private int x;
    private int y;
    private int d;
    private String id;
    private int idX;
    private int idY;
    private int minYRange;
    private int maxYRange;
    public State(int x, int y, int d, String id){
        this.x = x;
        this.y = y;
        this.d = d;
        this.id = id;
        this.idX = x - (id.length() * 3);
        this.idY = y ;
        this.maxYRange = y + d/2;
        this.minYRange = y - d/2;
    }

    public int getX() {
        return x - d/2;
    }

    public int getY() {
        return y - d/2;
    }
    public int gerD(){
        return d;
    }

    public String getId() {
        return id;
    }

    public int getIdX() {
        return idX;
    }

    public int getIdY() {
        return idY;
    }
    public int[] getPointOfConnection(){
        System.out.println(this.maxYRange);
        System.out.println(this.minYRange);
        int pointOfConnection[] = new int[2];
        int y = (int)(Math.random()*(this.maxYRange - this.minYRange + 1)) + this.minYRange;
        System.out.println(y);
        int x = (int)Math.sqrt((d/2)*(d/2) - (y-this.y)*(y-this.y)) + (this.x);
        pointOfConnection[0] = x;
        pointOfConnection[1] = y;
        System.out.println("x = " + pointOfConnection[0] + " , Y = " + pointOfConnection[1]);
        return pointOfConnection;
    }
    public int[] getPointOfConnection(int xR, int yR){
        int pointOfConnection[] = new int[2];
        int y = getY();
        System.out.println("yR=" + yR + " y getY()=" + getY() );
        //Above the state 
        if (yR < getY()){
            y = (int)(Math.random()*(getY() - this.minYRange + 1)) + this.minYRange;
        }
        //Down the state
        if(yR > getY()){
            y = (int)(Math.random()*(this.maxYRange - getY() + 1)) + getY();
        }
        //Y equals
        if(yR==getY()){
            y = yR;
            System.out.println("igual");
        }
        // y = (int)(Math.random()*(this.maxYRange - this.minYRange + 1)) + this.minYRange;
        int x;
        if (xR < getX()) {
            x = -(int)Math.sqrt((d/2)*(d/2) - (y-this.y)*(y-this.y)) + (this.x);
        }
        else{
            x = (int)Math.sqrt((d/2)*(d/2) - (y-this.y)*(y-this.y)) + (this.x);
        }
        pointOfConnection[0] = x;
        pointOfConnection[1] = y;
        return pointOfConnection;
    }
}
