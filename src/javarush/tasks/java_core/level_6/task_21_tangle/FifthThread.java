/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_21_tangle;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class FifthThread extends Thread {
    @Override
    public void run(){
        System.out.println(readConsole());
    }
    
    private int readConsole(){
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()){
                try{
                int innerNumber = scanner.nextInt();
                sum += innerNumber;
                }catch(Exception e){
                    System.out.println(e.getMessage());
                    if(scanner.nextLine().equals("N"))
                        break;
                    
                }    
            }
        return sum;
    }
}
