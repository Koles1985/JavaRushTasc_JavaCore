/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_13_countdown;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Koles
 */
public class Solution {
    public static volatile List<String> list = new ArrayList<>(5);
    static{
        for(int i = 0; i < 5; i++){
            list.add("Строка - " + i);
            //System.out.println(list.get(i));
        }
    }
    public Solution(){
        Thread t = new Thread(new Countdown(3), "Countdown");
        t.start();
    }
    
    public class Countdown implements Runnable{
        private int countFrom;
        
        public Countdown(int countFrom){
            this.countFrom = countFrom;
        }
        
        @Override
        public void run(){
            try{
                while(countFrom > 0){
                    printCountdown();
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        
        public void printCountdown() throws InterruptedException{
            
            countFrom--;
            Thread.sleep(500);
            System.out.println(Solution.list.get(countFrom));
        }
    }
}
