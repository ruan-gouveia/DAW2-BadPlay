package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.RecomendacaoDAO;
import br.edu.ifpb.es.daw.dao.impl.RecomendacaoDAOImpl;
import br.edu.ifpb.es.daw.entities.Recomendacao;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class MainRecomendacaoDeleteAll {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            RecomendacaoDAO dao = new RecomendacaoDAOImpl(emf);
            List<Recomendacao> recomendacoes = dao.getAll();

            for (Recomendacao r : recomendacoes) {
                dao.delete(r.getId());
            }
            System.out.println("Todas as Recomendações foram removidas com sucesso!");
        }
    }
}