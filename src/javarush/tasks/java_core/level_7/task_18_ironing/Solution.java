package javarush.tasks.java_core.level_7.task_18_ironing;

public class Solution {

	public Solution() {
		Person diana = new Person("Диана");
		Person igor = new Person("Игорь");

		diana.start();
		igor.start();
	}

	public class Person extends Thread { // человек
		public Person(String name) {
			super(name);
		}

		protected Iron takeIron() {
			System.out.println("Taking the iron");
			return new Iron();
		}

		protected Iron returnIron() {
			System.out.println("Returning the iron");
			return new Iron();
		}

		protected Clothes takeClothes() {
			return new Clothes("T-shirt");
		}

		protected void iron(Iron iron, Clothes clothes) {
			System.out.println(getName() + " is ironing a " + clothes.name);
		}

		@Override
		public void run() {
			synchronized (Iron.class) {
				Iron iron = takeIron();
				Clothes clothes = takeClothes();
				iron(iron, clothes);
				returnIron();
			}
		}
	}

	public class Iron { // Утюг

	}

	public class Clothes {// Одежда
		String name;

		public Clothes(String name) {
			this.name = name;
		}
	}
}
