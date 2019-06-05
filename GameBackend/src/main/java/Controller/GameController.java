package Controller;


import Entity.Roster;
import Service.RosterService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Stateless
@Path("/game")
@Produces({MediaType.APPLICATION_JSON})
public class GameController {

    @Inject
    private RosterService rosterService;

    @GET
    @Path("/roster")
    public Response getCurrentRoster() {
        Roster currentRoster = rosterService.getCurrentRoster();
        return Response.ok(currentRoster).build();
    }

    @PUT
    @Path("/campaign")
    public Response startNewCampaign() {
        Roster roster = rosterService.newCampaign();
        return Response.ok(roster).build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateRoster(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        Roster roster = null;
        try {
            roster = objectMapper.readValue(json, Roster.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (roster != null) {
            return Response.ok(rosterService.updateRoster(roster)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }


}
