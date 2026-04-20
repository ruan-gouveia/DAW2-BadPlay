package br.edu.ifpb.es.daw;
import br.edu.ifpb.es.daw.dao.HistoricoDAO;
import br.edu.ifpb.es.daw.dao.impl.HistoricoDAOImpl;
import br.edu.ifpb.es.daw.entities.Conteudo;
import br.edu.ifpb.es.daw.entities.Historico;
import br.edu.ifpb.es.daw.entities.Usuario;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MainHistoricoSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {

            HistoricoDAO hdao = new HistoricoDAOImpl(emf);
            Usuario u = new Usuario(); // ... preencher e salvar u
            Conteudo c = new Conteudo(); // ... preencher e salvar c

            Historico h = new Historico();
            h.setData(LocalDate.now());
            h.setHora(LocalDate.from(LocalTime.now()));
            h.setUsuario(u);  // Link
            h.setConteudo(c); // Link

            hdao.save(h);
        }
    }
}
