/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_31_only_in_turn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author User
 */
public class Solution {
    public volatile BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    public Solution(){
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        
        t1.start();
        tryJoin(t1);
        
        t2.start();
        tryJoin(t2);
        
        t1.printResult();
        t2.printResult();
        
        try{
            if(reader != null){
                reader.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void tryJoin(Thread thread){
        try{
            thread.join();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    
    public class Read3Strings extends Thread{
        private int count = 3;
        StringBuilder innerText;
        public Read3Strings(){
            this.innerText = new StringBuilder();
        }
        @Override
        public void run(){
            try{
                while(count > 0){
                    if((innerText.append(reader.readLine() + " ")) != null){
                       count--; 
                    }
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        public void printResult(){
            System.out.println(innerText.toString());
        }
    }
    
}
