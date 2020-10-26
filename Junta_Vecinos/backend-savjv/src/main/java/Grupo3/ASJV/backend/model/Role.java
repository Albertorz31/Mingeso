package Grupo3.ASJV.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Role")
public class Role {
    @Transient
    public static final String SEQUENCE_NAME = "role_sequence";

    @Id
    private String id;

    private Erole name;

    public Role(Erole name)
    {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Erole getName() {
        return name;
    }

    public void setName(Erole name) {
        this.name = name;
    }
}
