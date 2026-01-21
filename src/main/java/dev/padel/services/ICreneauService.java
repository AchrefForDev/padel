package dev.padel.services;

import dev.padel.models.Creneau;

import java.util.List;
import java.util.Optional;

public interface ICreneauService {
    List<Creneau> getAllCreneaux();
    Optional<Creneau> getCreneauById(Long id);
    Creneau createCreneau(Creneau creneau);
    Creneau updateCreneau(Long id, Creneau creneau);
    void deleteCreneau(Long id);
}
