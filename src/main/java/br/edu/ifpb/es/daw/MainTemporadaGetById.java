package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.TemporadaDAO;
import br.edu.ifpb.es.daw.dao.impl.TemporadaDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainTemporadaGetById {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            TemporadaDAO dao = new TemporadaDAOImpl(emf);
            System.out.println(dao.getByID(1L));
        }
    }
}