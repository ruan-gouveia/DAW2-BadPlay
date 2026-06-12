package br.edu.ifpb.es.daw.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EpisodioRequestDTO(
        String nomeEpisodio,

        @NotNull(message = "O número do episódio é obrigatório")
        @Positive(message = "Deve ser maior que zero")
        Integer numeroEpisodio,

        @Positive(message = "A duração deve ser positiva")
        Integer duracaoMinutos,

        @NotBlank(message = "A URL é obrigatória")
        String urlEpisodio,

        @NotNull(message = "O ID da temporada é obrigatório")
        Long idTemporada
) {}