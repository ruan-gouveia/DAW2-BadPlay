package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AvaliacaoDAO;
import br.edu.ifpb.es.daw.dao.impl.AvaliacaoDAOImpl;
import br.edu.ifpb.es.daw.entities.Avaliacao;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class MainAvaliacaoDeleteAll {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            AvaliacaoDAO dao = new AvaliacaoDAOImpl(emf);
            List<Avaliacao> avaliacoes = dao.getAll();

            for (Avaliacao a : avaliacoes) {
                dao.delete(a.getId());
            }
            System.out.println("Todas as Avaliações foram removidas com sucesso!");
        }
    }
}