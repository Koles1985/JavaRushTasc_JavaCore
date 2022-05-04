package javarush.tasks.java_core.level_7.task_20_atm_machine;

import java.math.BigDecimal;

public class BankAccount {
	private volatile BigDecimal balance;
	private String owner;

	public BankAccount(String owner) {
		this(BigDecimal.ZERO, owner);
	}

	public BankAccount(BigDecimal balance, String owner) {
		this.balance = balance;
		this.owner = owner;
	}

	public synchronized void deposit(BigDecimal money) {
		BigDecimal newBalance = balance.add(money);
		System.out.println("Добавляем " + money + " на счету " + newBalance);
		balance = newBalance;
	}

	public synchronized void widthDraw(BigDecimal money) throws NotEnoughMoneyException {
		BigDecimal newBalance = balance.subtract(money);

		if (newBalance.compareTo(BigDecimal.ZERO) < 0)
			throw new NotEnoughMoneyException();

		balance = newBalance;
		System.out.println("Тратим " + money + " , на счету " + balance);
	}

	public void deposit(String money) {
		deposit(new BigDecimal(money));
	}

	public void widthDraw(String money) throws NotEnoughMoneyException {
		widthDraw(new BigDecimal(money));
	}
}
