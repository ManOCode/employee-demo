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
		AuthDTO authDTO = dto.getValue();
		AuthValidator validator = new AuthValidator(authDTO);
		if (!validator.validateUsername()) {

		}
		if (!validator.validatePassword()) {

		}
		String accessToken = sessionService.login(authDTO.getUsername(), authDTO.getPassword());
		if (StringUtils.noValue(accessToken)) {
			return RESPONSE_UNAUTHORIZED;
		} else {
			authDTO.setUsername(null);
			authDTO.setPassword(null);
			authDTO.setAccessToken(accessToken);
		}
		return BUILDER_OK.entity(authDTO).build();
	}

}