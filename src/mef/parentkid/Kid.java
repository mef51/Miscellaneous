package mef.parentkid;

public class Kid {
    
    public static void main(String[] args){
        Parent supervisor= new Parent();
        Kid k = new Kid(supervisor);
        k.play();
    }

    private Parent supervisor;
    private boolean isOkay = true;
    private static final long SLEEP_TIME = 1000/5; // think 5 fps
    
    public Kid(Parent p){
        supervisor = p;
    }
    
    /**
     * Kid plays... but there's a chance in something bad happening.
     * A 1 in 10 chance.
     */
    public void play(){
        while(isOkay){
            println("Kid: lalala playing in snow tunnel... ");
            
            if(getRandomInt(0, 9) == 0){
                println("Kid: Oh noez snow collapse!! ... :(");
                sleep(SLEEP_TIME * 3);
                isOkay = false;
                supervisor.alert(this);
            }
            
            // slow the thread down so we can watch console
            sleep(SLEEP_TIME);
        }
    }
    
    /**
     * sleep the thread.
     * @param ms
     */
    private void sleep(long ms){
        try{
            Thread.sleep(ms);
        }catch(Exception e){} // do nothing
    }
    
    public void help(){
        isOkay = true;
        println("Kid: Thanks!");
        sleep(SLEEP_TIME * 3);
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
    
    private static void print(Object o){
        System.out.print(o);
    }
    
    private static void println(Object o){
        print(o);
        print("\n");
    }
}
