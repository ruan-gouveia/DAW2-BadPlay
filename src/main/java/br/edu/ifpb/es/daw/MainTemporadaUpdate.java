package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.TemporadaDAO;
import br.edu.ifpb.es.daw.dao.impl.TemporadaDAOImpl;
import br.edu.ifpb.es.daw.entities.Temporada;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainTemporadaUpdate {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            TemporadaDAO dao = new TemporadaDAOImpl(emf);
            Temporada t = dao.getByID(1L);
            if (t != null) {
                t.setNumeroTemporada(2);
                dao.update(t);
                System.out.println("Temporada atualizada: " + t);
            }
        }
    }
}