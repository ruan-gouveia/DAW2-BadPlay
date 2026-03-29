package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.EpisodioDAO;
import br.edu.ifpb.es.daw.dao.impl.EpisodioDAOImpl;
import br.edu.ifpb.es.daw.entities.Episodio;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEpisodioUpdate {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            EpisodioDAO dao = new EpisodioDAOImpl(emf);
            Episodio ep = dao.getByID(1L);
            if (ep != null) {
                ep.setDuracao(50);
                dao.update(ep);
                System.out.println("Episódio atualizado: " + ep);
            }
        }
    }
}