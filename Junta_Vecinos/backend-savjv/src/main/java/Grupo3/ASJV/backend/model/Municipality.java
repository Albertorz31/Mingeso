package Grupo3.ASJV.backend.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Municipality")
public class Municipality {
    @Transient
    public static final String SEQUENCE_NAME = "municipality_sequence";

    @Id
    private long id;

    private String name;
    private String commune;

    public Municipality(String name, String commune) {
        this.name = name;
        this.commune = commune;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }
}
