package Grupo3.ASJV.backend.payload.request;

import Grupo3.ASJV.backend.model.Municipality;

import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @NotBlank
    @Size(max = 50)
    @Email
    private String mail;

    private Set<String> roles;

    private long municipality_id;

    private long neighborhood_id;

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public long getMunicipality_id() {
        return municipality_id;
    }

    public void setMunicipality_id(long municipality_id) {
        this.municipality_id = municipality_id;
    }

    public long getNeighborhood_id() {
        return neighborhood_id;
    }

    public void setNeighborhood_id(long neighborhood_id) {
        this.neighborhood_id = neighborhood_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return this.roles;
    }

    public void setRole(Set<String> roles) {
        this.roles = roles;
    }
}