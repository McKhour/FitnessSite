package hu.nye.fitnessSite.kaloriaBevitelTest;

import hu.nye.fitnessSite.felhasznalo.Felhasznalo;
import hu.nye.fitnessSite.kaloriaBevitel.KaloriaBevitel;
import hu.nye.fitnessSite.kaloriaBevitel.KaloriaBevitelRepository;
import hu.nye.fitnessSite.kaloriaBevitel.KaloriaServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class KaloriaServicesTest {

    @Mock
    private KaloriaBevitelRepository kaloriaRepo;

    @InjectMocks
    private KaloriaServices kaloriaServices;

    private KaloriaBevitel kaloria;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Felhasznalo felhasznalo = new Felhasznalo("Teszt", "User", "teszt@user.hu", 25, 68);
        kaloria = new KaloriaBevitel(1L, felhasznalo, 10, 20, 30, 40);
    }

    @Test
    void testGetAllKaloria() {
        when(kaloriaRepo.findAll()).thenReturn(Arrays.asList(kaloria));

        List<KaloriaBevitel> result = kaloriaServices.getAllKaloria();

        assertEquals(1, result.size());
        assertEquals(kaloria, result.get(0));
        verify(kaloriaRepo).findAll();
    }

    @Test
    void testSaveKaloria() {
        when(kaloriaRepo.save(kaloria)).thenReturn(kaloria);

        KaloriaBevitel saved = kaloriaServices.save(kaloria);

        assertNotNull(saved);
        assertEquals(kaloria, saved);
        verify(kaloriaRepo).save(kaloria);
    }

    @Test
    void testEditKaloria() {
        when(kaloriaRepo.save(kaloria)).thenReturn(kaloria);

        KaloriaBevitel updated = kaloriaServices.edit(kaloria);

        assertEquals(kaloria, updated);
        verify(kaloriaRepo, times(1)).save(kaloria);
    }

    @Test
    void testFindByIdSuccess() {
        when(kaloriaRepo.findById(1L)).thenReturn(Optional.of(kaloria));

        KaloriaBevitel found = kaloriaServices.findById(1L);

        assertEquals(kaloria, found);
        verify(kaloriaRepo).findById(1L);
    }

    @Test
    void testFindByIdThrowsException() {
        when(kaloriaRepo.findById(999L)).thenReturn(Optional.empty());

        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> kaloriaServices.findById(999L)
        );

        assertEquals("Nem létezik kalória bevitel a következő ID-val: 999", exception.getMessage());
    }

    @Test
    void testDeleteById() {
        kaloriaServices.deleteById(1L);

        verify(kaloriaRepo).deleteById(1L);
    }
}
