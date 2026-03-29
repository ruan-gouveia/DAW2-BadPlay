package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ListaDesejoDAO;
import br.edu.ifpb.es.daw.dao.impl.ListaDesejoDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainListaDesejoGetAll {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            ListaDesejoDAO dao = new ListaDesejoDAOImpl(emf);
            dao.getAll().forEach(System.out::println);
        }
    }
}