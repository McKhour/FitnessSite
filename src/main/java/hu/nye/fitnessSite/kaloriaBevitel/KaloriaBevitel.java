package hu.nye.fitnessSite.kaloriaBevitel;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record KaloriaBevitel(
        Integer id,
        @NotEmpty
        Integer userId,
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

