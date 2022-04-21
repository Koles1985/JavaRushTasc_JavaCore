/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_16_countdown_to_the_races;

/**
 *
 * @author Koles
 */
public class Solution {
    public volatile int numSeconds = 3;
    public Solution(){
        RacingClock clock = new RacingClock();
        try{
            Thread.sleep(3500);
            clock.interrupt();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        
    }
    
    public class RacingClock extends Thread{
        public RacingClock(){
            start();
        }
        
        @Override
        public void run(){
            try{
                while(!isInterrupted() && numSeconds > 0){
                    
                    System.out.print(numSeconds-- + " ");
                    sleep(1000);
                    
                }
                System.out.println("Марш!");
            }catch(InterruptedException e){
                System.out.println("Прервано!");
            }
        }
    }
}
