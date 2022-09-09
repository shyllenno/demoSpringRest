package com.openbootcamp.demoSpringRest.controllers;

import com.openbootcamp.demoSpringRest.models.Bootcamper;
import com.openbootcamp.demoSpringRest.services.BootcamperService;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class BootcampersController {

    private final BootcamperService bootcamperService;

    public BootcampersController(BootcamperService bootcamperService) {
        this.bootcamperService = bootcamperService;

        this.bootcamperService.add((new Bootcamper("Leandro")));
        this.bootcamperService.add((new Bootcamper("Luana")));
        this.bootcamperService.add((new Bootcamper("Junior")));
        this.bootcamperService.add((new Bootcamper("Vincent")));
        this.bootcamperService.add((new Bootcamper("Daniela")));
        this.bootcamperService.add((new Bootcamper("Christopher")));
    }

    @GET
    @Path("/bootcampers")
    @Produces("application/json")
    public List<Bootcamper> listerTodos(){
        return bootcamperService.getAll();
    }

    @GET
    @Path("/bootcampers/{nombre}")
    @Produces("application/json")
    public Bootcamper listarUno(@PathParam("nombre") String nombre){
        return bootcamperService.get(nombre);
    }

    @POST
    @Path("/bootcampers")
    @Produces("application/json")
    @Consumes("application/json")
    public Response meterBootcamper(Bootcamper bootcamper){
        bootcamperService.add(bootcamper);
        return Response.created(
                URI.create("/bootcampers/" + bootcamper.getNombre())
        ).build();
    }

    @PATCH
    @Path("/{nombre}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response atualizarBootcamper(@PathParam("nombre") String nombre, String nuevoNombre) {
        if (bootcamperService.update(nombre, nuevoNombre)) {
            return Response.status(200).entity("User updated").build();
        } else {
            return Response.status(200).entity("User not updated").build();
        }
    }

    @DELETE
    @Path("/{nombre}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response deleteBootcamper(@PathParam("nombre") String nombre) {

        if (bootcamperService.delete(nombre)) {
            return Response.status(200)
                    .entity("User deleted").build();
        } else {
            return Response.status(200)
                    .entity("User not deleted").build();
        }
    }

}
