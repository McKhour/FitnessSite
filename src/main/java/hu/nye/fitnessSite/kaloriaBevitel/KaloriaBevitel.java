package hu.nye.fitnessSite.kaloriaBevitel;

import hu.nye.fitnessSite.felhasznalo.Felhasznalo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.util.List;

@Entity
@Table(name = "KaloriaBevitel")
public record KaloriaBevitel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        @ManyToOne
        @JoinColumn(name = "felhsznalo_id", referencedColumnName = "id")
        Felhasznalo felhasznalo,
        @Positive
        Integer zsir,
        @Positive
        Integer szenhidrat,
        @Positive
        Integer feherje,
        @Positive
        Integer viz
){
}

