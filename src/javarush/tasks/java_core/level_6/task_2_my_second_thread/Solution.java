package javarush.tasks.java_core.level_6.task_2_my_second_thread;


public class Solution {
    public Solution(){
       TestThread thread = new TestThread();
       thread.start();
    }
    
    public static class TestThread extends Thread{
        static{
            System.out.println("it\'s a static block inside TestThread");
        }
        
        @Override
        public void run(){
            System.out.println("it's a run method");
        }
    }
}
