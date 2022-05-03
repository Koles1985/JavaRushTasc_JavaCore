package javarush.tasks.java_core.level_7.task_12_restouran;

public class Waiter implements Runnable {
	public boolean continueWorking = true;
	
	@Override
	public void run() {
		Manager manager = Manager.getInstance();
		
		while(continueWorking || !manager.getDishesQueue().isEmpty()) {
			if(!manager.getDishesQueue().isEmpty()) { // относим готовый заказ
				Dishes dishes = manager.getDishesQueue().poll();
				System.out.printf("Официант отнес заказ для стола №%d\n", dishes.getTableNumber());
			}else {//берем новый заказ
				Table table = manager.getNextTable();
				Order order = table.getOrder();
				System.out.printf("Получен заказ от стола №%d\n", order.getTableNumber());
				manager.getOrderQueue().add(order);
			}
			try {
				Thread.sleep(100);  // переход к следующему столику
			}catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
