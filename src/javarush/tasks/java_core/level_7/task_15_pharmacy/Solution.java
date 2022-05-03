package javarush.tasks.java_core.level_7.task_15_pharmacy;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static DrugsController drugController = new DrugsController();
	public static boolean isStoped = false;
	public Solution() throws InterruptedException {
		Thread apteka = new Thread(new Apteka(), "Аптека");
		Thread man = new Thread(new Person(), "Мужчина");
		Thread woman = new Thread(new Person(), "Женщина");
		
		apteka.start();
		man.start();
		woman.start();
		
		Thread.sleep(1000);
		isStoped = true;
	}
	
	public class Apteka implements Runnable{
		@Override
		public void run() {
			while (!isStoped) {
				drugController.sell(getRandomDrug(), getRandomCount());
				for(int i = 0; i < 3; i++)
					waitAMoment();
			}
		}
	}
	
	public class Person implements Runnable{
		@Override
		public void run() {
			while(!isStoped) {
				drugController.buy(getRandomDrug(), getRandomCount());
				waitAMoment();
			}
		}
	}
	
	public int getRandomCount() {
		return (int)(Math.random() * 3) + 1;
	}
	
	public Drug getRandomDrug() {
		int index = (int)(Math.random() * 1000) % (DrugsController.allDrugs.size());
		List<Drug> drugs = new ArrayList<>(DrugsController.allDrugs.keySet());
		return drugs.get(index);
	}
	
	private void waitAMoment() {
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	

}
