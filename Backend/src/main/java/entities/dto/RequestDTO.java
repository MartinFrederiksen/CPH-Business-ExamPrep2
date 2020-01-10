package entities.dto;

import entities.Category;
import entities.Request;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin Frederiksen
 */
public class RequestDTO {
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    private List<CategoryDTO> categories;

    public RequestDTO() {
    }

    public RequestDTO(Date timestamp, List<CategoryDTO> categories) {
        this.timestamp = timestamp;
        this.categories = categories;
    }
    
    public RequestDTO(Request request) {
        this.timestamp = request.getTimestamp();
        this.categories = new ArrayList();
        for(Category c : request.getCategories()) {
            categories.add(new CategoryDTO(c));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
