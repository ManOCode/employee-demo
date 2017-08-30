package moc.employee.model;

import java.util.Calendar;
import java.util.Date;

public class Employee {

	private Long id;

	private String name;

	private String surname;

	private Level level;

	private Date dateOfBirth;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getDateOfBirthAge() {
		Calendar now = Calendar.getInstance();
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.setTime(getDateOfBirth());
		int result = now.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		now.add(Calendar.YEAR, -result);
		if (dateOfBirth.before(now)) {
			return result - 1;
		}
		return result;
	}

}