package javarush.tasks.java_core.level_7.task_10_crude;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Person {

	private String name;
	private Sex sex;
	private Date birthDate;

	public Person(String name, Sex sex, Date birthDate) {
		this.name = name;
		this.sex = sex;
		this.birthDate = birthDate;
	}

	public static Person createMale(String name, Date birthDate) {
		return new Person(name, Sex.MALE, birthDate);
	}

	public static Person createFemale(String name, Date birthDate) {
		return new Person(name, Sex.FEMALE, birthDate);
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
		char sex = this.sex == Sex.MALE ? 'м' : 'ж';
		return name + " " + sex + " " + simpleDateFormat.format(birthDate);
	}

}
