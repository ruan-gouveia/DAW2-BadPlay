package br.edu.ifpb.es.daw.dto;

import br.edu.ifpb.es.daw.entities.TipoPlano;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record PlanoRequestDTO(
        @NotNull(message = "O tipo do plano é obrigatório")
        TipoPlano tipo,

        @NotNull(message = "O valor é obrigatório")
        @Positive(message = "O valor deve ser positivo")
        BigDecimal valor
) {}