package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.AvaliacaoDAO;
import br.edu.ifpb.es.daw.dao.DAO;
import br.edu.ifpb.es.daw.entities.Avaliacao;
import br.edu.ifpb.es.daw.entities.Conteudo;
import br.edu.ifpb.es.daw.entities.Usuario;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AvaliacaoDAOImpl extends AbstractDAOImpl <Avaliacao, Long > implements AvaliacaoDAO {
    public AvaliacaoDAOImpl(EntityManagerFactory emf) {
        super(Avaliacao.class, emf);
    }

    @Override
    public List<Avaliacao> findByUsuario(Usuario usuario) {
        String jpql = "SELECT a FROM Avaliacao a WHERE a.usuario = :usuario";
        TypedQuery<Avaliacao> query = getEntityManager().createQuery(jpql, Avaliacao.class);
        query.setParameter("usuario", usuario);
        return query.getResultList();
    }

    @Override
    public Double getMediaNotasByConteudo(Conteudo conteudo) {
        String jpql = "SELECT AVG(a.nota) FROM Avaliacao a WHERE a.conteudo = :conteudo";
        TypedQuery<Double> query = getEntityManager().createQuery(jpql, Double.class);
        query.setParameter("conteudo", conteudo);
        return query.getSingleResult();
    }
}