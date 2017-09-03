package moc.employee.resource;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moc.employee.service.ManagerService;
import moc.employee.service.SessionService;

@Service
public class LevelResourceImpl implements LevelResource {

	@Autowired
	SessionService sessionService;

	@Autowired
	ManagerService managerService;

	@Override
	public Response levelList(String token) {
		if (!sessionService.hasAccess(token)) {
			return RESPONSE_UNAUTHORIZED;
		}
		List<LevelDTO> dtos = managerService.levelList();
		return BUILDER_OK.entity(dtos).build();
	}

}