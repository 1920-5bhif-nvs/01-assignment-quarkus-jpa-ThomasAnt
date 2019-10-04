package at.htl.rest;

import at.htl.model.Graveyard;
import at.htl.service.GraveyardService;
import com.oracle.svm.core.annotate.Delete;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/graveyard")
public class GraveyardEndpoint {

    @Inject
    GraveyardService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getAll (){
        return Response.ok(service.getAll()).build();
    }

    @GET
    @Path("{location}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getByLocation(@PathParam("location")String location){
        return Response.ok(service.get(location)).build();
    }

    @POST
    @Path("/new")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertCar(Graveyard graveyard) {
        service.add(graveyard);
        return Response.ok().entity(graveyard).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public  Response delete(@PathParam("id")long id){
        try{
            service.delete(id);
            return Response.ok().build();
        }
        catch (Exception e){
            return Response.status(404).build();
        }
    }
}
