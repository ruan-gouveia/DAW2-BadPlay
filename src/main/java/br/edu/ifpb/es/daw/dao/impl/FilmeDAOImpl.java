package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.FilmeDAO;
import br.edu.ifpb.es.daw.entities.Filme;
import jakarta.persistence.EntityManagerFactory;

public class FilmeDAOImpl extends AbstractDAOImpl<Filme, Long> implements FilmeDAO {
    public FilmeDAOImpl(EntityManagerFactory emf) {
        super(Filme.class, emf);
    }
}