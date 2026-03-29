package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.SerieDAO;
import br.edu.ifpb.es.daw.dao.impl.SerieDAOImpl;
import br.edu.ifpb.es.daw.entities.Serie;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainSerieSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            SerieDAO dao = new SerieDAOImpl(emf);
            Serie s = new Serie();
            dao.save(s);
            System.out.println("Série salva com ID: " + s.getIdSerie());
        }
    }
}