package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.EpisodioDAO;
import br.edu.ifpb.es.daw.entities.Episodio;
import jakarta.persistence.EntityManagerFactory;

public class EpisodioDAOImpl extends AbstractDAOImpl<Episodio, Long> implements EpisodioDAO {
    public EpisodioDAOImpl(EntityManagerFactory emf) {
        super(Episodio.class, emf);
    }
}