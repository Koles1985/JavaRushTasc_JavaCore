package javarush.tasks.java_core.level_7.task_12_restouran;

public class Table {
	
	private static byte tableNumber;
	private byte number = ++tableNumber;

	
	public Order getOrder() {
		return new Order(number);
	}

}
