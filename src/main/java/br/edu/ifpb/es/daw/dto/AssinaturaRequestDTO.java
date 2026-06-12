package br.edu.ifpb.es.daw.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AssinaturaRequestDTO(
        @NotNull(message = "O ID do plano é obrigatório")
        Long idPlano,

        @NotNull(message = "O ID do usuário é obrigatório")
        Long idUsuario,

        @NotBlank(message = "O número do cartão é obrigatório")
        @Size(min = 16, message = "O cartão deve ter pelo menos 16 dígitos")
        String numeroCartao,

        @NotBlank(message = "O nome do titular é obrigatório")
        String nomeTitular,

        @NotBlank(message = "O CVV é obrigatório")
        @Size(min = 3, message = "O CVV deve ter pelo menos 3 dígitos")
        String cvv
) {}