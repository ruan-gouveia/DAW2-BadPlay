package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.FilmeDAO;
import br.edu.ifpb.es.daw.dao.impl.FilmeDAOImpl;
import br.edu.ifpb.es.daw.entities.Filme;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainFilmeSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            FilmeDAO dao = new FilmeDAOImpl(emf);
            Filme f = new Filme();
            f.setUrlFilme("http://badplay.com/filme/" + System.nanoTime());
            f.setDuracao(120);
            dao.save(f);
            System.out.println("Filme salvo: " + f);
        }
    }
}