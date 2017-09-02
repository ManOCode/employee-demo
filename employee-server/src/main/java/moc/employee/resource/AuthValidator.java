package moc.employee.resource;

import moc.employee.util.StringUtils;

public final class AuthValidator {

	private AuthDTO dto;

	public AuthValidator(AuthDTO dto) {
		this.dto = dto;
	}

	public boolean validateUsername() {
		try {
			return StringUtils.hasValue(dto.getUsername());
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validatePassword() {
		try {
			return StringUtils.hasValue(dto.getPassword());
		} catch (Exception e) {
			return false;
		}
	}
}