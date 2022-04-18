package javarush.tasks.java_core.level_6.task_9_method_join;


public class Solution {
    
    public Solution(){
        Cat luska = new Cat("Люська");
        Cat dinka = new Cat("Динка");
    }
    
    public void investigateWorld(){
        try{
            Thread.sleep(200);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public class Cat extends Thread{
        protected Kitten kitten1;
        protected Kitten kitten2;
        public Cat(String name){
            super(name);
            kitten1 = new Kitten("Котенок №1 - мама - " + getName());
            kitten2 = new Kitten("Котенок №2 - мама - " + getName());
            start();
        }
        
        @Override
        public void run(){
            System.out.println(getName() + " - родила двух котят!");
            try{
                initAllKittens();
                kitten1.join();
                kitten2.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(getName() + " : Все котята в коробке. " 
            + getName() + " собрала их назад!");
        }
        
        private void initAllKittens() throws InterruptedException{
            kitten1.start();
            //kitten2.join();
            kitten2.start();
            //kitten2.join();
        }
    }
    
    public class Kitten extends Thread{
        public Kitten(String name){
            super(name);
        }
        
        @Override
        public void run(){
            System.out.println(getName() + " вылез из коробки!");
            investigateWorld();
        }
    }
    
}
