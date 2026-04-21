package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.RecomendacaoDAO;
import br.edu.ifpb.es.daw.dao.impl.RecomendacaoDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainRecomendacaoDeleteById {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            RecomendacaoDAO dao = new RecomendacaoDAOImpl(emf);

            try {
                dao.delete(1L);
                System.out.println("Recomendação removida com sucesso!");
            } catch (Exception e) {
                System.err.println("Erro ao remover recomendação: " + e.getMessage());
            }
        }
    }
}