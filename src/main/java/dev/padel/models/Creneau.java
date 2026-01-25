package dev.padel.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table (name = "creneaux")
public class Creneau {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idCreneau;

    private LocalDate date;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private double prix;

    @ManyToOne
    @JoinColumn(name = "terrain_id")
    private Terrain terrain;

    @OneToMany(mappedBy = "creneau", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public void calculerPrix() {
        if (terrain != null && heureDebut != null && heureFin != null) {
            long minutes = java.time.Duration.between(heureDebut, heureFin).toMinutes();
            double heures = minutes / 60.0;
            this.prix = heures * terrain.getPrixheure();
        }
    }

    public Long getIdCreneau() {
        return idCreneau;
    }

    public void setIdCreneau(Long idCreneau) {
        this.idCreneau = idCreneau;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}

