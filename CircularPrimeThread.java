
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Alan Gonzalez
 */
public class CircularPrimeThread extends Thread{
 
    public int fromNumber;
    public int toNumber;
    public List<Integer> circularPrimeList = new LinkedList<>();;

    public CircularPrimeThread(int from, int to) {
        this.fromNumber = from;
        this.toNumber = to;
        //circularPrimeList = 
    }
    
    @Override
    public void run(){
        for(int i = fromNumber; i <= toNumber; i++){ 
           if(Utils.isCircularPrime(i)){
                circularPrimeList.add(i); // add number on result list
            }
        }
    }
}
