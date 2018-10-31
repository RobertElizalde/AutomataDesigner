package automatedrawer;
/**
 *
 * @author reves
 */
public class Arrow {
    private int begin[];
    private int end[];
    private int conditionCordinates[];
    private String condition;
    private boolean conectedIS;
    
    public Arrow(int begin[], int end[]){
        this.begin = begin;
        this.end = end;
        this.conectedIS = false; 
    }
    public Arrow(int begin[], int end[], String condition){
        this.begin = begin;
        this.end = end;
        this.condition = condition;
        this.conditionCordinates = new int[2];
    }
    public Arrow(int begin[], int end[], String condition, boolean conectedIS){
        this.begin = begin;
        this.end = end;
        this.condition = condition;
        this.conditionCordinates = new int[2];
        this.conectedIS = conectedIS;
    }
    public int[] getCoditonCordinates(int ratio){
        if (conectedIS) {
            conditionCordinates[0] = this.end[0] + ratio/2;
            conditionCordinates[1] = this.end[1] - ratio - ratio/2 ;
        }
        else{
            conditionCordinates[0] = (begin[0]+end[0])/2;
            conditionCordinates[1] = ((begin[1]+end[1])/2 ) - 10;
        }
        
        return conditionCordinates;
    }
    public String getCondition(){
        return condition;
    }
    
    public int[] getBegin() {
        return begin;
    }

    public int[] getEnd() {
        return end;
    }
   
    public boolean IsConnetedToItSelf(){
        return this.conectedIS;
    }
    
    public void connectedToItSelf(){
        this.conectedIS = false;
    }
    
}
