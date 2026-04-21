package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AvaliacaoDAO;
import br.edu.ifpb.es.daw.dao.impl.AvaliacaoDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainAvaliacaoDeleteById {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            AvaliacaoDAO dao = new AvaliacaoDAOImpl(emf);

            try {
                dao.delete(1L);
                System.out.println("Avaliação removida com sucesso!");
            } catch (Exception e) {
                System.err.println("Erro ao remover a avaliação: " + e.getMessage());
            }
        }
    }
}