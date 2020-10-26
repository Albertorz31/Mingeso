package Grupo3.ASJV.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "User")
public class User {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private long id;

    @Indexed(unique = true)
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String mail;

    private Neighborhood neighborhood;

    private Municipality municipality;

    @DBRef
    private Set<Role> roles = new HashSet<>();


    //Primer constructor
    @PersistenceConstructor
    public User(String username, String password, String mail) {
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public User(String username, String password, String mail, Neighborhood neighborhood) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.neighborhood = neighborhood;
    }

    public User(String username, String password, String mail, Municipality municipality) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.municipality = municipality;
    }

    public User(String username, String password, String mail, Municipality municipality, Neighborhood neighborhood) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.municipality = municipality;
        this.neighborhood = neighborhood;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }
}
