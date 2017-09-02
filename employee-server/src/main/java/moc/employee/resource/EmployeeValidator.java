package moc.employee.resource;

import java.util.Date;
import java.util.List;

import moc.employee.util.DateUtils;
import moc.employee.util.StringUtils;

public final class EmployeeValidator {

	private EmployeeDTO dto;

	private List<LevelDTO> levels;

	public EmployeeValidator(EmployeeDTO dto, List<LevelDTO> levels) {
		this.dto = dto;
		this.levels = levels;
	}

	public boolean validateId() {
		try {
			return StringUtils.hasValue(dto.getId()) && Long.parseLong(dto.getId()) != 0L;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validateName() {
		try {
			return StringUtils.hasValue(dto.getName()) && StringUtils.withinLength(dto.getName(), 50);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validateSurname() {
		try {
			return StringUtils.hasValue(dto.getSurname()) && StringUtils.withinLength(dto.getSurname(), 80);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validateLevel() {
		try {
			for (LevelDTO level : levels) {
				if (dto.getLevel().equals(level.getId()) || dto.getLevel().equals(level.getDescription())) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validateDateOfBirth() {
		try {
			return DateUtils.dateFormat(dto.getDateOfBirth()) != null;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validateAge() {
		try {
			Date date = DateUtils.dateFormat(dto.getDateOfBirth());
			int age = Integer.parseInt(dto.getAge());
			return DateUtils.dateYears(date) == age;
		} catch (Exception e) {
			return false;
		}
	}
}