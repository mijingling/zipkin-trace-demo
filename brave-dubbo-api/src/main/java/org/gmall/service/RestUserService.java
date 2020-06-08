package org.gmall.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gmall.bean.UserAddress;

@Path("/user")
public interface RestUserService {
	
	@Path("/get")
	@GET
	@Produces({MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})
	@Consumes({MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})
	public UserAddress getUserAddress();
}
