/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_21_tangle;

/**
 *
 * @author User
 */
public class SecondThread extends Thread {
    @Override
    public void run(){
        try{
            throw new InterruptedException();
            
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
}
