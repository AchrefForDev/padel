package dev.padel.repository;

import dev.padel.models.Creneau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreneauRepository extends JpaRepository<Creneau, Long> {}

