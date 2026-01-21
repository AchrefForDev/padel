package dev.padel.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    @OneToMany(mappedBy = "terrain", cascade = CascadeType.ALL)
    private List<Creneau> creneau ;


}
