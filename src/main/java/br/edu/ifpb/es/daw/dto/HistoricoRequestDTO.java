package br.edu.ifpb.es.daw.dto;

import jakarta.validation.constraints.NotNull;

public record HistoricoRequestDTO(
        @NotNull(message = "O ID do conteúdo é obrigatório")
        Long idConteudo,

        @NotNull(message = "O ID do usuário é obrigatório")
        Long idUsuario
) {}