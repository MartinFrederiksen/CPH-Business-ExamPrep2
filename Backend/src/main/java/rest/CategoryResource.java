/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entities.dto.CategoryDTO;
import facades.RequestFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author Martin Frederiksen
 */
@Path("category")
public class CategoryResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/Examprep2",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final RequestFacade facade = RequestFacade.getRequestFacade(EMF);
    
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryDTO> getCategories() {
        return facade.getAllCategories();
    }
}
