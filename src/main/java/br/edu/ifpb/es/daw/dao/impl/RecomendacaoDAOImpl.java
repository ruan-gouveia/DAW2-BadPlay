package br.edu.ifpb.es.daw.dao.impl;

import jakarta.persistence.EntityManagerFactory;

public class RecomendacaoDAOImpl extends AbstractDAOImpl{
    public RecomendacaoDAOImpl(Class entityClass, EntityManagerFactory emf) {
        super(entityClass, emf);
    }
}
