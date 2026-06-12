package br.edu.ifpb.es.daw.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RecomendacaoRequestDTO(
        @NotNull(message = "O ID do conteúdo é obrigatório")
        Long idConteudo,

        @NotNull(message = "O ID do usuário é obrigatório")
        Long idUsuario,

        @NotBlank(message = "O motivo da recomendação é obrigatório")
        String motivo
) {}