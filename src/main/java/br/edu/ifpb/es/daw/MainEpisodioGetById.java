package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.EpisodioDAO;
import br.edu.ifpb.es.daw.dao.impl.EpisodioDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEpisodioGetById {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            EpisodioDAO dao = new EpisodioDAOImpl(emf);
            System.out.println(dao.getByID(1L));
        }
    }
}