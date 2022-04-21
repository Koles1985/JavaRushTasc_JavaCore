/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_19_one_for_all_all_for_one;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Koles
 */
public class Solution {
    public byte threadCount = 3;
    List<Thread> threads = new ArrayList<>(threadCount);
    
    public Solution(){
      initThreadsAndStart();
        try{
            Thread.sleep(3000);
            ourInterraptMethod();
        }catch(InterruptedException e){
            
        }  
    }
    
    public void ourInterraptMethod(){
        for(Thread thread : threads){
            thread.interrupt();
        }
    }
    
    private void initThreadsAndStart(){
        Water water = new Water("water");
        for(int i = 0; i < threadCount; i++){
            threads.add(new Thread(water, "#" + i));
        }
        
        for(int i = 0; i < threadCount; i++){
            threads.get(i).start();
        }
    }
    
    public class Water implements Runnable{
        private String sharedResource;
        
        public Water(String sharedResource){
            this.sharedResource = sharedResource;
        }
        @Override
        public void run(){
            Thread current = Thread.currentThread();
            boolean isCurrentThreadInterrapted = current.isInterrupted();
            String threadName = current.getName();
            
            try{
                while(!isCurrentThreadInterrapted){
                    System.out.println("Обьект " + sharedResource + 
                            ", нить " + threadName);
                    Thread.sleep(1000);
                }
            }catch(InterruptedException e){
                
            }
        }
    }
}
