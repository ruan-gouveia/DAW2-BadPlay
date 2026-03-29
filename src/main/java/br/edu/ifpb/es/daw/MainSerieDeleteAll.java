package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.SerieDAO;
import br.edu.ifpb.es.daw.dao.impl.SerieDAOImpl;
import br.edu.ifpb.es.daw.entities.Serie;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainSerieDeleteAll {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            SerieDAO dao = new SerieDAOImpl(emf);
            for (Serie s : dao.getAll()) {
                dao.delete(s.getIdSerie());
            }
            System.out.println("Todas as séries removidas.");
        }
    }
}