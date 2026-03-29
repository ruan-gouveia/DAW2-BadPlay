package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PlanoDAO;
import br.edu.ifpb.es.daw.dao.impl.PlanoDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainPlanoDeleteById {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            PlanoDAO dao = new PlanoDAOImpl(emf);

            Long idParaRemover = 1L;

            try {
                dao.delete(idParaRemover);
                System.out.println("Plano com ID " + idParaRemover + " removido com sucesso (se existia no banco).");
            } catch (Exception e) {
                System.err.println("Erro ao tentar remover o plano: " + e.getMessage());
            }
        }
    }
}