package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.UsuarioDAO;
import br.edu.ifpb.es.daw.entities.Usuario;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UsuarioDAOImpl extends AbstractDAOImpl<Usuario, Long> implements UsuarioDAO {
    public UsuarioDAOImpl(EntityManagerFactory emf) {
        super(Usuario.class, emf);
    }

    @Override
    public Usuario findByIdWithAssinaturas(Long idUsuario) {
        String jpql = "SELECT u FROM Usuario u LEFT JOIN FETCH u.assinaturas WHERE u.id = :id";
        TypedQuery<Usuario> query = getEntityManager().createQuery(jpql, Usuario.class);
        query.setParameter("id", idUsuario);
        List<Usuario> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }
}