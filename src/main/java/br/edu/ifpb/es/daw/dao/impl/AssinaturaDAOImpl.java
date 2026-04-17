package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.entities.Usuario;
import jakarta.persistence.EntityManagerFactory;

public class AssinaturaDAOImpl extends AbstractDAOImpl{
    public AssinaturaDAOImpl(EntityManagerFactory emf) {

        super(Usuario.class, emf);
    }
}
