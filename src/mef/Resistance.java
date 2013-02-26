package mef;

/**
 * 
 * I'm supposed to be prep-ing for a circuit lab.
 * 
 * Resistors have colored bands on them that specify the resistance in Ohms.
 * Each color maps to an integer.
 * First band -> first digit
 * Second band -> second digit
 * Third band -> multiply by 10^n where n is the value of the third band
 * Fourth band -> the uncertainty percentage. Can be gold (5%), silver (10%), or no band (20%)
 * 
 * black    -> 0
 * brown    -> 1
 * red      -> 2
 * orange   -> 3
 * yellow   -> 4
 * green    -> 5
 * blue     -> 6
 * violet   -> 7
 * grey     -> 8
 * white    -> 9
 * -=-=-=-=-=-=-
 * gold     -> 5
 * silver   -> 10
 * none     -> 20
 * 
 * @author mohammedc
 * @since Feb 24 2013
 *
 */
public class Resistance {
    
    public static void main(String[] args){
        String[] bands = {"white", "black", "red", "gold"};
        System.out.println("THIS RESISTOR IS OVER " + getResistance(bands) + "!");
    }
   
   /**
    * First band is first digit,
    * Second band is second digit,
    * Third band is the multiplier 10^Third
    * Fourth band is the percentage of uncertainty. Should be "gold", "silver" or "none"
    * @param bands
    */
   public static String getResistance(String[] bands){
       if(bands.length != 4) return "Wrong number of bands!";
       int resistance = 0;
       resistance += getIntFromColor(bands[0]) * 10;
       resistance += getIntFromColor(bands[1]);
       resistance *= Math.pow(10, getIntFromColor(bands[2]));
       
       return resistance + " Ohms plus or minus " + getIntFromColor(bands[3]) + "%";
   }
   
   private static int getIntFromColor(String color){
       color = color.toLowerCase();
       // last two entries of this array are uncertainty bands
       String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white", "gold", "silver", "none"};
       for(int i = 0; i < colors.length; i++){
           if(color.equals(colors[i])){
               if(i == colors.length - 3){ // gold band
                   return 5;
               }
               else if(i == colors.length - 2){ // silver band 
                   return 10;
               }
               else if(i == colors.length - 1){
                   return 20;
               }
               else{ // i < colors.length - 2
                   return i;
               }
           }
       }
       return -1;
   }
} // end class
