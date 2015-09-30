
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alan Gonzalez
 */
public class Main {

    private static final int maxNumber = 1000000;
    private static final int numberOfThreads = 3;
    
    
    public static void main(String[] args) {
        int circularPrimesCount = 0;
        int fromNumber = 2;
        int toNumber = maxNumber / numberOfThreads;
        List<CircularPrimeThread> threads = new LinkedList<>();
        for(int i = 0; i < numberOfThreads; i++){ //divide the input on different threads
            CircularPrimeThread t = new CircularPrimeThread(fromNumber,toNumber);
            t.setName(String.valueOf(i+1));
            threads.add(t);
            t.start(); 
            fromNumber = toNumber + 1;
            toNumber += maxNumber / numberOfThreads; 
        }   
        System.out.println("Primos circulares:");
        for(CircularPrimeThread t : threads){
            try {
                t.join();  //wait for all threads
                circularPrimesCount += t.circularPrimeList.size();
                System.out.println("Thread "+t.getName()+": "+t.circularPrimeList);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Cantidad total: "+ circularPrimesCount);
    }
    
}
