package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.PlanoDAO;
import br.edu.ifpb.es.daw.entities.Plano;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.util.List;

public class PlanoDAOImpl extends AbstractDAOImpl<Plano, Long> implements PlanoDAO {

    public PlanoDAOImpl(EntityManagerFactory emf) {
        super(Plano.class, emf);
    }

    @Override
    public List<Plano> findByValorBetween(BigDecimal min, BigDecimal max) {
        String jpql = "SELECT p FROM Plano p WHERE p.valor BETWEEN :min AND :max";
        TypedQuery<Plano> query = getEntityManager().createQuery(jpql, Plano.class);
        query.setParameter("min", min);
        query.setParameter("max", max);
        return query.getResultList();
    }
}