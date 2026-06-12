package br.edu.ifpb.es.daw.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record AvaliacaoRequestDTO(
        @NotNull(message = "O ID do conteúdo é obrigatório")
        Long idConteudo,

        @NotNull(message = "O ID do usuário é obrigatório")
        Long idUsuario,

        @NotNull(message = "A nota é obrigatória")
        @Min(value = 1, message = "A nota mínima é 1.0")
        @Max(value = 5, message = "A nota máxima é 5.0")
        Double nota
) {}