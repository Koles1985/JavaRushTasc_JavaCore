/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_21_tangle;

/**
 *
 * @author User
 */
public class FourthThread extends Thread implements Message {
    @Override
    public void run(){
        while(!isInterrupted()){
            
        }
    }
    
    @Override
    public void showWarning(){
        if(Thread.currentThread().isAlive()){
            currentThread().interrupt();
        }
    }
}
