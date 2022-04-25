/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_23_thread_curent_thread_always_return_curent_thread;

/**
 *
 * @author Koles
 */
public class Solution {
    private int count = 5;
    
    public Solution(){
        ThreadNamePrinter tnp = new ThreadNamePrinter();
        tnp.start();
        for(int i = 0; i < count; i++){
            tnp.printMsg();
        }
    }
    
    public class ThreadNamePrinter extends Thread{
        @Override
        public void run(){
            for(int i = 0; i < count; i++){
                printMsg();
            }
        }
        
        public void printMsg(){
            Thread t = Thread.currentThread();
            String name = t.getName();
            System.out.println("Name = " +  name);
            try{
                sleep(1);
            }catch(InterruptedException e){
                
            }
        }
    }
    
}
