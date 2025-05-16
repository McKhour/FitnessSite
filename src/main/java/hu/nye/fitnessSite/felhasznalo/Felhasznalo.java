package hu.nye.fitnessSite.felhasznalo;

public record Felhasznalo(
        Integer id,
        String keresztNev,
        String vezetekNev,
        String email,
        Integer eletkor,
        Integer testSuly
) {
}
