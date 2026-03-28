package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.TemporadaDAO;
import br.edu.ifpb.es.daw.entities.Temporada;
import jakarta.persistence.EntityManagerFactory;

public class TemporadaDAOImpl extends AbstractDAOImpl<Temporada, Long> implements TemporadaDAO {
    public TemporadaDAOImpl(EntityManagerFactory emf) {
        super(Temporada.class, emf);
    }
}