package dev.vladflore.javaeezerotohero.resource;

import dev.vladflore.javaeezerotohero.service.NasaService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("nasa")
public class NasaResource {

    @Inject
    private NasaService nasaService;

    @GET
    @Path("apod")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveApod() {
        return Response.ok(nasaService.retrieveApod()).build();
    }
}
