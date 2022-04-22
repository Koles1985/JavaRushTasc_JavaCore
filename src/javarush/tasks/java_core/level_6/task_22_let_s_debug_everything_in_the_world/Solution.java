/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_22_let_s_debug_everything_in_the_world;

/**
 *
 * @author User
 */
public class Solution {
    public Thread.UncaughtExceptionHandler handler = 
            new OurUncaughtExceptionHandler();
    public Solution(){
        //TestedThread commonThread = new TestedThread(handler);
        //Thread.setDefaultUncaughtExceptionHandler(handler);
        
        Thread threadA = new Thread(() ->{
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                throw new RuntimeException("ThreadA runtime exception: - " +
                        Thread.currentThread().getName());
            }
                },"Нить 1" );
        Thread threadB = new Thread(() ->{
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                throw new RuntimeException("ThreadB runtime exception: "
                + Thread.currentThread().getName());
            }
                },"Нить 2");
        
        threadA.setUncaughtExceptionHandler(handler);
        threadB.setUncaughtExceptionHandler(handler);
        
        
        threadA.start();
        threadB.start();
        
        
        threadA.interrupt();
        threadB.interrupt();
    }
    
    private class TestedThread extends Thread{
        private TestedThread(Thread.UncaughtExceptionHandler handler){
            setUncaughtExceptionHandler(handler);
            //setDefaultUncaughtExceptionHandler(handler);
            start();
        }
        
        @Override
        public void run(){
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                throw new RuntimeException("My exception message");
            }
        }
    }

    private static class OurUncaughtExceptionHandler 
            implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + 
                    e.getMessage());
        }
    }
}
