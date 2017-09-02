package moc.employee.resource;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moc.employee.service.SessionService;

@Service
public class LevelResourceImpl implements LevelResource {

	@Autowired
	SessionService sessionService;

	@Override
	public Response levelList(String token) {
		if (!sessionService.hasAccess(token)) {
			return AuthResource.RESPONSE_UNAUTHORIZED;
		}
		return null;
	}

}