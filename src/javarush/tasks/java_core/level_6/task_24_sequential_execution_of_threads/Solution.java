/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_24_sequential_execution_of_threads;

/**
 *
 * @author Koles
 */
public class Solution {
    public static volatile int COUNT = 4;
    public Solution(){
        for(int i = 0; i < COUNT; i++){
            try{
            new SleepingThread().join();
            }catch(InterruptedException e){
                
            }
            
        }
    }
    
    public static class SleepingThread extends Thread{
        private static volatile int threadCount = 0;
        private volatile int countDownIndex = COUNT;
        
        public SleepingThread(){
            super(String.valueOf(++threadCount));
            start();
        }
        
        @Override
        public void run(){
            while(true){
                System.out.println(this);
                if(--countDownIndex == 0)
                    return;
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){
                    System.out.println("Нить прервана");
                    return;
                }
            }
        }
        
        @Override
        public String toString(){
            return "#" + getName() + ": " + countDownIndex;
        }
    }
}
