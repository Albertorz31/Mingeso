package Grupo3.ASJV.backend.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import Grupo3.ASJV.backend.model.Municipality;
import Grupo3.ASJV.backend.model.Neighborhood;
import Grupo3.ASJV.backend.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String mail;

    private Neighborhood neighborhood;

    private Municipality municipality;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String username, String mail, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.authorities = authorities;
    }

    public UserDetailsImpl(Long id, String username, String mail, String password, Neighborhood neighborhood,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.neighborhood = neighborhood;
        this.authorities = authorities;
    }

    public UserDetailsImpl(Long id, String username, String mail, String password, Municipality municipality,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.municipality = municipality;
        this.authorities = authorities;
    }

    public UserDetailsImpl(Long id, String username, String mail, String password, Neighborhood neighborhood,
                           Municipality municipality, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.neighborhood = neighborhood;
        this.municipality = municipality;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getMail(),
                user.getPassword(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
