package hu.nye.fitnessSite.futas;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Futas(
        Integer id,
        @NotEmpty
        String futasCim,
        LocalDateTime futasKezd,
        LocalDateTime futasVeg,
        @Positive
        Double kilometer,
        Helye helye
) {

    public Futas{
        if (!futasVeg.isAfter(futasKezd)){
            throw new IllegalArgumentException("A Futás Vége nem előzheti meg a Futás Kezdetét!");
        }
    }
}
