package br.edu.ifpb.es.daw.dao.impl;

import jakarta.persistence.EntityManagerFactory;

public class AvaliacaoDAOImpl extends AbstractDAOImpl{
    public AvaliacaoDAOImpl(Class entityClass, EntityManagerFactory emf) {
        super(entityClass, emf);
    }
}
