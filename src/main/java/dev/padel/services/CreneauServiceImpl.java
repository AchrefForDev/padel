package dev.padel.services;

import dev.padel.models.Creneau;
import dev.padel.models.Terrain;
import dev.padel.repository.ICreneauRepository;
import dev.padel.repository.ITerrainRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class CreneauServiceImpl implements ICreneauService{

    private final ICreneauRepository creneauRepository;
    private final ITerrainRepository terrainRepository;

    public CreneauServiceImpl(ICreneauRepository creneauRepository, ITerrainRepository terrainRepository) {
        this.creneauRepository = creneauRepository;
        this.terrainRepository = terrainRepository;
    }

    @Override
    public List<Creneau> getAllCreneaux() {
        return creneauRepository.findAll();
    }

    @Override
    public Optional<Creneau> getCreneauById(Long id) {
        return creneauRepository.findById(id);
    }

    @Override
    public Creneau createCreneau(Creneau creneau) {
        Terrain terrain = terrainRepository.findById(creneau.getTerrain().getIdTerrain())
                .orElseThrow(() -> new RuntimeException("Terrain introuvable"));
        LocalTime ouverture = terrain.getDateouverture();
        LocalTime fermeture = terrain.getDatefermeture();
        if (creneau.getHeureDebut().isBefore(ouverture) || creneau.getHeureFin().isAfter(fermeture)) {
            throw new RuntimeException("Heures invalides : en dehors des heures d’ouverture du terrain !");
        }
        creneau.setTerrain(terrain);
        creneau.calculerPrix();
        return creneauRepository.save(creneau);
    }

    @Override
    public Creneau updateCreneau(Long id, Creneau nouveau) {
        return creneauRepository.findById(id).map(existant -> {
            existant.setDate(nouveau.getDate());
            existant.setHeureDebut(nouveau.getHeureDebut());
            existant.setHeureFin(nouveau.getHeureFin());
            existant.setTerrain(nouveau.getTerrain());
            existant.calculerPrix();
            return creneauRepository.save(existant);
        }).orElseThrow(() -> new RuntimeException("Créneau introuvable"));
    }


    @Override
    public void deleteCreneau(Long id) {
        creneauRepository.deleteById(id);
    }
}
