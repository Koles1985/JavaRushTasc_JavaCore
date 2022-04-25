/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_25_recursive_thread_creation;

/**
 *
 * @author Koles
 */
public class Solution {
    int count =15;
    static volatile int createdThreadCount;
    
    public Solution(){
        System.out.println(new GenerateThread());
    }
    
    public  class GenerateThread extends Thread{
        public GenerateThread(){
            super(String.valueOf(++createdThreadCount));
            start();
        }
        
        @Override
        public void run(){
            if(createdThreadCount < count){
                System.out.println(new GenerateThread());
            }
        }

        @Override
        public String toString() {
            return "GenerateThread{" + " Thread #" + this.getName() + 
                    ": created" +'}';
        }
        
        
        
    }
}
