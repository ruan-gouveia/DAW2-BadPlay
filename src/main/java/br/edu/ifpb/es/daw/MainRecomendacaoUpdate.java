package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.RecomendacaoDAO;
import br.edu.ifpb.es.daw.dao.impl.RecomendacaoDAOImpl;
import br.edu.ifpb.es.daw.entities.Recomendacao;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainRecomendacaoUpdate {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            RecomendacaoDAO dao = new RecomendacaoDAOImpl(emf);

            Recomendacao r = dao.getByID(1L);
            if (r != null) {
                System.out.println("Motivo antigo: " + r.getMotivo());

                r.setMotivo("Motivo atualizado via teste Update: " + System.nanoTime());

                dao.update(r);
                System.out.println("Recomendação atualizada com sucesso: " + r);
            } else {
                System.out.println("Recomendação não encontrada para atualizar.");
            }
        }
    }
}