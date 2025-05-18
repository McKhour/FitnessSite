package hu.nye.fitnessSite.felhasznaloTest;

import hu.nye.fitnessSite.felhasznalo.Felhasznalo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FelhasznaloTest {

    @Test
    void testConstructorAndGetters() {
        Felhasznalo felhasznalo = new Felhasznalo(1L, "János", "Teszt", "janos@example.com", 30, 75);

        assertEquals(1L, felhasznalo.getId());
        assertEquals("János", felhasznalo.getKeresztNev());
        assertEquals("Teszt", felhasznalo.getVezetekNev());
        assertEquals("janos@example.com", felhasznalo.getEmail());
        assertEquals(30, felhasznalo.getEletkor());
        assertEquals(75, felhasznalo.getTestSuly());
        assertTrue(felhasznalo.getFutasok().isEmpty());
        assertTrue(felhasznalo.getSulyemelesek().isEmpty());
        assertTrue(felhasznalo.getKaloriaBevitelek().isEmpty());
    }

    @Test
    void testSetters() {
        Felhasznalo felhasznalo = new Felhasznalo();
        felhasznalo.setId(2L);
        felhasznalo.setKeresztNev("Anna");
        felhasznalo.setVezetekNev("Példa");
        felhasznalo.setEmail("anna@pelda.com");
        felhasznalo.setEletkor(25);
        felhasznalo.setTestSuly(60);

        assertEquals(2L, felhasznalo.getId());
        assertEquals("Anna", felhasznalo.getKeresztNev());
        assertEquals("Példa", felhasznalo.getVezetekNev());
        assertEquals("anna@pelda.com", felhasznalo.getEmail());
        assertEquals(25, felhasznalo.getEletkor());
        assertEquals(60, felhasznalo.getTestSuly());
    }
}
