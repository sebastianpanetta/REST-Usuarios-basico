package com.zvx.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.zvx.rest.models.Nombre;
import com.zvx.rest.models.Usuario;

@Path("/")
public class Service {
	
	@GET
	@Path("/usuario/{user}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response user(@PathParam("user") String usuario) {
		Nombre name = new Nombre(usuario);
		return Response.ok(name).build();
	}

	@POST
	@Path("/validaUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Usuario validaUsuario(Usuario user) {
		user.setUserValido(false);
		if (user.getUsuario().equals("Seba") && user.getPassword().equals("Password")) {
			user.setUserValido(true);
		}
		return user;
	}
	
}
