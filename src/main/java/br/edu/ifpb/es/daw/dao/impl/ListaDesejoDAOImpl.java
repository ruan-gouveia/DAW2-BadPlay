package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.ListaDesejoDAO;
import br.edu.ifpb.es.daw.entities.ListaDesejo;
import jakarta.persistence.EntityManagerFactory;

public class ListaDesejoDAOImpl extends AbstractDAOImpl<ListaDesejo, Long> implements ListaDesejoDAO {
    public ListaDesejoDAOImpl(EntityManagerFactory emf) {
        super(ListaDesejo.class, emf);
    }
}