package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.HistoricoDAO;
import br.edu.ifpb.es.daw.dao.impl.HistoricoDAOImpl;
import br.edu.ifpb.es.daw.entities.Historico;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class MainHistoricoUpdate {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            HistoricoDAO dao = new HistoricoDAOImpl(emf);

            Historico h = dao.getByID(1L);
            if (h != null) {
                System.out.println("Hora antiga: " + h.getHora());

                h.setHora(LocalDateTime.from(LocalTime.now().truncatedTo(ChronoUnit.SECONDS)));

                dao.update(h);
                System.out.println("Histórico atualizado com sucesso: " + h);
            } else {
                System.out.println("Registro de histórico não encontrado para atualizar.");
            }
        }
    }
}