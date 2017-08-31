package moc.employee.resource;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Service;

@Service
public class EmployeeResourceImpl implements EmployeeResource {

	@Override
	public Response employeeList(String token) {
		return null;
	}

	@Override
	public Response employeeCreate(String token, JAXBElement<EmployeeDTO> dto) {
		return null;
	}

	@Override
	public Response employeeRead(String token, String employeeId) {
		return null;
	}

	@Override
	public Response employeeUpdate(String token, String employeeId, JAXBElement<EmployeeDTO> dto) {
		return null;
	}

	@Override
	public Response employeeDelete(String token, String employeeId, JAXBElement<EmployeeDTO> dto) {
		return null;
	}

}