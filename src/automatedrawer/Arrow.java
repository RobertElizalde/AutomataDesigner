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
    
    public Arrow(int begin[], int end[]){
        this.begin = begin;
        this.end = end;
    }
    public Arrow(int begin[], int end[], String condition){
        this.begin = begin;
        this.end = end;
        this.condition = condition;
        this.conditionCordinates = new int[2];
    }
    public int[] getCoditonCordinates(){
        conditionCordinates[0] = (begin[0]+end[0])/2;
        conditionCordinates[1] = ((begin[1]+end[1])/2 ) - 10;
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
    
}
