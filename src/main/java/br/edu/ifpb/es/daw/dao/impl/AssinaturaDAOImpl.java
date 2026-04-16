package br.edu.ifpb.es.daw.dao.impl;

import jakarta.persistence.EntityManagerFactory;

public class AssinaturaDAOImpl extends AbstractDAOImpl{
    public AssinaturaDAOImpl(Class entityClass, EntityManagerFactory emf) {
        super(entityClass, emf);
    }
}
