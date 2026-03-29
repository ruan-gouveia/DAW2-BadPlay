package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.EpisodioDAO;
import br.edu.ifpb.es.daw.dao.impl.EpisodioDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEpisodioGetAll {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            EpisodioDAO dao = new EpisodioDAOImpl(emf);
            dao.getAll().forEach(System.out::println);
        }
    }
}