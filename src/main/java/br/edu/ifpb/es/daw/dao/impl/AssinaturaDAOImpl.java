package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.AssinaturaDAO;
import br.edu.ifpb.es.daw.entities.Assinatura;
import br.edu.ifpb.es.daw.entities.Usuario;
import jakarta.persistence.EntityManagerFactory;

public class AssinaturaDAOImpl extends AbstractDAOImpl<Assinatura, Long> implements AssinaturaDAO {
    public AssinaturaDAOImpl(EntityManagerFactory emf) {

        super(Assinatura.class, emf);
    }
}
