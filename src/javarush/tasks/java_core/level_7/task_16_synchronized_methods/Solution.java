package javarush.tasks.java_core.level_7.task_16_synchronized_methods;

public class Solution {
	private double param = Math.random();
	private StringBuilder stringBuilder = new StringBuilder();

	private void method0() {
		Double d = method3();
	}

	protected void method1(String param1) {
		Solution solution = new Solution();
		solution.method0();
	}

	public void method2(int param1) {
		param1++;
	}

	synchronized double method3() {
		double random = Math.random();
		param += 40.7;
		return param + random;
	}

	private synchronized void method4() {
		stringBuilder.append(1).append(1).append(1).append(1);
	}

	protected void method5(String param2) {
		new StringBuffer().append(param2).append(param2).append(param2);
	}

	public synchronized String method6(int param2) {
		System.out.println("Thinking....");
		method7(5e-2);
		stringBuilder = new StringBuilder("Got it!.");
		return stringBuilder.toString();
	}

	String method7(double param2) {
		return "" + param2;
	}

	public Solution() {

	}
}
