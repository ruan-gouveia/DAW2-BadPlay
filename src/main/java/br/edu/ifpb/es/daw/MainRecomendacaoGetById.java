package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.RecomendacaoDAO;
import br.edu.ifpb.es.daw.dao.impl.RecomendacaoDAOImpl;
import br.edu.ifpb.es.daw.entities.Recomendacao;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainRecomendacaoGetById {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            RecomendacaoDAO dao = new RecomendacaoDAOImpl(emf);

            Recomendacao r = dao.getByID(1L);

            if (r != null) {
                System.out.println("Recomendação encontrada: " + r);
            } else {
                System.out.println("Nenhuma recomendação encontrada com este ID.");
            }
        }
    }
}