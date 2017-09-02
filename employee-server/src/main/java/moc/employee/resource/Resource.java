package moc.employee.resource;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

public interface Resource {
	/**
	 * RESPONSE RESOURCES
	 */
	public static final Response RESPONSE_UNAUTHORIZED = Response.status(401).build();
	public static final Response RESPONSE_BADREQUEST_USERNAME = Response.status(400).entity("Username is required.")
			.build();
	public static final Response RESPONSE_BADREQUEST_PASSWORD = Response.status(400).entity("Password is required.")
			.build();
	public static final Response RESPONSE_BADREQUEST_ID = Response.status(400)
			.entity("Id is required and must exist on Employee-Demo.").build();
	public static final Response RESPONSE_BADREQUEST_NAME = Response.status(400)
			.entity("Name is required and must be within 50 characters.").build();
	public static final Response RESPONSE_BADREQUEST_SURNAME = Response.status(400)
			.entity("Suranme is required and must be within 80 characters.").build();
	public static final Response RESPONSE_BADREQUEST_LEVEL = Response.status(400)
			.entity("Level is required and must be either Junior, Senior or Manager.").build();
	public static final Response RESPONSE_BADREQUEST_DOB = Response.status(400)
			.entity("Date of birth is required and must be in the format yyyy/MM/dd.").build();
	public static final Response RESPONSE_BADREQUEST_AGE = Response.status(400)
			.entity("Age is required and must sync with Date of Birth.").build();
	public static final ResponseBuilder BUILDER_OK = Response.ok();

	/**
	 * PATH RESOURCES
	 */
	public static final String PATH_ROOT = "/";
	public static final String PATH_CREATE = "/create";
	public static final String PATH_ID = "/{id}";
	public static final String PATH_UPDATE = "/update";
	public static final String PATH_DELETE = "/delete";

	/**
	 * PARAMETER RESOURCES
	 */
	public static final String PARAM_TOKEN = "Access_Token";
	public static final String PARAM_ID = "id";
}