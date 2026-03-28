package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.ConteudoDAO;
import br.edu.ifpb.es.daw.entities.Conteudo;
import jakarta.persistence.EntityManagerFactory;

public class ConteudoDAOImpl extends AbstractDAOImpl<Conteudo, Long> implements ConteudoDAO {
    public ConteudoDAOImpl(EntityManagerFactory emf) {
        super(Conteudo.class, emf);
    }
}