/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entities.dto.CategoryDTO;
import entities.dto.JokesDTO;
import facades.ApiFacade;
import facades.RequestFacade;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author Martin Frederiksen
 */
@Path("jokeByCategory")
public class JokeByCategory {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/Examprep2",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final RequestFacade facade = RequestFacade.getRequestFacade(EMF);
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "{\"msg\": \"Welcome to the Jokes API!\"}";
    }
    
    @GET
    @Path("{categories}")
    @Produces(MediaType.APPLICATION_JSON)
    public JokesDTO getJsonList(@PathParam("categories") String categories) {
        ApiFacade af = new ApiFacade();
        String url = "https://api.chucknorris.io/jokes/random?category=";
        List<String> categoriesList = Arrays.asList(categories.split(","));
        if(categoriesList.size() > 4) {
            throw new WebApplicationException("Only a maximum of 4 categories allowed");
        }
        try {
            List<CategoryDTO> categoriesDTO = new ArrayList();
            for(String s : categoriesList) {
                categoriesDTO.add(facade.getCategoryByName(s));
            }
            //facade.createRequest(categoriesDTO);
            //for(CategoryDTO c : categoriesDTO) {
                //c.setRequests(null);
            //}
            return af.fetch(url, categoriesDTO);
        } catch(NoResultException ex) {
            throw new WebApplicationException("No category found");
        }
    }

}
