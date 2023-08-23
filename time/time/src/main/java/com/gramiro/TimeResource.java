package com.gramiro;

import jakarta.json.Json;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import java.io.ByteArrayInputStream;

@Path("/time")
public class TimeResource {

    private int count = 0;

    @GET
    @Counted
    public Response hello() {
        return Response.ok(getTime() + " - " + count++ + "\n").build() ;
    }

    @Timed
    private String getTime(){
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://worldclockapi.com/api/json/cet/now").request().get();
        String jsonObject = response.readEntity(String.class);
        return Json.createReader(new ByteArrayInputStream(jsonObject.getBytes())).readObject().getString("currentDateTime");
    }
}
