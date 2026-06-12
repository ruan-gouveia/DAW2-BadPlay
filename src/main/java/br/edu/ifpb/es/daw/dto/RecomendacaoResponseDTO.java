package br.edu.ifpb.es.daw.dto;

import br.edu.ifpb.es.daw.entities.Recomendacao;

public record RecomendacaoResponseDTO(Long id, String tituloConteudo, String nomeUsuario, String motivo) {
    public RecomendacaoResponseDTO(Recomendacao r) {
        this(
                r.getId(),
                r.getConteudo().getTitulo(),
                r.getUsuario().getNome(),
                r.getMotivo()
        );
    }
}