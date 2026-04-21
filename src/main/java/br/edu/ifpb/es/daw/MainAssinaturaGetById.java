package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AssinaturaDAO;
import br.edu.ifpb.es.daw.dao.impl.AssinaturaDAOImpl;
import br.edu.ifpb.es.daw.entities.Assinatura;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainAssinaturaGetById {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            AssinaturaDAO dao = new AssinaturaDAOImpl(emf);

            Assinatura a = dao.getByID(1L);

            if (a != null) {
                System.out.println("Assinatura encontrada: " + a);
            } else {
                System.out.println("Assinatura não encontrada.");
            }
        }
    }
}