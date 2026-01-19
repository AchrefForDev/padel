package dev.padel.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table (name = "creneaux")
public class Creneau {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idCreneau;

    private LocalDate date;
    private LocalTime heureDebut;
    private LocalTime heureFin;

    @ManyToOne
    @JoinColumn(name = "terrain_id")
    private Terrain terrain;

    @OneToMany(mappedBy = "creneau", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}

