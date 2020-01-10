package entities.dto;

import java.util.List;

/**
 *
 * @author Martin Frederiksen
 */
public class JokesDTO {
    private List<JokeDTO> jokes;
    private String reference;

    public JokesDTO(List<JokeDTO> jokes, String reference) {
        this.jokes = jokes;
        this.reference = reference;
    }

    public List<JokeDTO> getJokes() {
        return jokes;
    }

    public void setJokes(List<JokeDTO> jokes) {
        this.jokes = jokes;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
