import java.util.Random;

/**
 * I have this calendar made of blocks. Two cubes have numbers on them 
 * for the day and a long thin rectangle has the months on it.
 * (It's like this one: http://www.folkartgatherings.com/images/Blackcalendarblocks.jpg)
 * My brother took the blocks and treated them like dice.
 * 
 * "When will I be rich?" He says, and then rolls the blocks.
 * "July 2nd yaaay!"
 * 
 * I think we played with the blocks for a good 15 minutes. 
 * I wrote this so we could add a year to our dice's "predictions". 
 * Of course you can set the range of years to roll ;P
 * 
 * You can get February 31st as an answer, and other invalid dates.
 * Just take that to mean "never" to your question. ;)
 * 
 * @author mohammed
 * @since February 22nd 2013
 *
 */
public class DateDice {
    
    private static String[] months = {"January","February","March","April","May", "June", "July","August","September","October","November","December"};
    
    public static void main(String[] args){
        System.out.println(getRandomMonth() + " " + getRandomInt(1, 31) + ", " + getRandomInt(2013, 2150));
    }
    
    private static String getRandomMonth(){ 
        return months[getRandomInt(0, months.length - 1)];
    }
    
    private static int getRandomInt(int min, int max){
        return min + (int)(Math.random() * (max - min + 1));
    }
}