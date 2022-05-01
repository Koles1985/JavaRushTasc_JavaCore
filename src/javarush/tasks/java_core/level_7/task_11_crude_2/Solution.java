package javarush.tasks.java_core.level_7.task_11_crude_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Solution {
	public static volatile List<Person> allPeople = new ArrayList<>();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	
	
	static {
		allPeople.add(Person.createMale("Petrov Ivan", new Date()));
		allPeople.add(Person.createFemale("Ivanov Petr", new Date()));
	}
	
	public Solution(String[]arg) {
		
		try {
			whatToDo(arg);
		}catch(ParseException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	private  void whatToDo(String[] args) throws ParseException {
		System.out.println(args[0]);
		
		if(args[0] == null) {
			System.out.printf("Операция %s не сущуствует! Запрос не содержит команд", 
					args[0]);
		}else {
			switch(args[0]) {
				case"-c":
					synchronized(allPeople) {
					addInListAllPeople(args);
					}
					break;
					
				case "-u":
					synchronized(allPeople) {
					updatePeopleFromId(args);
					}
					break;
					
				case "-d":
					synchronized(allPeople) {
						logicDellete(args);
					}
					break;
					
				case "-i":
					synchronized(allPeople){
						printPerson(args);
					}
					break;
				default:
					System.out.printf("Операция %s не найдена! Введите корректный запрос",
							args[0]);
		}
	}
		
	}
	
	
	
	private void addInListAllPeople(String[] args) throws ParseException {
		int count = (args.length - 1) / 3;
		for(int i = 0, j = 1; i < count; i++) {
			String name = args[j++];
			Sex sex = args[j++].equals("м") ? Sex.MALE : Sex.FEMALE;
			Date birthDay = sdf.parse(args[j++]);
			
			Person person = sex == Sex.MALE ? Person.createMale(name, birthDay) :
				Person.createFemale(name, birthDay);
			
			allPeople.add(person);
			System.out.println("id = " + (allPeople.size() - 1) + " ");
			
		}
		
	}
	
	private void updatePeopleFromId(String[]args) throws ParseException {
		int count = (args.length - 1) / 4;
		
		for(int i = 0 ,j = 1; i < count; i ++ ) {
			int id = Integer.parseInt(args[j++]);
			if(id < allPeople.size() && j < args.length) {
				String name = args[j++];
				Sex sex = args[j++].equals("м") ? Sex.MALE : Sex.FEMALE;
				Date date = sdf.parse(args[j++]);
		
				Person person = allPeople.get(id);
				person.setName(name);
				person.setSex(sex);
				person.setBirthDay(date);
			}else {
				System.out.printf("Объекта с таким id - %d. Не существует\n", id);
				j += 3;
			}
		}
	}
	
	private boolean logicDellete(String[] args ) {
		boolean flag = true;
		for(int i = 1; i < args.length; i++) {
			int id = Integer.parseInt(args[i]);
			if(id < allPeople.size()) {
				Person person = allPeople.get(id);
				person.setName(null);
				person.setSex(null);
				person.setBirthDay(null);
			}else {
					System.out.printf("Объекта с таким id - %d. Не существует\n", id);
					flag = false;
			}
		}
		return flag;
	}
	
	private void printPerson(String[] args) {
		for(int i = 1; i < args.length; i++) {
			int id = Integer.parseInt(args[i]);
			if(id < allPeople.size()){
				System.out.println(allPeople.get(id).toString());
			} else {
				System.out.printf("Объекта с таким id - %d. Не существует\n", id);
			}
			
		}
	}
	
}
