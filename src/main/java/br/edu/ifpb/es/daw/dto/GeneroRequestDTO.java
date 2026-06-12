package br.edu.ifpb.es.daw.dto;

import jakarta.validation.constraints.NotBlank;

public record GeneroRequestDTO(
        @NotBlank(message = "O nome do gênero é obrigatório")
        String nome,

        String descricao
) {}