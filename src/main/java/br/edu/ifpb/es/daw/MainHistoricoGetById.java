package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.HistoricoDAO;
import br.edu.ifpb.es.daw.dao.impl.HistoricoDAOImpl;
import br.edu.ifpb.es.daw.entities.Historico;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainHistoricoGetById {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            HistoricoDAO dao = new HistoricoDAOImpl(emf);

            Historico h = dao.getByID(1L);

            if (h != null) {
                System.out.println("Registro de histórico encontrado: " + h);
            } else {
                System.out.println("Nenhum registro de histórico encontrado.");
            }
        }
    }
}