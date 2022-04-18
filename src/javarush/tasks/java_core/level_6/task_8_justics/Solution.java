package javarush.tasks.java_core.level_6.task_8_justics;


public class Solution {
    public Solution(){
        Mouse alfa = new Mouse("#1");
        Mouse mouse2 = new Mouse("#2");
        Mouse mouse3 = new Mouse("#3");
        Mouse mouse4 = new Mouse("#4");
    }
    
    private void eat(){
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public class Mouse extends Thread{
        
        public Mouse(String name){
            super(name);
            start();
        }
        
        @Override
        public void run(){
            System.out.println(getName() + " is starting to eat!");
            eat();
            System.out.println(getName() + " has finishing eating!");
        }
    }
}
