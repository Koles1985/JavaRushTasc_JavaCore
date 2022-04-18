package javarush.tasks.java_core.level_6.task_4_lets_talk_about_music;

import java.util.Date;


public class Solution {
    
    private int delay = 1000;
    
    public Solution(){
        Thread firstThread = new Thread(new Violin("Player"));
        firstThread.start();
    }
    
    public void sleepNSeconds(int n){
        try{
            Thread.sleep(n * delay);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    
    public interface MusicalInstruments extends Runnable{
        Date startPlaying();
        Date stopPlaying();
    }
    
    public class Violin implements MusicalInstruments{
        
        private String owner;
        
        public Violin(String owner){
            this.owner = owner;
        }
        
        @Override
        public Date startPlaying(){
            System.out.println(this.owner + " - is starting to play");
            return new Date();
        }
        
        @Override
        public Date stopPlaying(){
            System.out.println(this.owner + " is stopping playing");
            return new Date();
        }
        
        @Override
        public void run(){
            calcTimePlaying();
        }
        
        private void calcTimePlaying(){
            Date startTime = startPlaying();
            sleepNSeconds(1);
            Date stopTime = stopPlaying();
            System.out.printf("Playing %d ms\n", stopTime.getTime() 
                    - startTime.getTime());
        }
    }
    
}
