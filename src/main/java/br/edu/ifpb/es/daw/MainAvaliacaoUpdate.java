package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AvaliacaoDAO;
import br.edu.ifpb.es.daw.dao.impl.AvaliacaoDAOImpl;
import br.edu.ifpb.es.daw.entities.Avaliacao;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainAvaliacaoUpdate {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            AvaliacaoDAO dao = new AvaliacaoDAOImpl(emf);

            Avaliacao a = dao.getByID(1L);
            if (a != null) {
                System.out.println("Nota antiga: " + a.getNota());

                a.setNota(5.0);

                dao.update(a);
                System.out.println("Avaliação atualizada com sucesso: " + a);
            } else {
                System.out.println("Nenhuma avaliação encontrada para atualizar.");
            }
        }
    }
}