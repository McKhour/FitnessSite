package hu.nye.fitnessSite.futas;

import hu.nye.fitnessSite.felhasznalo.Felhasznalo;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Futas")
public record Futas(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        @ManyToOne
        @JoinColumn(name = "felhasznalo_id", referencedColumnName = "id")
        Felhasznalo felhasznalo,
        String futasCim,
        LocalDateTime futasKezd,
        LocalDateTime futasVeg,
        Double kilometer,
        Helye helye
){
    public Futas{
        if (!futasVeg.isAfter(futasKezd)){
            throw new IllegalArgumentException("A Futás Vége nem előzheti meg a Futás Kezdetét!");
        }
    }
}
