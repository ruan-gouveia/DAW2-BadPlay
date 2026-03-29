package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.FilmeDAO;
import br.edu.ifpb.es.daw.dao.impl.FilmeDAOImpl;
import br.edu.ifpb.es.daw.entities.Filme;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainFilmeUpdate {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            FilmeDAO dao = new FilmeDAOImpl(emf);
            Filme f = dao.getByID(1L);
            if (f != null) {
                f.setDuracao(150);
                dao.update(f);
                System.out.println("Filme atualizado: " + f);
            }
        }
    }
}