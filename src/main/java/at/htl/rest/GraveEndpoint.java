package at.htl.rest;

import at.htl.service.GraveService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/grave")
public class GraveEndpoint {

    @Inject
    GraveService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("/fetchType")
    public Response getGraveWithFetchType (){
        return Response.ok(service.getWithFetchType()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("/entityGraph")
    public Response getGraveWithEntityGraph (){
        return Response.ok(service.getWithEntityGraph()).build();
    }
}
