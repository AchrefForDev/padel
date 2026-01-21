package dev.padel.services;

import dev.padel.models.Reservation;
import dev.padel.models.StatutReservation;
import dev.padel.models.User;

import java.util.List;
import java.util.Optional;

public interface IReservationService {
    List<Reservation> getAllReservations();
    Optional<Reservation> getReservationById(Long id);
    Reservation createReservation(Reservation reservation, Long idCreneau);
    Reservation changerStatut(Long id, StatutReservation statut);
    Reservation updateReservation(Long id, Reservation reservation);
    void deleteReservation(Long id);
}

