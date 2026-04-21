package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AssinaturaDAO;
import br.edu.ifpb.es.daw.dao.impl.AssinaturaDAOImpl;
import br.edu.ifpb.es.daw.entities.Assinatura;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class MainAssinaturaDeleteAll {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            AssinaturaDAO dao = new AssinaturaDAOImpl(emf);
            List<Assinatura> assinaturas = dao.getAll();

            for (Assinatura a : assinaturas) {
                dao.delete(a.getId());
            }
            System.out.println("Todas as Assinaturas foram removidas com sucesso!");
        }
    }
}