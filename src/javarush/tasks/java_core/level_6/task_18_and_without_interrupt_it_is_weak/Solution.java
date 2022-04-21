/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_18_and_without_interrupt_it_is_weak;

/**
 *
 * @author Koles
 */
public class Solution {
    public volatile boolean isStop = false;
    public Solution(){
        Thread t = new Thread(new TestThread());
        t.start();
        try{
            Thread.sleep(3000);
            ourInterraptMethod();
        }catch(InterruptedException e){
            
        }
    }
    
    public void ourInterraptMethod(){
           isStop = true; 
    }
    
    public class TestThread implements Runnable{
       
        @Override
        public void run() {
            while(!isStop){
                try{
                    System.out.println("he-he");
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }  
    }   
}
