package com.gramiro;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@RegisterRestClient(baseUri = "http://localhost:8080/time")
public interface TimeService {

    @Path("/")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTime();
}
