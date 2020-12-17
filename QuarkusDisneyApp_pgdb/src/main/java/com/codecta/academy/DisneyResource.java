package com.codecta.academy;

import com.codecta.academy.services.DisneyCharacterServices;
import com.codecta.academy.services.model.CharacterDto;
import com.codecta.academy.services.model.ParkDto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/disney")
public class DisneyResource {
    public  class Poruka{
        public String kod;
        public String poruka;

        public Poruka(String kod, String poruka) {
            this.kod = kod;
            this.poruka = poruka;
        }
    }
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
    public Response addCharacter(CharacterDto character, @Context UriInfo uriInfo){
        CharacterDto newCharacter = disneyServices.add(character);
        if(newCharacter != null){
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path((Integer.toString(newCharacter.getID())));
            return Response.created(uriBuilder.build()).entity(newCharacter).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(new Poruka("43 LINIJA","Ne mozes dodati karakter koji nije u nekom team parku")).build();
    }

    @GET
    @Path("/getAllCharacters")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCharacters(){
        List<CharacterDto> characterList = disneyServices.getAll();
        if(characterList == null || characterList.isEmpty()){
            return  Response.noContent().build();
        }
        return Response.ok(characterList).build();
    }

    @GET
    @Path("/getCharacterByID/{ID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCharacterByID(@PathParam("ID") Integer ID){
        CharacterDto character = disneyServices.getByID(ID);
        if(character == null){
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(character).build();
    }

    @PUT
    @Path("/updateCharacterByID/{ID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCharacter(@PathParam("ID") Integer ID, CharacterDto disneyCharacter){
        CharacterDto character = disneyServices.updateCharacter(ID,disneyCharacter);
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

    @POST
    @Path("/addThemePark")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addThemePark(ParkDto park, @Context UriInfo uriInfo){
        ParkDto newPark = disneyServices.addThemePark(park);
        if(newPark != null){
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path((Integer.toString(newPark.getID())));
            return Response.created(uriBuilder.build()).entity(newPark).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(new Poruka("100 LINIJA","NEKI ERROR MESSAGE!")).build();
    }
    @GET
    @Path("/getAllThemeParks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllThemeParks(){
        List<ParkDto> parkList = disneyServices.findAllThemeParks();
        if(parkList == null || parkList.isEmpty()){
            return  Response.noContent().build();
        }
        return Response.ok(parkList).build();
    }

    @GET
    @Path("/getParkByID/{ID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParkByID(@PathParam("ID") Integer ID){
        ParkDto park = disneyServices.findThemeParkByID(ID);
        if(park == null){
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(park).build();
    }
    @GET
    @Path("/getCharactersByParkID/{id}/characters")//???
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCharactersByParkID(@PathParam("id") Integer id){
        List<CharacterDto> characterDtoList = disneyServices.findCharactersByParkID(id);
        if(characterDtoList == null){
            return Response.noContent().build();
        }
        return Response.ok(characterDtoList).build();
    }
    @GET
    @Path("/getParksByCharacterName")//???
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParksByCharacterName(@QueryParam("name") String name){
        List<ParkDto> parkDtoList = disneyServices.findParksByCharacterName(name);
        if(parkDtoList == null){
            return Response.noContent().build();
        }
        return Response.ok(parkDtoList).build();
    }
}
