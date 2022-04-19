/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_11_stopwatch;

/**
 *
 * @author Koles
 */
public class Solution {
    public volatile boolean isStoped = false;
    public Solution(){
        Runner ivanov = new Runner("Иванов", 4);
        Runner petrov = new Runner("Петров", 2);
        
        ivanov.start();
        petrov.start();
        sleep(2000);
        isStoped = true;
        sleep(100);
    }
    
    private void sleep(int ms){
        try{
            Thread.sleep(ms);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public class StopWatch extends Thread{
        private Runner owner;
        private int stepNumber;
        
        public StopWatch(Runner runner){
            this.owner = runner;
        }
        
        @Override
        public void run(){
            try{
                while(!isStoped){
                    doStep();
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        
        private void doStep() throws InterruptedException{
            stepNumber++;
            Thread.sleep(1000 / owner.getSpeed());
            System.out.println(owner.getName() + " делает шаг №" 
                    + stepNumber);
        }
    }
    
    public class Runner{
        StopWatch stopWatch;
        private String name;
        private int speed;
        
        public Runner(String name, int speed){
            this.name = name;
            this.speed = speed;
            this.stopWatch = new StopWatch(this);
        }

        public String getName() {
            return name;
        }

        public int getSpeed() {
            return speed;
        }
        
        public void start(){
            stopWatch.start();
        }
    }
}
