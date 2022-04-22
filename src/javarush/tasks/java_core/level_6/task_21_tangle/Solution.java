/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_21_tangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author User
 */
public class Solution {
    public static List<Thread> threads = new ArrayList<>();
    static{
        Collections.addAll(threads, 
                new FirstThread(),
                new SecondThread(),
                new ThirdThread(),
                new FourthThread(),
                new FifthThread());
    }
    
    public Solution(){
        for(Thread thread : threads){
            thread.start();
        }
    }
}
