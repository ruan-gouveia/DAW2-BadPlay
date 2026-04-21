package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.HistoricoDAO;
import br.edu.ifpb.es.daw.dao.impl.HistoricoDAOImpl;
import br.edu.ifpb.es.daw.entities.Historico;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class MainHistoricoDeleteAll {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            HistoricoDAO dao = new HistoricoDAOImpl(emf);
            List<Historico> historicos = dao.getAll();

            for (Historico h : historicos) {
                dao.delete(h.getId());
            }
            System.out.println("Todo o Histórico foi removido com sucesso!");
        }
    }
}