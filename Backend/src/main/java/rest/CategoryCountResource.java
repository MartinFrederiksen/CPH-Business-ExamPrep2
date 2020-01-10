package rest;

import facades.RequestFacade;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author Martin Frederiksen
 */
@Path("categoryCount")
public class CategoryCountResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/Examprep2",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final RequestFacade facade = RequestFacade.getRequestFacade(EMF);
    
    @GET
    @Path("{categories}")
    //@RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public long getJsonList(@PathParam("categories") String categories) {
        return facade.getCategoryByName(categories).getRequests().size();
    }
}
