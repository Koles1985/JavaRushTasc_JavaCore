/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_30_who_got_up_first_and_the_slippers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Koles
 */
public class Solution {
    
    public static volatile AtomicInteger readStringCount = new AtomicInteger(0);
    public static volatile BufferedReader reader = new BufferedReader(
    new InputStreamReader(System.in));
    
    public Solution(){
        int count = 0;
        try{
            //read count of string
            count = Integer.parseInt(reader.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }
        
        //init threads
        ReaderThread consoleReader1 = new ReaderThread();
        ReaderThread consoleReader2 = new ReaderThread();
        ReaderThread consoleReader3 = new ReaderThread();
        
        consoleReader1.start();
        consoleReader2.start();
        consoleReader3.start();
        
        while(count > readStringCount.get()){}
        
        consoleReader1.interrupt();
        consoleReader2.interrupt();
        consoleReader3.interrupt();
        System.out.println("#1" + consoleReader1);
        System.out.println("#2" + consoleReader2);
        System.out.println("#3" + consoleReader3);
        
        try{
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public class ReaderThread extends Thread{
        private List<String> result = new ArrayList<>();
        
        @Override
        public void run(){
            
        }
        
        @Override 
        public String toString(){
            return result.toString();
        }
    }
    
    
}
