package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ConteudoDAO;
import br.edu.ifpb.es.daw.dao.impl.ConteudoDAOImpl;
import br.edu.ifpb.es.daw.entities.Conteudo;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainConteudoGetAll {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            ConteudoDAO dao = new ConteudoDAOImpl(emf);
            dao.getAll().forEach(System.out::println);
        }
    }
}