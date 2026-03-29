package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.EpisodioDAO;
import br.edu.ifpb.es.daw.dao.impl.EpisodioDAOImpl;
import br.edu.ifpb.es.daw.entities.Episodio;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEpisodioDeleteAll {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            EpisodioDAO dao = new EpisodioDAOImpl(emf);
            for (Episodio ep : dao.getAll()) {
                dao.delete(ep.getIdEpisodio());
            }
            System.out.println("Todos os episódios removidos.");
        }
    }
}