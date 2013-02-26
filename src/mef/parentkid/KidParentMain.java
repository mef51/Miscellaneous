package mef.parentkid;

public class KidParentMain {
    private static boolean isOkay = true;
    
    public static void main(String[] args){
        runExampleStatically();
    }
    
    /**
     * Kid playing in snow, snow falls, parent helps.
     * No objects, the bare bones.
     */
    private static void runExampleStatically(){
        while(isOkay){
            println("Kid: lalala playing in snow...");
            
            if(getRandomInt(0, 9) == 0){ // 1 in 10 chance of snow collapse
                makeBadThingHappen();
                getHelp();
            }
            
            try{
                Thread.sleep(1000/10);
            }catch(Exception e){}
        }
    }
    
    private static void makeBadThingHappen(){
        isOkay = false;
        println("Kid: oh noez snow collapse!! :(");
    }
    
    private static void getHelp(){
        isOkay = true;
        System.out.println("Parent: I'll get you out!");
    }
    
    private static void print(Object o){
        System.out.print(o);
    }
    
    private static void println(Object o){
        print(o);
        print("\n");
    }
    
    /**
     * random nums from min to max, inclusive
     * @param min
     * @param max
     * @return
     */
    private static int getRandomInt(int min, int max){
        return min + (int)(Math.random() * (max - min + 1));
    }
} // end class
