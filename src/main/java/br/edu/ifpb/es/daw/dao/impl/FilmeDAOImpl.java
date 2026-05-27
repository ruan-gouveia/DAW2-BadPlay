package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.FilmeDAO;
import br.edu.ifpb.es.daw.entities.Filme;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class FilmeDAOImpl extends AbstractDAOImpl<Filme, Long> implements FilmeDAO {
    public FilmeDAOImpl(EntityManagerFactory emf) {
        super(Filme.class, emf);
    }

    @Override
    public List<Filme> findByDuracaoMaiorQue(Integer duracaoMinima) {
        String jpql = "SELECT f FROM Filme f WHERE f.duracao > :duracao";
        TypedQuery<Filme> query = getEntityManager().createQuery(jpql, Filme.class);
        query.setParameter("duracao", duracaoMinima);
        return query.getResultList();
    }
}