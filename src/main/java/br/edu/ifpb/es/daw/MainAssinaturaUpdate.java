package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AssinaturaDAO;
import br.edu.ifpb.es.daw.dao.impl.AssinaturaDAOImpl;
import br.edu.ifpb.es.daw.entities.Assinatura;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainAssinaturaUpdate {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            AssinaturaDAO dao = new AssinaturaDAOImpl(emf);

            Assinatura a = dao.getByID(1L);
            if (a != null) {
                System.out.println("Status antigo: " + a.getStatus());

                a.setStatus("CANCELADA");

                dao.update(a);
                System.out.println("Assinatura atualizada com sucesso: " + a);
            }
        }
    }
}