package br.edu.ifpb.es.daw.dto;

import br.edu.ifpb.es.daw.entities.Plano;
import br.edu.ifpb.es.daw.entities.TipoPlano;
import java.math.BigDecimal;

public record PlanoResponseDTO(Long idAssinatura, TipoPlano tipo, BigDecimal valor) {
    public PlanoResponseDTO(Plano plano) {
        this(plano.getIdAssinatura(), plano.getTipo(), plano.getValor());
    }
}