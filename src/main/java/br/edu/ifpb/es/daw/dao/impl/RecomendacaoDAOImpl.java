package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.RecomendacaoDAO;
import br.edu.ifpb.es.daw.entities.Recomendacao;
import jakarta.persistence.EntityManagerFactory;

public class RecomendacaoDAOImpl extends AbstractDAOImpl<Recomendacao, Long> implements RecomendacaoDAO {

    public RecomendacaoDAOImpl(EntityManagerFactory emf) {
        super(Recomendacao.class, emf);
    }
}
