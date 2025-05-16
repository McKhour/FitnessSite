package hu.nye.fitnessSite.sulyEmeles;

import hu.nye.fitnessSite.felhasznalo.Felhasznalo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

@Entity
public record SulyEmeles(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        @ManyToOne
        @JoinColumn(name = "felhasznalo_id", referencedColumnName = "id")
        Felhasznalo felhasznalo,
        @NotEmpty @Positive
        Integer suly,
        @NotEmpty @Positive
        Integer szettek,
        @NotEmpty @Positive
        Integer repek,
        Tipusa tipusa
) {
}
