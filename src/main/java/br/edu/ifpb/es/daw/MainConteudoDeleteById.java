package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ConteudoDAO;
import br.edu.ifpb.es.daw.dao.impl.ConteudoDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainConteudoDeleteById {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            ConteudoDAO dao = new ConteudoDAOImpl(emf);
            dao.delete(1L);
            System.out.println("Removido com sucesso.");
        }
    }
}