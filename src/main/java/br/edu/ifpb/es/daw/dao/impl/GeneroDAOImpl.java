package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.GeneroDAO;
import br.edu.ifpb.es.daw.entities.Genero;
import jakarta.persistence.EntityManagerFactory;

public class GeneroDAOImpl extends AbstractDAOImpl<Genero, Long> implements GeneroDAO {
    public GeneroDAOImpl(EntityManagerFactory emf) {
        super(Genero.class, emf);
    }
}