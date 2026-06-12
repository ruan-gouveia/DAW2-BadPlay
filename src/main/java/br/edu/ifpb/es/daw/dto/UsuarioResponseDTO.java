package br.edu.ifpb.es.daw.dto;

import br.edu.ifpb.es.daw.entities.Usuario;
import java.time.LocalDate;

public record UsuarioResponseDTO(
        Long idUsuario,
        String nome,
        String email,
        LocalDate dataNascimento
) {

    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getIdUsuario(), usuario.getNome(), usuario.getEmail(), usuario.getDataNascimento());
    }
}