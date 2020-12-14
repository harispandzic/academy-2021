package com.codecta.academy;

import com.codecta.academy.model.DisneyCharacter;
import com.codecta.academy.model.WelcomeMessage;
import com.codecta.academy.services.DisneyCharacterServices;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.awt.*;
import java.util.List;

@Path("/disney")
public class DisneyResource {
    @Inject
    DisneyCharacterServices disneyServices;

    @GET
    @Path("/welcomeMessage")
    @Produces({MediaType.APPLICATION_JSON})
    public Response welcomeMessage(){
        return Response.ok(disneyServices.welcomeMessage()).build();
    }

    @POST
    @Path("/addCharacter")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCharacter(DisneyCharacter character, @Context UriInfo uriInfo){
        DisneyCharacter newCharacter = disneyServices.add(character);
        if(newCharacter != null){
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path((Integer.toString(newCharacter.getID())));
            return Response.created(uriBuilder.build()).entity(newCharacter).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/getAllCharacters")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCharacters(){
        List<DisneyCharacter> characterList = disneyServices.getAll();
        if(characterList == null || characterList.isEmpty()){
            return  Response.noContent().build();
        }
        return Response.ok(characterList).build();
    }

    @GET
    @Path("/getCharacterByID/{ID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCharacterByID(@PathParam("ID") Integer ID){
        DisneyCharacter character = disneyServices.getByID(ID);
        if(character == null){
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(character).build();
    }

    @PUT
    @Path("/updateCharacterByID/{ID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCharacter(@PathParam("ID") Integer ID, DisneyCharacter disneyCharacter){
        DisneyCharacter character = disneyServices.updateCharacter(ID,disneyCharacter);
        if (character == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(character).build();
    }

    @DELETE
    @Path("/deleteCharacterByID/{ID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCharacterbyID(@PathParam("ID") Integer ID){
        boolean brisanje = disneyServices.deleteByID(ID);
        if(brisanje){
            return Response.ok("Objekat obrisan").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
