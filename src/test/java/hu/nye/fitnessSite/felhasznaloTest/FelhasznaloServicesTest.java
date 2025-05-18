package hu.nye.fitnessSite.felhasznaloTest;

import hu.nye.fitnessSite.felhasznalo.Felhasznalo;
import hu.nye.fitnessSite.felhasznalo.FelhasznaloRepository;
import hu.nye.fitnessSite.felhasznalo.FelhasznaloServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FelhasznaloServicesTest {

    @InjectMocks
    private FelhasznaloServices felhasznaloServices;

    @Mock
    private FelhasznaloRepository felhasznaloRepo;

    private Felhasznalo sampleFelhasznalo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Teszt felhasználó létrehozása
        sampleFelhasznalo = new Felhasznalo(
                1L,
                "János",
                "Teszt",
                "janos.teszt@email.com",
                30,
                75
        );
    }

    @Test
    void testGetAllFelhaszn() {
        List<Felhasznalo> list = List.of(sampleFelhasznalo);
        when(felhasznaloRepo.findAll()).thenReturn(list);

        List<Felhasznalo> result = felhasznaloServices.getAllFelhaszn();

        assertEquals(1, result.size());
        assertEquals("János", result.get(0).getKeresztNev());
        verify(felhasznaloRepo, times(1)).findAll();
    }

    @Test
    void testSave() {
        when(felhasznaloRepo.save(sampleFelhasznalo)).thenReturn(sampleFelhasznalo);

        Felhasznalo result = felhasznaloServices.save(sampleFelhasznalo);

        assertNotNull(result);
        assertEquals("janos.teszt@email.com", result.getEmail());
        verify(felhasznaloRepo, times(1)).save(sampleFelhasznalo);
    }

    @Test
    void testEdit() {
        when(felhasznaloRepo.save(sampleFelhasznalo)).thenReturn(sampleFelhasznalo);

        Felhasznalo result = felhasznaloServices.edit(sampleFelhasznalo);

        assertEquals(75, result.getTestSuly());
        verify(felhasznaloRepo, times(1)).save(sampleFelhasznalo);
    }

    @Test
    void testFindByIdExists() {
        when(felhasznaloRepo.findById(1L)).thenReturn(Optional.of(sampleFelhasznalo));

        Felhasznalo result = felhasznaloServices.findById(1L);

        assertNotNull(result);
        assertEquals("Teszt", result.getVezetekNev());
        verify(felhasznaloRepo, times(1)).findById(1L);
    }

    @Test
    void testFindByIdNotExists() {
        when(felhasznaloRepo.findById(2L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            felhasznaloServices.findById(2L);
        });

        assertTrue(exception.getMessage().contains("Nem létezik felhasználó"));
        verify(felhasznaloRepo, times(1)).findById(2L);
    }

    @Test
    void testDeleteById() {
        doNothing().when(felhasznaloRepo).deleteById(1L);

        felhasznaloServices.deleteById(1L);

        verify(felhasznaloRepo, times(1)).deleteById(1L);
    }
}
