package javarush.tasks.java_core.level_7.task_7_imf;

public class IMF {

	private static IMF imf;

	public static IMF getFund() {
		synchronized (IMF.class) {
			if (imf == null)
				imf = new IMF();
		}
		return imf;
	}

	private IMF() {

	}

}
