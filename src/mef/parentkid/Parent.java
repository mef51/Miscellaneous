package mef.parentkid;

public class Parent {
    
    private static final long SLEEP_TIME = 1000/5; // think 5 fps
    
    public Parent(){
        
    }
    
    public void alert(Kid k){
        System.out.println("Parent: I'll help you!");
        sleep(SLEEP_TIME * 3);
        k.help();
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

}
