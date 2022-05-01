package javarush.tasks.java_core.level_7.task_11_crude_2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Person {
	
	private String name;
	private Sex sex;
	private Date birthDay;

	public Person(String name, Sex sex, Date birthDay) {
		this.name = name;
		this.sex = sex;
		this.birthDay = birthDay;
	}
	
	public static Person createMale(String name, Date date) {
		return new Person(name, Sex.MALE, date);
	}
	
	public static Person createFemale(String name, Date birthDay) {
		return new Person(name, Sex.FEMALE, birthDay);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		SimpleDateFormat simpleDF = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		return "Person [" + name + " " + sex + " " + simpleDF.format(birthDay) + "]";
	}
	
}
