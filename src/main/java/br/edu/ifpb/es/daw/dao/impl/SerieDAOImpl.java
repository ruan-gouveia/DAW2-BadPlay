package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.SerieDAO;
import br.edu.ifpb.es.daw.entities.Serie;
import jakarta.persistence.EntityManagerFactory;

public class SerieDAOImpl extends AbstractDAOImpl<Serie, Long> implements SerieDAO {
    public SerieDAOImpl(EntityManagerFactory emf) {
        super(Serie.class, emf);
    }
}