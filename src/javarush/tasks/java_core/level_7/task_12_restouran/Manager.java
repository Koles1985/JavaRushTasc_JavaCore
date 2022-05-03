package javarush.tasks.java_core.level_7.task_12_restouran;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Manager { // Singleton
	
	private static Manager ourInstance = new Manager();
	
	private final List<Table> restaurantTable = new ArrayList<>(10);
	private int currentIndex = 0;
	
	private final Queue<Order> orderQueue = new ConcurrentLinkedQueue<>();
	private final Queue<Dishes> dishesQueue = new ConcurrentLinkedQueue<>();
	
	
	public synchronized static Manager getInstance() {  
		return ourInstance;
	}
	
	private Manager() {
		for(int i = 0; i < 10; i++) {
			restaurantTable.add(new Table());
		}
	}
	
	public synchronized Table getNextTable() {
		//Официант ходит по кругу от 1-го к 10-му столам
		Table table = restaurantTable.get(currentIndex);
		currentIndex = (currentIndex + 1) % 10;
		return table;
	}
	
	public Queue<Order> getOrderQueue(){
		return orderQueue;
	}
	
	public Queue<Dishes> getDishesQueue(){
		return dishesQueue;
	}

}
