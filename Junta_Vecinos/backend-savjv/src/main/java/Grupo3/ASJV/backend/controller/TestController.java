package Grupo3.ASJV.backend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/ciudadano")
    @PreAuthorize("hasRole('CIUDADANO') or hasRole('MUNICIPALIDAD') or hasRole('JUNTAVECINOS')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/municipalidad")
    @PreAuthorize("hasRole('MUNICIPALIDAD')")
    public String moderatorAccess() {
        return "Municipalidad Board.";
    }

    @GetMapping("/juntavecinos")
    @PreAuthorize("hasRole('JUNTAVECINOS')")
    public String adminAccess() {
        return "Junta vecinos Board.";
    }
}