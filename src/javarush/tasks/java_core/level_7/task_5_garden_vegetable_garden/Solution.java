package javarush.tasks.java_core.level_7.task_5_garden_vegetable_garden;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public Solution() {

	}

	public class Garden {

		public final List<String> fruits = new ArrayList<>();
		public final List<String> vegatables = new ArrayList<>();

		public synchronized void addFruit(int index, String fruit) {
			fruits.add(index, fruit);
		}

		public synchronized void removeFruit(int index) {
			fruits.remove(index);
		}

		public synchronized void addVegatable(int index, String vegatable) {
			vegatables.add(index, vegatable);
		}

		public synchronized void removeVegatable(int index) {
			vegatables.remove(index);
		}

	}

}
