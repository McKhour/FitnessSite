package hu.nye.fitnessSite.sulyEmelesTest;

import hu.nye.fitnessSite.felhasznalo.Felhasznalo;
import hu.nye.fitnessSite.sulyEmeles.SulyEmeles;
import hu.nye.fitnessSite.sulyEmeles.SulyEmelesRepository;
import hu.nye.fitnessSite.sulyEmeles.SulyServices;
import hu.nye.fitnessSite.sulyEmeles.Tipusa;
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

class SulyServicesTest {

    @Mock
    private SulyEmelesRepository sulyRepo;

    @InjectMocks
    private SulyServices sulyServices;

    private SulyEmeles suly;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Felhasznalo felhasznalo = new Felhasznalo("Test", "User", "test@example.com", 30, 75);
        suly = new SulyEmeles(1L, felhasznalo, 50, 4, 12, Tipusa.FEKVENYOMAS);
    }

    @Test
    void testGetAllSuly() {
        when(sulyRepo.findAll()).thenReturn(Arrays.asList(suly));

        List<SulyEmeles> result = sulyServices.getAllSuly();

        assertEquals(1, result.size());
        assertEquals(suly, result.get(0));
        verify(sulyRepo).findAll();
    }

    @Test
    void testSaveSuly() {
        when(sulyRepo.save(suly)).thenReturn(suly);

        SulyEmeles saved = sulyServices.save(suly);

        assertNotNull(saved);
        assertEquals(suly, saved);
        verify(sulyRepo).save(suly);
    }

    @Test
    void testEditSuly() {
        when(sulyRepo.save(suly)).thenReturn(suly);

        SulyEmeles updated = sulyServices.edit(suly);

        assertEquals(suly, updated);
        verify(sulyRepo).save(suly);
    }

    @Test
    void testFindByIdSuccess() {
        when(sulyRepo.findById(1L)).thenReturn(Optional.of(suly));

        SulyEmeles found = sulyServices.findById(1L);

        assertEquals(suly, found);
        verify(sulyRepo).findById(1L);
    }

    @Test
    void testFindByIdThrowsException() {
        when(sulyRepo.findById(999L)).thenReturn(Optional.empty());

        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> sulyServices.findById(999L)
        );

        assertEquals("Nem létezik súly emelés a következő ID-val: 999", exception.getMessage());
    }

    @Test
    void testDeleteById() {
        sulyServices.deleteById(1L);

        verify(sulyRepo).deleteById(1L);
    }
}
