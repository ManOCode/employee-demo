package moc.employee.resource;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Service;

@Service
public class AuthResourceImpl implements AuthResource {

	@Override
	public Response authorise(JAXBElement<AuthDTO> dto) {
		return null;
	}

}