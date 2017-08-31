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

@Path("/api/employee")
public interface EmployeeResource {

	public static final String PATH_LIST = "/";

	public static final String PATH_CREATE = "/create";

	public static final String PATH_READ = "/{id}";

	public static final String PATH_UPDATE = "/update";

	public static final String PATH_DELETE = "/delete";

	@GET
	@Path(PATH_LIST)
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response employeeList(@HeaderParam(AuthResource.PARAM_TOKEN) String token);

	@POST
	@Path(PATH_CREATE)
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response employeeCreate(@HeaderParam(AuthResource.PARAM_TOKEN) String token, JAXBElement<EmployeeDTO> dto);

	@GET
	@Path(PATH_READ)
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response employeeRead(@HeaderParam(AuthResource.PARAM_TOKEN) String token,
			@PathParam("id") String employeeId);

	@POST
	@Path(PATH_UPDATE)
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response employeeUpdate(@HeaderParam(AuthResource.PARAM_TOKEN) String token, JAXBElement<EmployeeDTO> dto);

	@DELETE
	@Path(PATH_DELETE)
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response employeeDelete(@HeaderParam(AuthResource.PARAM_TOKEN) String token, JAXBElement<EmployeeDTO> dto);

}