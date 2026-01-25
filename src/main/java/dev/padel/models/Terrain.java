package dev.padel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table (name = "terrains")
public class Terrain {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Long idTerrain;

    private String nomTerrain;
    private String localisation;

    private LocalTime dateouverture;
    private LocalTime datefermeture;

    private double prixheure;

    @JsonIgnore
    @OneToMany(mappedBy = "terrain", cascade = CascadeType.ALL)
    private List<Creneau> creneau ;

    public Long getIdTerrain() {
        return idTerrain;
    }

    public void setIdTerrain(Long idTerrain) {
        this.idTerrain = idTerrain;
    }

    public String getNomTerrain() {
        return nomTerrain;
    }

    public void setNomTerrain(String nomTerrain) {
        this.nomTerrain = nomTerrain;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public LocalTime getDateouverture() {
        return dateouverture;
    }

    public void setDateouverture(LocalTime dateouverture) {
        this.dateouverture = dateouverture;
    }

    public LocalTime getDatefermeture() {
        return datefermeture;
    }

    public void setDatefermeture(LocalTime datefermeture) {
        this.datefermeture = datefermeture;
    }

    public double getPrixheure() {
        return prixheure;
    }

    public void setPrixheure(double prixheure) {
        this.prixheure = prixheure;
    }

    public List<Creneau> getCreneau() {
        return creneau;
    }

    public void setCreneau(List<Creneau> creneau) {
        this.creneau = creneau;
    }
}
