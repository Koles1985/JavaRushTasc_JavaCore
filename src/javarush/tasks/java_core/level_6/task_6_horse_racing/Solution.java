package javarush.tasks.java_core.level_6.task_6_horse_racing;

import java.util.ArrayList;
import java.util.List;


public class Solution {
    
    public Solution(){
        List<Horse> horses = prepareHorsesAndStart(10);
        while(calculateHorsesFinished(horses) != horses.size()){
            
        }
    }
    
    private int calculateHorsesFinished(List<Horse> listHorse){
        int finishedCount = 0;
        for(Horse horse : listHorse){
            if(!horse.isFinished()){
                System.out.println("Waiting for " + horse.getName());
                try{
                    horse.join();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                
            }else{
                finishedCount++;
            }
            
        }
        return finishedCount;
    }
    
    private List<Horse> prepareHorsesAndStart(int horseCount){
        List<Horse> horsesList = new ArrayList<>(horseCount);
        String number;
        for(int i = 1; i < horseCount + 1; i++){
            number = i < 10 ? ("0" + i) : ("" + i);
            horsesList.add(new Horse("Horse - " + number));
        }
        
        System.out.println("All horses start the race!");
        for(Horse horse : horsesList){
            horse.start();
        }
        return horsesList;
    }
    
}
