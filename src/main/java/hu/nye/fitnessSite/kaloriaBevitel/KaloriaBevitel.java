package hu.nye.fitnessSite.kaloriaBevitel;

import jakarta.validation.constraints.Positive;

import java.util.List;

public record KaloriaBevitel(
        Integer id,
        @Positive
        Integer zsir,
        @Positive
        Integer szenhidrat,
        @Positive
        Integer feherje,
        @Positive
        Integer viz
){
}

