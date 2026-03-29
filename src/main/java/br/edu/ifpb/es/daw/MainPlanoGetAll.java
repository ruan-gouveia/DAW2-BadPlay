package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PlanoDAO;
import br.edu.ifpb.es.daw.dao.impl.PlanoDAOImpl;
import br.edu.ifpb.es.daw.entities.Plano;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainPlanoGetAll {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            PlanoDAO dao = new PlanoDAOImpl(emf);

            List<Plano> planos = dao.getAll();
            System.out.println("--- Lista de Planos ---");
            for (Plano plano : planos) {
                System.out.println(plano);
            }
        }
    }
}