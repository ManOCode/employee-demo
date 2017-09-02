package moc.employee.resource;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moc.employee.service.ManagerService;
import moc.employee.service.SessionService;

@Service
public class EmployeeResourceImpl implements EmployeeResource {

	@Autowired
	SessionService sessionService;

	@Autowired
	ManagerService managerService;

	@Override
	public Response employeeList(String token) {
		if (!sessionService.hasAccess(token)) {
			return RESPONSE_UNAUTHORIZED;
		}
		List<EmployeeDTO> employeeList = managerService.employeeList();
		return BUILDER_OK.entity(employeeList).build();
	}

	@Override
	public Response employeeCreate(String token, JAXBElement<EmployeeDTO> dto) {
		if (!sessionService.hasAccess(token)) {
			return RESPONSE_UNAUTHORIZED;
		}
		EmployeeDTO employeeDTO = dto.getValue();
		List<LevelDTO> levels = managerService.levelList();
		EmployeeValidator validator = new EmployeeValidator(employeeDTO, levels);
		if (!validator.validateName()) {
			return RESPONSE_BADREQUEST_NAME;
		}
		if (!validator.validateSurname()) {
			return RESPONSE_BADREQUEST_SURNAME;
		}
		if (!validator.validateLevel()) {
			return RESPONSE_BADREQUEST_LEVEL;
		}
		if (!validator.validateDateOfBirth()) {
			return RESPONSE_BADREQUEST_DOB;
		}
		if (!validator.validateAge()) {
			return RESPONSE_BADREQUEST_AGE;
		}
		employeeDTO = managerService.employeeCreate(employeeDTO);
		return BUILDER_OK.entity(employeeDTO).build();
	}

	@Override
	public Response employeeRead(String token, String employeeId) {
		if (!sessionService.hasAccess(token)) {
			return RESPONSE_UNAUTHORIZED;
		}
		EmployeeDTO dto = new EmployeeDTO();
		dto.setId(employeeId);
		EmployeeValidator validator = new EmployeeValidator(dto, null);
		if (!validator.validateId()) {
			return RESPONSE_BADREQUEST_ID;
		}
		dto = managerService.employee(dto);
		return BUILDER_OK.entity(dto).build();
	}

	@Override
	public Response employeeUpdate(String token, JAXBElement<EmployeeDTO> dto) {
		if (!sessionService.hasAccess(token)) {
			return RESPONSE_UNAUTHORIZED;
		}
		EmployeeDTO employeeDTO = dto.getValue();
		List<LevelDTO> levels = managerService.levelList();
		EmployeeValidator validator = new EmployeeValidator(employeeDTO, levels);
		if (!validator.validateId()) {
			return RESPONSE_BADREQUEST_ID;
		}
		if (!validator.validateName()) {
			return RESPONSE_BADREQUEST_NAME;
		}
		if (!validator.validateSurname()) {
			return RESPONSE_BADREQUEST_SURNAME;
		}
		if (!validator.validateLevel()) {
			return RESPONSE_BADREQUEST_LEVEL;
		}
		if (!validator.validateDateOfBirth()) {
			return RESPONSE_BADREQUEST_DOB;
		}
		if (!validator.validateAge()) {
			return RESPONSE_BADREQUEST_AGE;
		}
		employeeDTO = managerService.employeeUpdate(employeeDTO);
		return BUILDER_OK.entity(employeeDTO).build();
	}

	@Override
	public Response employeeDelete(String token, JAXBElement<EmployeeDTO> dto) {
		if (!sessionService.hasAccess(token)) {
			return RESPONSE_UNAUTHORIZED;
		}
		EmployeeDTO employeeDTO = dto.getValue();
		EmployeeValidator validator = new EmployeeValidator(employeeDTO, null);
		if (!validator.validateId()) {
			return RESPONSE_BADREQUEST_ID;
		}
		employeeDTO = managerService.employeeDelete(employeeDTO);
		return BUILDER_OK.entity(employeeDTO).build();
	}
}