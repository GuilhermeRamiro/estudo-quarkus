package com.gramiro;

import jakarta.json.Json;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;


import java.io.ByteArrayInputStream;

@Path("/time")
public class TimeResource {


    private String getTime(){
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://worldclockapi.com/api/json/cet/now").request().get();
        String jsonObject = response.readEntity(String.class);
        return Json.createReader(new ByteArrayInputStream(jsonObject.getBytes())).readObject()
                .getString("currentDateTime");
    }
}