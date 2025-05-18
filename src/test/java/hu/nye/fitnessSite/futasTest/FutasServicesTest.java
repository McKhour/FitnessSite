package hu.nye.fitnessSite.futasTest;

import hu.nye.fitnessSite.felhasznalo.Felhasznalo;
import hu.nye.fitnessSite.futas.Futas;
import hu.nye.fitnessSite.futas.FutasRepository;
import hu.nye.fitnessSite.futas.FutasServices;
import hu.nye.fitnessSite.futas.Helye;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FutasServicesTest {

    @Mock
    private FutasRepository futasRepo;

    @InjectMocks
    private FutasServices futasServices;

    private Futas futas;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Felhasznalo felhasznalo = new Felhasznalo("Teszt", "János", "teszt@teszt.hu", 30, 70);
        futas = new Futas(1L, felhasznalo, "Reggeli futás",
                LocalDateTime.of(2023, 1, 1, 6, 0),
                LocalDateTime.of(2023, 1, 1, 7, 0),
                10.0,
                Helye.KINT);
    }

    @Test
    void testGetAllFutas() {
        when(futasRepo.findAll()).thenReturn(Arrays.asList(futas));

        List<Futas> result = futasServices.getAllFutas();

        assertEquals(1, result.size());
        assertEquals(futas, result.get(0));
        verify(futasRepo, times(1)).findAll();
    }

    @Test
    void testSaveFutas() {
        when(futasRepo.save(futas)).thenReturn(futas);

        Futas saved = futasServices.save(futas);

        assertNotNull(saved);
        assertEquals(futas, saved);
        verify(futasRepo).save(futas);
    }

    @Test
    void testEditFutas() {
        when(futasRepo.save(futas)).thenReturn(futas);

        Futas updated = futasServices.edit(futas);

        assertEquals(futas, updated);
        verify(futasRepo, times(1)).save(futas);
    }

    @Test
    void testFindByIdSuccess() {
        when(futasRepo.findById(1L)).thenReturn(Optional.of(futas));

        Futas found = futasServices.findById(1L);

        assertEquals(futas, found);
        verify(futasRepo).findById(1L);
    }

    @Test
    void testFindByIdThrowsException() {
        when(futasRepo.findById(999L)).thenReturn(Optional.empty());

        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> futasServices.findById(999L)
        );

        assertEquals("Nem létezik futás a következő ID-val: 999", exception.getMessage());
    }

    @Test
    void testDeleteById() {
        futasServices.deleteById(1L);

        verify(futasRepo, times(1)).deleteById(1L);
    }
}
