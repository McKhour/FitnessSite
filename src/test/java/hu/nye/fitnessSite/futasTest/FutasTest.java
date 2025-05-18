package hu.nye.fitnessSite.futasTest;

import hu.nye.fitnessSite.felhasznalo.Felhasznalo;
import hu.nye.fitnessSite.futas.Futas;
import hu.nye.fitnessSite.futas.Helye;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FutasTest {

    @Test
    void testConstructorAndGetters() {
        Felhasznalo felhasznalo = new Felhasznalo("Test", "User", "test@example.com", 30, 70);
        LocalDateTime kezd = LocalDateTime.of(2024, 5, 1, 10, 0);
        LocalDateTime veg = LocalDateTime.of(2024, 5, 1, 11, 0);

        Futas futas = new Futas(1L, felhasznalo, "Reggeli futás", kezd, veg, 5.2, Helye.KINT);

        assertEquals(1L, futas.getId());
        assertEquals(felhasznalo, futas.getFelhasznalo());
        assertEquals("Reggeli futás", futas.getFutasCim());
        assertEquals(kezd, futas.getFutasKezd());
        assertEquals(veg, futas.getFutasVeg());
        assertEquals(5.2, futas.getKilometer());
        assertEquals(Helye.KINT, futas.getHelye());
    }

    @Test
    void testSetters() {
        Futas futas = new Futas();
        Felhasznalo felhasznalo = new Felhasznalo("Jane", "Doe", "jane@example.com", 25, 60);
        LocalDateTime kezd = LocalDateTime.of(2025, 1, 1, 8, 30);
        LocalDateTime veg = LocalDateTime.of(2025, 1, 1, 9, 0);

        futas.setId(2L);
        futas.setFelhasznalo(felhasznalo);
        futas.setFutasCim("Újévi futás");
        futas.setFutasKezd(kezd);
        futas.setFutasVeg(veg);
        futas.setKilometer(3.0);
        futas.setHelye(Helye.BENT);

        assertEquals(2L, futas.getId());
        assertEquals(felhasznalo, futas.getFelhasznalo());
        assertEquals("Újévi futás", futas.getFutasCim());
        assertEquals(kezd, futas.getFutasKezd());
        assertEquals(veg, futas.getFutasVeg());
        assertEquals(3.0, futas.getKilometer());
        assertEquals(Helye.BENT, futas.getHelye());
    }
}
