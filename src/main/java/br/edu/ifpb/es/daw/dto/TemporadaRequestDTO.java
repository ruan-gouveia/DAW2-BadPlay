package br.edu.ifpb.es.daw.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TemporadaRequestDTO(
        @NotNull(message = "O número da temporada é obrigatório")
        @Positive(message = "O número da temporada deve ser maior que zero")
        Integer numeroTemporada,

        @NotNull(message = "O ID da Série vinculada é obrigatório")
        Long idSerie
) {}