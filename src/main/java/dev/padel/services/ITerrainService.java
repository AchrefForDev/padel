package dev.padel.services;

import dev.padel.models.Terrain;

import java.util.List;
public interface ITerrainService {

    Terrain ajouterTerrain(Terrain terrain);

    List<Terrain> listerTerrains();


    Terrain modifierTerrain(Long idTerrain, Terrain terrain);

    void supprimerTerrain(Long idTerrain);
}