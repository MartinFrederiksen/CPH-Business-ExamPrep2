package entities.dto;

import entities.Category;
import entities.Request;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin Frederiksen
 */
public class CategoryDTO {
    private Long id;
    private String name;
    private List<RequestDTO> requests;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String name, List<RequestDTO> requests) {
        this.id = id;
        this.name = name;
        this.requests = requests;
    }
    
    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.requests = new ArrayList();
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RequestDTO> getRequests() {
        return requests;
    }

    public void setRequests(List<RequestDTO> requests) {
        this.requests = requests;
    }
    
}
