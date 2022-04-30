package javarush.tasks.java_core.level_7.task_7_imf;

public class Solution {

	public Solution() {
		IMF fund = IMF.getFund();
		IMF anotherFund = IMF.getFund();
		System.out.println("fund = anotherFund - " + (fund == anotherFund));
	}

}
