package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.FilmeDAO;
import br.edu.ifpb.es.daw.dao.impl.FilmeDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainFilmeDeleteById {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            FilmeDAO dao = new FilmeDAOImpl(emf);
            dao.delete(1L);
            System.out.println("Filme removido.");
        }
    }
}