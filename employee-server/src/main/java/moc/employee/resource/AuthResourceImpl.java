package moc.employee.resource;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moc.employee.service.SessionService;
import moc.employee.util.StringUtils;

@Service
public class AuthResourceImpl implements AuthResource {

	@Autowired
	SessionService sessionService;

	@Override
	public Response authorise(JAXBElement<AuthDTO> dto) {
		AuthDTO auth = dto.getValue();
		String accessToken = sessionService.login(auth.getUsername(), auth.getPassword());
		if (StringUtils.noValue(accessToken)) {
			return RESPONSE_UNAUTHORIZED;
		} else {
			auth.setUsername(null);
			auth.setPassword(null);
			auth.setAccessToken(accessToken);
		}
		return Response.ok(auth).build();
	}

}