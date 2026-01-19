package dev.padel.controllers;

import dev.padel.models.Terrain;
import dev.padel.services.ITerrainService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terrain")

public class TerrainController {

    @Autowired
    private ITerrainService terrainService;

    @PostMapping("/addTerrain")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Terrain ajouterTerrain(@RequestBody Terrain terrain) {
        return terrainService.ajouterTerrain(terrain);
    }

    @GetMapping("/getAllTerrains")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<Terrain> getAllTerrains() {
        return terrainService.listerTerrains();
    }
    @PutMapping("/updatet/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Terrain updateTerrain(@PathVariable Long id, @RequestBody Terrain terrain) {
        return terrainService.modifierTerrain(id, terrain);
    }

    @DeleteMapping("/delait/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteTerrain(@PathVariable Long id) {
        terrainService.supprimerTerrain(id);
    }
}
