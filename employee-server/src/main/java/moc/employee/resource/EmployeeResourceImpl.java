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
			return AuthResource.RESPONSE_UNAUTHORIZED;
		}
		List<EmployeeDTO> employeeList = managerService.employeeList();
		return Response.ok(employeeList).build();
	}

	@Override
	public Response employeeCreate(String token, JAXBElement<EmployeeDTO> dto) {
		if (!sessionService.hasAccess(token)) {
			return AuthResource.RESPONSE_UNAUTHORIZED;
		}
		return null;
	}

	@Override
	public Response employeeRead(String token, String employeeId) {
		if (!sessionService.hasAccess(token)) {
			return AuthResource.RESPONSE_UNAUTHORIZED;
		}
		return null;
	}

	@Override
	public Response employeeUpdate(String token, JAXBElement<EmployeeDTO> dto) {
		if (!sessionService.hasAccess(token)) {
			return AuthResource.RESPONSE_UNAUTHORIZED;
		}
		return null;
	}

	@Override
	public Response employeeDelete(String token, JAXBElement<EmployeeDTO> dto) {
		if (!sessionService.hasAccess(token)) {
			return AuthResource.RESPONSE_UNAUTHORIZED;
		}
		return null;
	}

}