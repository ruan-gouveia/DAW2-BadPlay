package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.GeneroDAO;
import br.edu.ifpb.es.daw.dao.impl.GeneroDAOImpl;
import br.edu.ifpb.es.daw.entities.Genero;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainGeneroDeleteAll {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            GeneroDAO dao = new GeneroDAOImpl(emf);
            for (Genero g : dao.getAll()) {
                dao.delete(g.getIdGenero());
            }
            System.out.println("Todos removidos.");
        }
    }
}