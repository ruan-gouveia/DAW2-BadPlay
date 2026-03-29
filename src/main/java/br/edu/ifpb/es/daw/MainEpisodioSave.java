package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.EpisodioDAO;
import br.edu.ifpb.es.daw.dao.impl.EpisodioDAOImpl;
import br.edu.ifpb.es.daw.entities.Episodio;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEpisodioSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            EpisodioDAO dao = new EpisodioDAOImpl(emf);
            Episodio ep = new Episodio();
            ep.setNumeroEpisodio(1);
            ep.setDuracao(45);
            ep.setUrlEpisodio("http://badplay.com/ep/" + System.nanoTime());
            dao.save(ep);
            System.out.println("Episódio salvo: " + ep);
        }
    }
}