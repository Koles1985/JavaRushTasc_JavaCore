package javarush.tasks.java_core.level_6.task_1_my_first_thread;


public class Solution {
    public Solution(){
        TestThread task = new TestThread();
        new Thread(task).start();
    }
    
    public class TestThread implements Runnable{
        @Override
        public void run(){
            System.out.println("My first thread!");
        }
    }
}
