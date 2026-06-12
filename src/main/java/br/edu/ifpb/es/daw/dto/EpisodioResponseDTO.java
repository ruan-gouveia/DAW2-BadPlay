package br.edu.ifpb.es.daw.dto;

import br.edu.ifpb.es.daw.entities.Episodio;

public record EpisodioResponseDTO(
        Long idEpisodio,
        String nomeEpisodio,
        Integer numeroEpisodio,
        Integer duracaoMinutos,
        String urlEpisodio,
        Long idTemporada
) {
    public EpisodioResponseDTO(Episodio ep) {
        this(
                ep.getIdEpisodio(),
                ep.getNomeEpisodio(),
                ep.getNumeroEpisodio(),
                ep.getDuracao(),
                ep.getUrlEpisodio(),
                ep.getTemporada().getIdTemporada()
        );
    }
}