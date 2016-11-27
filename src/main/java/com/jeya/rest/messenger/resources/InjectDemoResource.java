package com.jeya.rest.messenger.resources;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	// matrix param test url
	// http://localhost:8080/messenger/webapi/injectdemo/annotations;param=value
	// header param is useful for authentication kind of things
	// @FormParam
	// need to check how to create and send cookie
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParamValue, 
			@HeaderParam("customHeaderName") String headerValue,
			@HeaderParam("authSessionID") String tokenValue,
			@CookieParam("name") String name)
	{
		return "matrixParamValue: " + matrixParamValue + "; customHeaderValue: " + headerValue +
				"authSessionID to be validated: " + tokenValue + "; cookie: " + name;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers)
	{
		System.out.println(uriInfo.getAbsolutePath().toString());
		System.out.println(headers.getLength());
		Map<?, ?> map = uriInfo.getQueryParameters();
		// from this we can get query params
		MultivaluedMap<String,String> map2 = uriInfo.getPathParameters();
		return (String) map.get("haiyo");
	}
}
