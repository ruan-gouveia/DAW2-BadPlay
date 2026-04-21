package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.HistoricoDAO;
import br.edu.ifpb.es.daw.dao.impl.HistoricoDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainHistoricoDeleteById {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            HistoricoDAO dao = new HistoricoDAOImpl(emf);

            try {
                dao.delete(1L);
                System.out.println("Registro de histórico removido com sucesso!");
            } catch (Exception e) {
                System.err.println("Erro ao remover o histórico: " + e.getMessage());
            }
        }
    }
}