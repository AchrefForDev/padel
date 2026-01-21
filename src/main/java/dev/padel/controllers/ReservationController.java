package dev.padel.controllers;


import dev.padel.models.Reservation;
import dev.padel.models.StatutReservation;
import dev.padel.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/reservation")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Reservation> getAll() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public Reservation getById(@PathVariable Long id) {
        return reservationService.getReservationById(id).orElse(null);
    }

    @PostMapping("/{creneauId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Reservation create(@PathVariable Long creneauId, @RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation, creneauId);
    }

    @PutMapping("/{id}/statut")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Reservation validerOuRefuser(@PathVariable Long id, @RequestParam StatutReservation statut) {
        return reservationService.changerStatut(id, statut);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public void delete(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}