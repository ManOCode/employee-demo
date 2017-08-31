package moc.employee.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

@Path("/api/auth")
public interface AuthResource {

	public static final String PARAM_TOKEN = "Access_Token";

	public static final String PATH_AUTH = "/";

	@POST
	@Path(PATH_AUTH)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response authorise(JAXBElement<AuthDTO> dto);

}