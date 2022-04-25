/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_28_cample_creation;

/**
 *
 * @author Koles
 */
public class Solution {
    public static int number = 5;
    
    public Solution(){
        new Thread(new CountdownRunnable(), "Уменьшаем").start();
        new Thread(new CountUpRunnable(), "Увеличиваем").start();
        
    }
    
    public class CountUpRunnable implements Runnable{
        private int countIndexUp = 1;
        
        @Override
        public void run(){
            try{
                while(true){
                    System.out.println(toString());
                    countIndexUp += 1;
                    if(countIndexUp == Solution.number + 1)
                        return;
                    Thread.sleep(500);
                }
            }catch(InterruptedException e){
                
            }
        }
        
        @Override
        public String toString(){
            return Thread.currentThread().getName() + ": " + countIndexUp;
        }
    }
    
    public class CountdownRunnable implements Runnable{
        private int countIndexDown = Solution.number;
        
        @Override 
        public void run(){
            try{
                while(true){
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if(countIndexDown == 0)
                        return;
                    Thread.sleep(500);
                }
            }catch(InterruptedException e){
                
            }
        }
        
        @Override
        public String toString(){
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
        
    }
    
}
