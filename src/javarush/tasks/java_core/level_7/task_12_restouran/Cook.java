package javarush.tasks.java_core.level_7.task_12_restouran;

public class Cook implements Runnable {
	public boolean continueWorking = true;
	
	@Override
	public void run() {
		boolean needToWait;
		while(continueWorking || needToCookOrders()) {
			try {
				synchronized(this) {
					needToWait = !needToCookOrders();
					if(!needToWait) {
						cook();
					}
				}
				if(continueWorking && needToWait) {
					System.out.println("Повар отдыхает");
					Thread.sleep(100);
				}
			}catch(InterruptedException e) {
				
			}
		}
	}
	
	private boolean needToCookOrders() {
		return !Manager.getInstance().getOrderQueue().isEmpty();
	}
	private void cook() throws InterruptedException {
		Manager manager = Manager.getInstance();
		Order order = manager.getOrderQueue().poll();//Повар берет заказ из очереди
		System.out.printf("Заказ будет готовиться %d мс для стола #%d\n", order.getTime(),
				order.getTableNumber());
		Thread.sleep(order.getTime());//готовим блюдо
		Dishes dishes = new Dishes(order.getTableNumber());// Это готовое блюдо
		System.out.printf("Заказ для стола %d готов\n", dishes.getTableNumber());
		manager.getDishesQueue().add(dishes);
		
	}

}
