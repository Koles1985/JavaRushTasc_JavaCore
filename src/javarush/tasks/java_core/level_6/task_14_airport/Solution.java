/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_14_airport;

/**
 *
 * @author Koles
 */
public class Solution {
    public static volatile Runway RUNWAY = new Runway(); // Взлетная полоса
    public Solution(){
        Plane plane1 = new Plane("Самолет #1");
        Plane plane2 = new Plane("Самолет #2");
        Plane plane3 = new Plane("Самолет #3");
    }
    
    private void waiting(){
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    private void takingOff(){
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public class Plane extends Thread{
        public Plane(String name){
            super(name);
            start();
        }
        
        @Override
        public void run(){
            boolean isAlreadyTakenOff = false;
            while(!isAlreadyTakenOff){
               //Если взлетная полоса свободна занимаем ее
                if(RUNWAY.trySetTakingOffPlane(this)){ 
                    System.out.println(getName() + " взлетаем");
                    takingOff();//Взлетает
                    System.out.println(getName() + " уже в небе");
                    isAlreadyTakenOff = true;
                    RUNWAY.setTakingOffPlane(null);
                }else //Если взлетная полоса занята самолетом
                    if(!this.equals(RUNWAY.getTakingOffPlane())){
                        System.out.println(getName() + " ожидает.");
                        waiting();//ожидает
                }
            }
        }
    }
    public static class Runway{ //Взлетная полоса
        private Thread t;
        
        public Thread getTakingOffPlane(){
            return t;
        }
        
        public void setTakingOffPlane(Thread t){
            synchronized(this){
                this.t = t;
            }
        }
        
        public boolean trySetTakingOffPlane(Thread t){
            synchronized(this){
                if(this.t == null){
                    this.t = t;
                    return true;
                }
                return false;
            }
        }
    }
}
