/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_15_counting_the_seconds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Koles
 */
public class Solution {
    public Solution(){
        try( InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(in))
        {
         //create run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public class Stopwatch extends Thread{
        private int seconds;
        
        @Override
        public void run(){
           /* while(!isInterrupted()){
                try{
                    sleep(1000);
                    seconds++;
                }catch(InterruptedException e){
                    interrupt();
                    System.out.printf("Seconds passed %d\n", seconds);
                }
            }
            */
           
           //Thread current = Thread.currentThread();
           try{
               while(!isInterrupted()){
               sleep(1000);
               seconds++;
               }
           }catch(InterruptedException e){
               System.out.printf("Seconds passed %d\n", seconds);
           }
        }
    }
    
}
