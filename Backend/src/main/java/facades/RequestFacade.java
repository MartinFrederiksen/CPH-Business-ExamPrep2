package facades;

import entities.Category;
import entities.Request;
import entities.dto.CategoryDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

/**
 *
 * @author Martin Frederiksen
 */
public class RequestFacade {

    private static RequestFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private RequestFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static RequestFacade getRequestFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RequestFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categories = getEntityManager().createQuery("SELECT new entities.dto.CategoryDTO(category) FROM Category category").getResultList();
        for(CategoryDTO c : categories) {
            c.setRequests(null);
        }
        return categories;
    }

    public CategoryDTO getCategoryByName(String name) throws NoResultException {
        return getEntityManager().createQuery("SELECT new entities.dto.CategoryDTO(category) FROM Category category WHERE category.name = :name", CategoryDTO.class).setParameter("name", name).getSingleResult();
    }
/*
    public void createRequest(List<CategoryDTO> categories) {
        EntityManager em = getEntityManager();
        List<Category> categoriesReal = new ArrayList();
        for(CategoryDTO c : categories) {
            categoriesReal.add(getEntityManager().find(Category.class, c.getId()));
        }
        try {
            em.getTransaction().begin();
            em.persist(new Request(new Date(), categoriesReal));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }*/
}
