package br.edu.ifpb.es.daw.dao.impl;

import jakarta.persistence.EntityManagerFactory;

public class HistoricoDAOImpl extends AbstractDAOImpl{
    public HistoricoDAOImpl(Class entityClass, EntityManagerFactory emf) {
        super(entityClass, emf);
    }
}
