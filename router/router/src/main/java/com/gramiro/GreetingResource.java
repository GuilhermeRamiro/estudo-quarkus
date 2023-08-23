package com.gramiro;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/router")
public class GreetingResource {

    @Inject
    @RestClient
    TimeService timeService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Counted
    public Response hello() {
        return Response.ok("Router => " + timeService.getTime()).build();
    }
}
