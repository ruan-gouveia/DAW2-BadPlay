package br.edu.ifpb.es.daw.dao;
import br.edu.ifpb.es.daw.entities.Plano;

import java.math.BigDecimal;
import java.util.List;

public interface PlanoDAO extends DAO<Plano, Long> {

    List<Plano> findByValorBetween(BigDecimal min, BigDecimal max);

}