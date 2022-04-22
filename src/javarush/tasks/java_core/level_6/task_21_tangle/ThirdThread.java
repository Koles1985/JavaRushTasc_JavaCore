/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_21_tangle;

/**
 *
 * @author User
 */
public class ThirdThread extends Thread {
    @Override
    public void run(){
        try{
            while(!isInterrupted()){
                System.out.println("Ура");
                Thread.sleep(500);
            }
        }catch(InterruptedException e){
            
        }
    }
}
