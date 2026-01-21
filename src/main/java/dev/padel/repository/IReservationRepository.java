package dev.padel.repository;

import dev.padel.models.Reservation;
import dev.padel.models.StatutReservation;
import dev.padel.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation,Long> {

}
