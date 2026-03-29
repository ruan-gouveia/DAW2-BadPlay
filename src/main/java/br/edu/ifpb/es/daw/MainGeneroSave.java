package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.GeneroDAO;
import br.edu.ifpb.es.daw.dao.impl.GeneroDAOImpl;
import br.edu.ifpb.es.daw.entities.Genero;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainGeneroSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            GeneroDAO dao = new GeneroDAOImpl(emf);
            Genero g = new Genero();

            g.setNome("Ficção Científica " + System.nanoTime());
            g.setDescricao("Filmes de exploração espacial e futurismo.");
            dao.save(g);
            System.out.println("Salvo: " + g);
        }
    }
}