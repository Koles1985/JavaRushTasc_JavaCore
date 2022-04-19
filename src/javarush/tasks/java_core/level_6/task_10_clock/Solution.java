/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_10_clock;

/**
 *
 * @author Koles
 */
public class Solution {
    private volatile boolean isStoped = false;
    
    public Solution(){
        Clock clock = new Clock();
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        isStoped = true;
        System.out.println("The clock has to be stoped!");
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        System.out.println("Double-check");
        
    }
    
    public class Clock extends Thread{
        public Clock(){
            setPriority(MAX_PRIORITY);
            start();
        }
        
        @Override
        public void run(){
            try{
                while(!isStoped){
                    printTikTak();
                }
            }catch(InterruptedException e){
                e.printStackTrace();   
            }
        }
        
        private void printTikTak() throws InterruptedException{
            sleep(500);
            System.out.println("Tik");
            sleep(500);
            System.out.println("Tak");
            
        }
    }
}
