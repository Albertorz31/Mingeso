package Grupo3.ASJV.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Neighborhood")
public class Neighborhood{
    @Transient
    public static final String SEQUENCE_NAME = "neighborhood_sequence";

    @Id
    private long id;
    private String name;
    private Municipality municipality;

    public Neighborhood(Municipality municipality, String name) {
        this.municipality = municipality;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
