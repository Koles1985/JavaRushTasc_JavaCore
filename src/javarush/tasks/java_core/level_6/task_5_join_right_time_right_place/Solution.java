package javarush.tasks.java_core.level_6.task_5_join_right_time_right_place;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public Solution(){
        PrintListThread first = new PrintListThread("First");
        PrintListThread second = new PrintListThread("Second");
        first.start();
        try{
            first.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        second.start();
    }
    
    public void printList(List<String> list, String threadName){
        for(String item : list){
            System.out.printf("%s : %s\n", threadName, item);
        }
    }
    
    public List<String> getList(int n){
        List<String> result = new ArrayList<>();
        if(n < 1)
            return result;
        for(int i = 0; i < n; i++){
            result.add(String.format("String - %d", (i + 1)));
        }
        return result;
    }
    
    public class PrintListThread extends Thread{
        public PrintListThread(String name){
            super(name);
        }
        
        @Override
        public void run(){
            printList(getList(20), getName());
        }
    }
}
