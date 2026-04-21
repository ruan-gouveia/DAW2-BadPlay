package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AvaliacaoDAO;
import br.edu.ifpb.es.daw.dao.impl.AvaliacaoDAOImpl;
import br.edu.ifpb.es.daw.entities.Avaliacao;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainAvaliacaoGetById {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            AvaliacaoDAO dao = new AvaliacaoDAOImpl(emf);

            Avaliacao a = dao.getByID(1L);

            if (a != null) {
                System.out.println("Avaliação encontrada: " + a);
            } else {
                System.out.println("Avaliação não encontrada.");
            }
        }
    }
}