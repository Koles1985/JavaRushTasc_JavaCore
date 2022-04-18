
package javarush.tasks.java_core.level_6.task_3_output_stack_trace;


public class Solution {
    
    public Solution(){
        for(StackTraceElement element : 
                Thread.currentThread().getStackTrace()){
            System.out.println("Solution - " + element);
        }
        
        System.out.println("*********************************************");
        
        SpecialThread specialThread = new SpecialThread();
        new Thread(specialThread).start();
    }
    
    public static class SpecialThread implements Runnable{
        @Override
        public void run(){
            for(StackTraceElement element : 
                    Thread.currentThread().getStackTrace()){
                System.out.println(element);
            }
        }
    }
    
}
