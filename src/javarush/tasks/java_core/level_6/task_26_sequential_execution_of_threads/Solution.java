/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_26_sequential_execution_of_threads;

/**
 *
 * @author Koles
 */
public class Solution {
    
    public MyThread t = new MyThread();
    String message = "inside main ";
    public Solution(){
        t.start();
        try{
            t.join();
        }catch(InterruptedException e){
            
        }
        for(int i = 0; i < 10; i++){
            System.out.println(message + i);
            sleep();
        }
    }
    
    private static void sleep(){
        try{
            Thread.sleep(10);
        }catch(InterruptedException e){
            
        }
    }
    
    private class MyThread extends Thread{
        String message = "inside MyThread ";
        @Override
        public void run(){
            for(int i = 0; i < 10; i++){
                System.out.println(message + i);
                Solution.sleep();
            }
        }
    }
    
}
