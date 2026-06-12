package br.edu.ifpb.es.daw.dto;

import br.edu.ifpb.es.daw.entities.Temporada;

public record TemporadaResponseDTO(Long idTemporada, Integer numeroTemporada, Long idSerie) {
    public TemporadaResponseDTO(Temporada t) {
        this(t.getIdTemporada(), t.getNumeroTemporada(), t.getSerie().getIdConteudo());
    }
}