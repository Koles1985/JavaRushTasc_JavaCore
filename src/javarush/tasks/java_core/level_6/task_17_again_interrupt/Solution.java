/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_17_again_interrupt;

/**
 *
 * @author Koles
 */
public class Solution {
    public Solution(){
        TestThread test = new TestThread();
        test.start();
        test.interrupt();
        
    }
    
    public class TestThread extends Thread{
        
        @Override
        public void run(){
            
        }
        
    }
}
