package javarush.tasks.java_core.level_7.task_19_aplication_context;

import java.util.HashMap;
import java.util.Map;

public abstract class AplicationContext<GenericsBean extends Bean> {
	private Map<String, GenericsBean> container = new HashMap<>();
	// Map<Name, some class that implements the Bean interface>

	protected AplicationContext() {
		parseAllClassesAndInterfaces();
	}

	public synchronized GenericsBean getByName(String name) {
		return container.get(name);
	}

	public synchronized GenericsBean removeByName(String name) {
		return container.remove(name);
	}

	protected abstract void parseAllClassesAndInterfaces();

}
