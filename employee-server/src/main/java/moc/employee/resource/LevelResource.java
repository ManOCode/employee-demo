package moc.employee.resource;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

@Path("/api/level")
public interface LevelResource extends Resource {

	@BadgerFish
	@GET
	@Path(PATH_ROOT)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response levelList(@HeaderParam(AuthResource.PARAM_TOKEN) String token);
}