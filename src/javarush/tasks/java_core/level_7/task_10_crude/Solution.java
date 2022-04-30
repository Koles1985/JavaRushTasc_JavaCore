package javarush.tasks.java_core.level_7.task_10_crude;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Solution {

	public static List<Person> allPeople = new ArrayList<>();

	static {
		allPeople.add(Person.createMale("Petrov Ivan", new Date()));
		allPeople.add(Person.createFemale("Ivanov Petr", new Date()));
	}

	public Solution(String[] args) {
		setArgs(args);
	}

	private void setArgs(String[] arg) {
		int id = -1;
		if (arg.length != 0 && arg[0] != null) {
			if (arg.length > 4 || arg.length < 3)
				id = Integer.parseInt(arg[1]);
			switch (arg[0]) {
			case "-c":
				System.out.println(addPeople(arg));
				break;
			case "-r":
				printPersonFromID(id);
				break;
			case "-u":
				setValuePerson(id, arg);
				break;
			case "-d":
				removePerson(id);
			}
		}
	}

	private int addPeople(String[] arg) {
		String name = arg[1];
		Sex sex = arg[2].equals("м") ? Sex.MALE : Sex.FEMALE;
		Date db = convertStringToDate(arg[3]);

		allPeople.add(new Person(name, sex, db));

		return allPeople.size() - 1;
	}

	@SuppressWarnings("deprecation")
	private Date convertStringToDate(String stringDate) {
		String[] temp = stringDate.split("/");
		int day = Integer.parseInt(temp[0]);
		int month = Integer.parseInt(temp[1]);
		int year = Integer.parseInt(temp[2]);

		return new Date(year, month, day);
	}

	private void printPersonFromID(int id) {
		if (id >= 0 && id < allPeople.size())
			System.out.println(allPeople.get(id));
		else
			System.out.println("Out of bounds exception!");

	}

	private void setValuePerson(int id, String[] args) {
		String name = args[2];
		Sex sex = args[3].equals("м") ? Sex.MALE : Sex.FEMALE;

		Date birthDate = convertStringToDate(args[4]);

		updatePerson(id, name, sex, birthDate);

	}

	private void updatePerson(int id, String name, Sex sex, Date date) {
		Person person = allPeople.get(id);
		person.setName(name);
		person.setSex(sex);
		person.setBirthDate(date);
	}

	private void removePerson(int id) {
		updatePerson(id, null, null, null);
	}
}
