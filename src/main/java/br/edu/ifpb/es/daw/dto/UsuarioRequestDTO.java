package br.edu.ifpb.es.daw.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record UsuarioRequestDTO(
        @NotBlank(message = "O nome não pode estar vazio")
        String nome,

        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "Digite um e-mail válido (ex: seu@email.com)")
        String email,

        @NotBlank(message = "A senha não pode estar vazia")
        @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
        String senha,

        @NotNull(message = "A data de nascimento é obrigatória")
        @Past(message = "A data de nascimento deve estar no passado")
        LocalDate dataNascimento
) {}