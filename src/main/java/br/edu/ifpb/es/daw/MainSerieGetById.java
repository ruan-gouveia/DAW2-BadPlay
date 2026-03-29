package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.SerieDAO;
import br.edu.ifpb.es.daw.dao.impl.SerieDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainSerieGetById {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            SerieDAO dao = new SerieDAOImpl(emf);
            System.out.println(dao.getByID(1L));
        }
    }
}