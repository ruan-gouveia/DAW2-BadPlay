package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.HistoricoDAO;
import br.edu.ifpb.es.daw.entities.Historico;
import jakarta.persistence.EntityManagerFactory;

public class HistoricoDAOImpl extends AbstractDAOImpl<Historico, Long> implements HistoricoDAO {

    public HistoricoDAOImpl(EntityManagerFactory emf) {
        super(Historico.class, emf);
    }
}
