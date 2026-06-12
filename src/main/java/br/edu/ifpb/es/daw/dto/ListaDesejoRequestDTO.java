package br.edu.ifpb.es.daw.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ListaDesejoRequestDTO(
        @NotBlank(message = "O nome da lista é obrigatório")
        String nome,

        @NotNull(message = "O ID do usuário é obrigatório")
        Long idUsuario
) {}