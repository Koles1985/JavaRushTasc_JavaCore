package javarush.tasks.java_core.level_6.task_7_political_debate;


public class Solution {
    public int totalSpeechCount = 200;
    public int utterancesPerSpeech = 1000000;
    
    public Solution(){
        Politician ivanov = new Politician("Иванов");
        try{
            ivanov.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        Politician petrov = new Politician("Петров");
        Politician sidorov = new Politician("Сидоров");
        
        while(sidorov.getSpeechCount() + ivanov.getSpeechCount()
                + petrov.getSpeechCount() < totalSpeechCount){
        }
            System.out.println(ivanov);
            System.out.println(petrov);
            System.out.println(sidorov);
        
    }
    
    public class Politician extends Thread{
        private volatile int utteranceCount;
        
        public Politician(String name){
            super(name);
            start();
        }
        
        @Override
        public void run(){
            while(utteranceCount < totalSpeechCount * utterancesPerSpeech){
                utteranceCount++;
            }
        }
        
        public int getSpeechCount(){
            return utteranceCount / utterancesPerSpeech;
        }
        
        @Override 
        public String toString(){
            return String.format("%s сказал речь %d раз", getName(), 
                    getSpeechCount());
        }
    }
}
