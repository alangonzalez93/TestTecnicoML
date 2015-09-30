
/**
 * This class contain auxiliary methods.
 * @author Alan Gonzalez
 */
public class Utils {
    
    //This method calculates if the number given as a parameter is prime.
    public static boolean isPrime(int number){
        if(number == 2) return true;
        if(number % 2 == 0) return false; 
        for(int i = 3; i * i <= number; i += 2) { //looking in odd numbers smaller than the square root of the parameter
            if(number % i == 0) // is divisible for another number
                return false;
        }
        return true;
    }
    
    //This method calculates if the number given as a parameter is a circular prime.
    public static boolean isCircularPrime(int number){
        boolean result = true;
        String stringNumber = String.valueOf(number);
        for(int i = 0; i < stringNumber.length() && result; i++){
            result = result && isPrime(Integer.parseInt(stringNumber));
            char firstNumber = stringNumber.charAt(0); //get first number of the parameter
            stringNumber = stringNumber.substring(1)+firstNumber;//paste the first number on the last
        }
        return result;
    }
}
