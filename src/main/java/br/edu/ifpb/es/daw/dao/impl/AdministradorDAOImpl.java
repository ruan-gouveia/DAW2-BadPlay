package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.AdministradorDAO;
import br.edu.ifpb.es.daw.entities.Administrador;
import jakarta.persistence.EntityManagerFactory;

public class AdministradorDAOImpl extends AbstractDAOImpl<Administrador, Long> implements AdministradorDAO {
    public AdministradorDAOImpl(EntityManagerFactory emf) {
        super(Administrador.class, emf);
    }
}