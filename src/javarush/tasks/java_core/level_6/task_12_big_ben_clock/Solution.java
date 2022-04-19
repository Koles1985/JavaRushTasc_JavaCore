/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_12_big_ben_clock;

/**
 *
 * @author Koles
 */
public class Solution {
    public volatile boolean isStoped = false;
    public Solution(){
        Clock clock = new Clock("Лондон", 23, 59, 57);
        sleep(4000);
        isStoped = true;
        sleep(1000);
    }
    
    private void sleep(int ms){
        try{
            Thread.sleep(ms);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public class Clock extends Thread{
        private String cityName;
        private int hours;
        private int minutes;
        private int seconds;
        private long timeDifference;
        
        public Clock(String cityName, int hours, int minutes, int seconds){
            this.cityName = cityName;
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            start();
        }
        
        @Override
        public void run(){
            try{
                while(!isStoped){
                    printTime();
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        private boolean isFirstTime = true;
        public void printTime() throws InterruptedException{
            if(isFirstTime){
                sleep(1000);
                isFirstTime = false;
            }else{
                sleep(1000 - timeDifference);
            }
            long start = System.currentTimeMillis();
            seconds++;
            if(seconds > 59){
                seconds = 0;
                minutes++;
                if(minutes > 59){
                    minutes = 0;
                    hours++;
                    if(hours > 23)
                        hours = 0;
                }
            }
            if(hours == 0 && minutes == 0   && seconds == 0){
                System.out.printf("В г. %s сейчас полночь\n", cityName);
            }else{
                System.out.printf("В г. %s сейчас %d:%d:%d\n", cityName,
                        hours, minutes, seconds);
            }
            
            long stop = System.currentTimeMillis();
            timeDifference = stop - start;
        } 
   }
}
