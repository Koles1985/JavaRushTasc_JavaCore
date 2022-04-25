/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_29_lets_play;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Koles
 */
public class Solution {
    public Solution(){
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }
    
    public static class OnlineGame extends Thread{
        public static volatile boolean isWinnerFound = false;
        
        public static List<String> steps = new ArrayList<>();
        static{
            Collections.addAll(steps, 
                    "Начало игры",
                    "Сбор ресурсов",
                    "Рост экономики",
                    "Убийство врагов");
        }
        
        protected Gamer gamer1 = new Gamer("Ivanov", 3);
        protected Gamer gamer2 = new Gamer("Petrov", 1);
        protected Gamer gamer3 = new Gamer("Sidorov", 5);
        
        @Override
        public void run(){
            gamer1.start();
            gamer2.start();
            gamer3.start();
            
            while(!isWinnerFound){   
            }
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
    }
    
    public static class Gamer extends Thread{
        private int rating;
        
        public Gamer(String name, int rating){
            super(name);
            this.rating = rating;
        }
        
        @Override
        public void run(){
            try{
                for(String action: OnlineGame.steps){
                    System.out.println(Thread.currentThread().getName() + ": "
                    + action);
                    Thread.sleep(1000 / rating);
                }
                if(!OnlineGame.isWinnerFound){
                    OnlineGame.isWinnerFound = true;
                    System.out.println(Thread.currentThread().getName() + 
                        ": победитель!");
                }
            }catch(InterruptedException e){  
                System.out.println(Thread.currentThread().getName() +
                        ": проиграл!");
            }
        }
    }
}
