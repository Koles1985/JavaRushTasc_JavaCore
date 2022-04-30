package javarush.tasks.java_core.level_7.task_6_synchronized_president;

public class OurPresident {
	private static OurPresident president;

	static {
		synchronized (OurPresident.class) {
			if (president == null)
				president = new OurPresident();
		}

	}

	private OurPresident() {

	}

	public static OurPresident getOurPresident() {
		return president;
	}

}
