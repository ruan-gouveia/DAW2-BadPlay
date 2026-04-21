package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AssinaturaDAO;
import br.edu.ifpb.es.daw.dao.impl.AssinaturaDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainAssinaturaDeleteById {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            AssinaturaDAO dao = new AssinaturaDAOImpl(emf);

            try {
                dao.delete(1L);
                System.out.println("Assinatura removida com sucesso.");
            } catch (Exception e) {
                System.err.println("Erro ao remover: " + e.getMessage());
            }
        }
    }
}