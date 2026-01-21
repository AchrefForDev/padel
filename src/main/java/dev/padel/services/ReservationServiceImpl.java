package dev.padel.services;

import dev.padel.models.Creneau;
import dev.padel.models.Reservation;
import dev.padel.models.StatutReservation;
import dev.padel.repository.ICreneauRepository;
import dev.padel.repository.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements  IReservationService {

    private final IReservationRepository reservationRepository;
    private final ICreneauRepository creneauRepository;

    public ReservationServiceImpl(IReservationRepository reservationRepository, ICreneauRepository creneauRepository) {
        this.reservationRepository = reservationRepository;
        this.creneauRepository = creneauRepository;
    }
    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation createReservation(Reservation reservation, Long idCreneau) {
        Creneau creneau = creneauRepository.findById(idCreneau)
                .orElseThrow(() -> new RuntimeException("Créneau introuvable"));
        reservation.setCreneau(creneau);
        reservation.calculerPrixAPayer();
        reservation.setStatut(StatutReservation.EN_ATTENTE);
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation changerStatut(Long id, StatutReservation statut) {
        Reservation r = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation introuvable"));
        r.setStatut(statut);
        return reservationRepository.save(r);
    }

    @Override
    public Reservation updateReservation(Long id, Reservation nouvelle) {
        return reservationRepository.findById(id).map(r -> {
            r.setCreneau(nouvelle.getCreneau());
            r.setStatut(nouvelle.getStatut());
            r.calculerPrixAPayer();
            return reservationRepository.save(r);
        }).orElseThrow(() -> new RuntimeException("Réservation introuvable"));
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
