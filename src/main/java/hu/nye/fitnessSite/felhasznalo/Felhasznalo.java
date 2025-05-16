package hu.nye.fitnessSite.felhasznalo;

import jakarta.persistence.*;

@Entity
@Table(name = "Felhasznalok")
public record Felhasznalo(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        String keresztNev,
        String vezetekNev,
        String email,
        Integer eletkor,
        Integer testSuly
) {
}
