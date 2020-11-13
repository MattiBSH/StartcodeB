/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import DTOs.SpeciesDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.SpeciesFacade;
import java.io.IOException;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author matti
 */
@Path("species")
public class MyOwnResource {

    @Context
    private UriInfo context;
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final SpeciesFacade FACADE = SpeciesFacade.getUserFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    /**
     * Creates a new instance of GenericResource
     */
    public MyOwnResource() {
    }

    //gets all species
    @GET
    @Path("all")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public String allSpecies() { 
        List<SpeciesDTO> allSpecies = FACADE.getAllSpecies();
        return GSON.toJson(allSpecies);
    }
    //add species
    @POST
    @Path("/add")
    @RolesAllowed("admin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addSpecies(String species) throws IOException{
        SpeciesDTO personDTO = GSON.fromJson(species, SpeciesDTO.class);
        SpeciesDTO dto = FACADE.addSpecies(personDTO);
        return GSON.toJson(dto);
    }

    //gets By ID
    
    @GET
    @Path("id/{id}")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public String oneSpecies(@PathParam("id") int id) throws IOException {
        SpeciesDTO s=FACADE.getSpeciesById(id);
        return GSON.toJson(s);
    }
    
    
}
