package org.acme;

import org.acme.model.DisneyCharacter;
import org.acme.model.WelcomeMessage;
import org.acme.services.DisneyServices;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/disney")
public class  DisneyResource {
    @Inject
    DisneyServices disneyServices;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response hello() {
        return Response.ok(disneyServices.welcome()).build();
    }

    @GET
    @Path("/characters")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCharacters() {
        List<DisneyCharacter> characterList = disneyServices.findAllCharacters();
        if (characterList == null || characterList.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(characterList).build();
    }

    @POST
    @Path("/characters")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCharacter(DisneyCharacter character, @Context UriInfo uriInfo) {
        DisneyCharacter disneyCharacter = disneyServices.addCharacter(character);
        if (disneyCharacter != null) {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(disneyCharacter.getID()));
            return Response.created(uriBuilder.build()).entity(disneyCharacter).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/characters/{ID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCharacterByID(@PathParam("ID") Integer ID) {
        DisneyCharacter disneyCharacter = disneyServices.findByID(ID);
        if (disneyCharacter == null) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(disneyCharacter).build();
    }

    @PUT
    @Path("/characters/{ID}/{newName}/{newGreeting}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCharacter(@PathParam("ID") Integer ID, @PathParam("newName") String newName, @PathParam("newGreeting") String newGreeting) {
        DisneyCharacter newObject = new DisneyCharacter();
        newObject.setName(newName);
        newObject.setGreeting(newGreeting);
        DisneyCharacter disneyCharacter = disneyServices.findByID(ID);
        if (disneyCharacter != null) {
            disneyCharacter.setName(newName);
            disneyCharacter.setGreeting(newGreeting);
            return Response.ok(newObject).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    @DELETE
    @Path("/characters/{ID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteByID(@PathParam("ID") Integer ID){
        DisneyCharacter disneyCharacter = disneyServices.findByID(ID);
        if(disneyCharacter != null){
            disneyServices.delete(ID,disneyCharacter);
            return  Response.ok("Objekt obrisan").build();
        }
        return Response.status(Response.Status.BAD_GATEWAY).build();
    }
}