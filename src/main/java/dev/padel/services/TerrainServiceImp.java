package dev.padel.services;

import dev.padel.models.Terrain;
import dev.padel.repository.ITerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerrainServiceImp implements ITerrainService {

    @Autowired
    private ITerrainRepository terrainRepository;

    @Override
    public Terrain ajouterTerrain(Terrain t) {
        return terrainRepository.save(t);
    }
    @Override
    public List<Terrain> listerTerrains() {
        return terrainRepository.findAll();
    }

    @Override
    public Terrain modifierTerrain(Long id , Terrain t) {
        Terrain terrainExistant = terrainRepository.findById(id).orElse(null);
        terrainExistant.setNomTerrain(t.getNomTerrain());
        terrainExistant.setLocalisation(t.getLocalisation());
        terrainExistant.setDateouverture(t.getDateouverture());
        terrainExistant.setDatefermeture(t.getDatefermeture());
        terrainExistant.setCreneau(t.getCreneau());
        return terrainRepository.save(terrainExistant);
    }

    @Override
    public void supprimerTerrain(Long idTerrain) {
        if (!terrainRepository.existsById(idTerrain)) {
            throw new RuntimeException("Terrain à supprimer introuvable" );
        }
        terrainRepository.deleteById(idTerrain);
    }

}
