package dev.padel.controllers;

import dev.padel.models.Creneau;
import dev.padel.services.ICreneauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creneau")
public class CreneauController {

    @Autowired
    private ICreneauService creneauService;



    @GetMapping("/allcreneaux")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Creneau> getAll() {
        return creneauService.getAllCreneaux();
    }

    @PostMapping("/aadcreneau")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Creneau create(@RequestBody Creneau creneau) {
        return creneauService.createCreneau(creneau);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Creneau update(@PathVariable Long id, @RequestBody Creneau creneau) {
        return creneauService.updateCreneau(id, creneau);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        creneauService.deleteCreneau(id);
    }
}
