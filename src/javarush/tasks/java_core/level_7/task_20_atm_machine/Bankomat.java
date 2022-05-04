package javarush.tasks.java_core.level_7.task_20_atm_machine;

public class Bankomat {
	// private static BigDecimal expence = new BigDecimal(1000);
	static BankAccount account = new BankAccount("Koles");

	public static volatile boolean isStoped;

	public Bankomat() throws InterruptedException {
		addMoney.start();
		SpendThread spendThread = new SpendThread();
		SpendThread spendThread1 = new SpendThread();
		SpendThread spendThread2 = new SpendThread();

		spendThread.start();
		spendThread1.start();
		spendThread2.start();

		Thread.sleep(4000);
		isStoped = true;
	}

	private Thread addMoney = new Thread() {
		@Override
		public void run() {
			while (!isStoped) {
				account.deposit("1000");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	};

	public class SpendThread extends Thread {
		@Override
		public void run() {
			while (!isStoped) {
				try {
					account.widthDraw("100");
				} catch (NotEnoughMoneyException e) {
					System.out.println("Недостаточно денег");
				}

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
					break;
				}
			}
		}
	}

}
