package rest;

import entities.dto.CategoryDTO;
import entities.dto.JokesDTO;
import facades.ApiFacade;
import facades.RequestFacade;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.security.RolesAllowed;
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
@Path("jokeByCategoryV2")
public class JokeByCategoryV2Resource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/Examprep2",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final ApiFacade apiFacade = ApiFacade.getApiFacade();
    private static final RequestFacade requestFacade = RequestFacade.getRequestFacade(EMF);

    @GET
    @Path("{categories}")
    //@RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public JokesDTO getJsonList(@PathParam("categories") String categories) {
        String url = "https://api.chucknorris.io/jokes/random?category=";
        List<String> categoriesList = Arrays.asList(categories.split(","));
        if(categoriesList.size() > 12) {
            throw new WebApplicationException("Only a maximum of 12 categories allowed");
        }
        
        try {
            List<CategoryDTO> categoriesDTO = new ArrayList();
            for(String s : categoriesList) {
                categoriesDTO.add(requestFacade.getCategoryByName(s));
            }
            //requestFacade.createRequest(categoriesDTO);
            return apiFacade.fetch(url, categoriesDTO);
        } catch(NoResultException ex) {
            throw new WebApplicationException("No category found");
        }
    }
}
