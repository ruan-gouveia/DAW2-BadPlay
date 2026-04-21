package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AssinaturaDAO;
import br.edu.ifpb.es.daw.dao.impl.AssinaturaDAOImpl;
import br.edu.ifpb.es.daw.entities.Assinatura;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class MainAssinaturaGetAll {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            AssinaturaDAO dao = new AssinaturaDAOImpl(emf);
            List<Assinatura> lista = dao.getAll();
            lista.forEach(System.out::println);
        }
    }
}