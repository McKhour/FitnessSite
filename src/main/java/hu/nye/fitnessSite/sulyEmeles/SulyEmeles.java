package hu.nye.fitnessSite.sulyEmeles;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record SulyEmeles(
        Integer id,
        @NotEmpty @Positive
        Integer suly,
        @NotEmpty @Positive
        Integer szettek,
        @NotEmpty @Positive
        Integer repek,
        Tipusa tipusa
) {
}
