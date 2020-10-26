package Grupo3.ASJV.backend.payload.response;

import Grupo3.ASJV.backend.model.Municipality;
import Grupo3.ASJV.backend.model.Neighborhood;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private long id;
    private String username;
    private String mail;
    private List<String> roles;
    private Neighborhood neighborhood;
    private Municipality municipality;

    public JwtResponse(String accessToken, long id, String username, String mail, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.roles = roles;
    }

    public JwtResponse(String accessToken, long id, String username, String mail, List<String> roles, Neighborhood neighborhood) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.roles = roles;
        this.neighborhood = neighborhood;
    }

    public JwtResponse(String accessToken, long id, String username, String mail, List<String> roles, Municipality municipality) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.roles = roles;
        this.municipality = municipality;
    }

    public JwtResponse(String accessToken, long id, String username, String mail, List<String> roles, Neighborhood neighborhood, Municipality municipality) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.roles = roles;
        this.neighborhood = neighborhood;
        this.municipality = municipality;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }
}