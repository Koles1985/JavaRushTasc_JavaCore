/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_27_mutual_blocking;

/**
 *
 * @author Koles
 */
public class Solution {
    private Thread t1 = new T1();
    private Thread t2 = new T2();
    
    
    public Solution(){
        t1.start();
        //t1.interrupt();
        t2.start();
        t2.interrupt();
    }
    
    private class T1  extends Thread{
        @Override
        public void run(){
           try{
               t2.join();
               System.out.println("T1 finished");
           } catch(InterruptedException e){
               System.out.println("T1 was interrupted");
           }
        }
    }
    
    private class T2 extends Thread{
        @Override
        public void run(){
            try{
                t1.join();
                System.out.println("T2 finished");
            }catch(InterruptedException e){
                System.out.println("T2 was interrupted");
            }
        }
    }
}
