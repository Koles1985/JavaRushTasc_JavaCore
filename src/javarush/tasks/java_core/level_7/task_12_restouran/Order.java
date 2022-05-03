package javarush.tasks.java_core.level_7.task_12_restouran;

public class Order {
	
	private long time;
	private byte tableNumber;

	public Order(byte tableNumber) {
		time = (long)(Math.random() * 200);
		this.tableNumber = tableNumber;
	}
	
	public long getTime() {
		return time;
	}
	
	public byte getTableNumber() {
		return tableNumber;
	}

}
