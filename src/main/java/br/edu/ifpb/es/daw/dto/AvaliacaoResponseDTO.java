package br.edu.ifpb.es.daw.dto;

import br.edu.ifpb.es.daw.entities.Avaliacao;

public record AvaliacaoResponseDTO(Long id, Double nota, String nomeUsuario, String tituloConteudo) {
    public AvaliacaoResponseDTO(Avaliacao a) {
        this(a.getId(), a.getNota(), a.getUsuario().getNome(), a.getConteudo().getTitulo());
    }
}