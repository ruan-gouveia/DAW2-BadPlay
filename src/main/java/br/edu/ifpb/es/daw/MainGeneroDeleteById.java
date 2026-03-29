package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.GeneroDAO;
import br.edu.ifpb.es.daw.dao.impl.GeneroDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainGeneroDeleteById {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            GeneroDAO dao = new GeneroDAOImpl(emf);
            dao.delete(1L);
            System.out.println("Removido com sucesso.");
        }
    }
}