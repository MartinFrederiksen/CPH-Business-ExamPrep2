package entities.dto;

/**
 *
 * @author Martin Frederiksen
 */
public class JokeDTO {
    private String category;
    private String joke;

    public JokeDTO(String category, String joke) {
        this.category = category;
        this.joke = joke;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}
