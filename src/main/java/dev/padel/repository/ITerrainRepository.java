package dev.padel.repository;

import dev.padel.models.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITerrainRepository extends JpaRepository<Terrain, Long> {
}
