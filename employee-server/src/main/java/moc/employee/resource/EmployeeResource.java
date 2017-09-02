package moc.employee.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

@Path("/api/employee")
public interface EmployeeResource extends Resource {

	@BadgerFish
	@GET
	@Path(PATH_ROOT)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response employeeList(@HeaderParam(AuthResource.PARAM_TOKEN) String token);

	@BadgerFish
	@POST
	@Path(PATH_CREATE)
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response employeeCreate(@HeaderParam(AuthResource.PARAM_TOKEN) String token, JAXBElement<EmployeeDTO> dto);

	@BadgerFish
	@GET
	@Path(PATH_ID)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response employeeRead(@HeaderParam(AuthResource.PARAM_TOKEN) String token,
			@PathParam(PARAM_ID) String employeeId);

	@BadgerFish
	@POST
	@Path(PATH_UPDATE)
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response employeeUpdate(@HeaderParam(AuthResource.PARAM_TOKEN) String token, JAXBElement<EmployeeDTO> dto);

	@BadgerFish
	@DELETE
	@Path(PATH_DELETE)
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response employeeDelete(@HeaderParam(AuthResource.PARAM_TOKEN) String token, JAXBElement<EmployeeDTO> dto);

}