package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.TemporadaDAO;
import br.edu.ifpb.es.daw.dao.impl.TemporadaDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainTemporadaGetAll {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            TemporadaDAO dao = new TemporadaDAOImpl(emf);
            dao.getAll().forEach(System.out::println);
        }
    }
}