package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.GeneroDAO;
import br.edu.ifpb.es.daw.dao.impl.GeneroDAOImpl;
import br.edu.ifpb.es.daw.entities.Genero;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainGeneroUpdate {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            GeneroDAO dao = new GeneroDAOImpl(emf);
            Genero g = dao.getByID(1L);
            if (g != null) {

                g.setNome("Drama " + System.nanoTime());
                dao.update(g);
                System.out.println("Atualizado: " + g);
            }
        }
    }
}