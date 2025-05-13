package hu.nye.fitnessSite.futas;

import java.time.LocalDateTime;

public record Futas(
        Integer id,
        String futasCim,
        LocalDateTime futasKezd,
        LocalDateTime futasVeg,
        Double kilometer,
        Helye helye
) {
}
