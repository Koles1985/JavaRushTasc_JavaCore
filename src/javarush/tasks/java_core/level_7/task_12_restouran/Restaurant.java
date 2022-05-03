package javarush.tasks.java_core.level_7.task_12_restouran;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	public static List<Thread> threads = new ArrayList<>();
	
	
	public Restaurant() throws Exception {
		Waiter waiterTarget = new Waiter();
		Thread waiter = new Thread(waiterTarget);
		threads.add(waiter);
		
		Cook cookTarget = new Cook();
		Thread cook = new Thread(cookTarget);
		threads.add(cook);
		
		waiter.start();
		cook.start();
		
		Thread.sleep(2000);
		cookTarget.continueWorking = false;
		Thread.sleep(500);
		waiterTarget.continueWorking = false;
		
	}

}
