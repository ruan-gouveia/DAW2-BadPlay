package br.edu.ifpb.es.daw.dto;

import br.edu.ifpb.es.daw.entities.Genero;

public record GeneroResponseDTO(Long idGenero, String nome, String descricao) {
    public GeneroResponseDTO(Genero genero) {
        this(genero.getIdGenero(), genero.getNome(), genero.getDescricao());
    }
}