package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PlanoDAO;
import br.edu.ifpb.es.daw.dao.impl.PlanoDAOImpl;
import br.edu.ifpb.es.daw.entities.Plano;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainPlanoGetById {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            PlanoDAO dao = new PlanoDAOImpl(emf);

            Long idBuscado = 1L;
            Plano plano = dao.getByID(idBuscado);

            if (plano != null) {
                System.out.println("Plano encontrado: " + plano);
            } else {
                System.out.println("Nenhum plano encontrado com o ID: " + idBuscado);
            }
        }
    }
}