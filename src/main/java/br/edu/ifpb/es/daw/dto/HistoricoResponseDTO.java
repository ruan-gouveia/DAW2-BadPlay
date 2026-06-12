package br.edu.ifpb.es.daw.dto;

import br.edu.ifpb.es.daw.entities.Historico;
import java.time.LocalDateTime;

public record HistoricoResponseDTO(
        Long id,
        Long idConteudo,
        String tituloConteudo,
        Long idUsuario,
        String nomeUsuario,
        LocalDateTime timestamp
) {
    public HistoricoResponseDTO(Historico h) {
        this(
                h.getId(),
                h.getConteudo().getIdConteudo(),
                h.getConteudo().getTitulo(),
                h.getUsuario().getIdUsuario(),
                h.getUsuario().getNome(),
                h.getTimestamp()
        );
    }
}