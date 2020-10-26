package Grupo3.ASJV.backend.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import Grupo3.ASJV.backend.model.*;
import Grupo3.ASJV.backend.payload.request.LoginRequest;
import Grupo3.ASJV.backend.payload.request.SignupRequest;
import Grupo3.ASJV.backend.payload.response.JwtResponse;
import Grupo3.ASJV.backend.payload.response.MessageResponse;
import Grupo3.ASJV.backend.repository.MunicipalityRepository;
import Grupo3.ASJV.backend.repository.NeighborhoodRepository;
import Grupo3.ASJV.backend.repository.RoleRepository;
import Grupo3.ASJV.backend.repository.UserRepository;
import Grupo3.ASJV.backend.security.jwt.JwtUtils;
import Grupo3.ASJV.backend.security.services.UserDetailsImpl;
import Grupo3.ASJV.backend.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    NeighborhoodRepository neighborhoodRepository;

    @Autowired
    MunicipalityRepository municipalityRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getMail(),
                roles,
                userDetails.getNeighborhood(),
                userDetails.getMunicipality()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByMail(signUpRequest.getMail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getMail());

        Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(Erole.ROLE_CIUDADANO)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "MUNICIPALIDAD":
                        Role MunicipalityRole = roleRepository.findByName(Erole.ROLE_MUNICIPALIDAD)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(MunicipalityRole);

                        break;
                    case "JUNTAVECINOS":
                        Role NeighborhoodRole = roleRepository.findByName(Erole.ROLE_JUNTAVECINOS)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(NeighborhoodRole);
                        Municipality municipality = municipalityRepository.findById(signUpRequest.getMunicipality_id()).get();
                        user.setMunicipality(municipality);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(Erole.ROLE_CIUDADANO)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                        Neighborhood neighborhood = neighborhoodRepository.findById(signUpRequest.getNeighborhood_id()).get();
                        user.setNeighborhood(neighborhood);
                }
            });
        }

        user.setRoles(roles);

        user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}