
package javarush.tasks.java_core.level_6.task_6_horse_racing;


public class Horse extends Thread{
    private boolean isFinished;
    
    public Horse(String name){
        super(name);
    }
    
    public boolean isFinished(){
        return isFinished;
    }
    
    @Override
    public void run(){
        String s = "";
        for(int i = 0; i < 1001; i++){
            s += "" + i;
            if(i == 1000){
                s = " has finished the race!";
                System.out.println(getName() + s);
                isFinished = true;
            }
        }
    }
    
}
