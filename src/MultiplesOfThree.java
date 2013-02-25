
/**
 * THEOREM: 
 * Let n be an integer.
 * If the sum of n's digits are a multiple of 3, 
 * Then n is divisible by 3.
 * 
 * @author mohammed
 * @since Saturday, February 2nd, 2013
 *
 */
public class MultiplesOfThree {
    
    public static void main(String[] args){
        int numberOfMultiples = 5000; // set as you please
        System.out.println(checkTheoremUpTo(numberOfMultiples) ? "Theorem Holds up to " + 3*numberOfMultiples + "!" : "Theorem doesn't hold.");
    }
    
    /**
     * Generates the multiples of 3 up to n * 3,
     * then checks the theorem on each multiple.
     * That is, checks if the digits of each multiple of 3 add up to 
     * a multiple of 3.
     * 
     *  Returns true if the theorem is true for all multiples of 3 up to 3*n.
     *  Returns false otherwise.
     * @param n
     */
    public static boolean checkTheoremUpTo(int n){
        int[] multiplesOfThree = new int[n];
        for(int i = 0; i < multiplesOfThree.length; i++){
            multiplesOfThree[i] = 3 * (i + 1);
        }
        
        System.out.println("Does the theorem hold for all multiples of 3?");
        for(int i = 0; i < n; i++){
            int multiple = 3 * (i+1);
            if(getSumOfDigits(multiple) % 3 == 0){
                System.out.println(multiple + ": yes" );
            }
            else{
                System.out.println(multiple + ": no!");
                return false;
            }
        }
        return true;
    }
    
    public static int getSumOfDigits(int n){
        int sum = 0;
        int[] digits = getDigits(n);
        for(int i = 0; i < digits.length; i++){
            sum += digits[i];
        }
        return sum;
    }
    
    /**
     * Explanation by example: get the digits for 1234
     * n = 1234;
     * digits[0] = n / (int)Math.pow(10, numDigits - 1); // 1234 / 1000 = 1
     * digits[1] = n / (int)Math.pow(10, numDigits - 2) - digits[0] * 10; // 1234 / 100 - 1*10 = 2
     * digits[2] = n / (int)Math.pow(10, numDigits - 3) - digits[0] * 100 - digits[1] * 10; // 1234 / 10 - 1*100 - 2*10 = 3
     * digits[3] = n / (int)Math.pow(10, numDigits - 4) - digits[0] * 1000 - digits[1] * 100 - digits[2] * 10; // 1234 / 1 - 1*1000 - 2*100 - 3*10 = 4
     * 
     * @param n
     * @return
     */
    public static int[] getDigits(int n){
        int numDigits = getNumDigits(n); // 4
        int[] digits = new int[numDigits];      
        for(int i = 0; i < digits.length; i++){
            int extra = 0;
            for(int j = 0; j < i; j++){
                extra += digits[j] * Math.pow(10, i - j);
            }
            digits[i] = n / (int)Math.pow(10, numDigits - (i + 1)) - extra;
        }
        return digits;
    }
    
    public static int getNumDigits(int n){
        int digits = 1;
        while(n / 10 != 0){
            digits++;
            n = n / 10;
        }
        return digits;
    }
} // end class
