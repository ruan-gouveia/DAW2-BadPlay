package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.RecomendacaoDAO;
import br.edu.ifpb.es.daw.dao.impl.RecomendacaoDAOImpl;
import br.edu.ifpb.es.daw.entities.Recomendacao;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class MainRecomendacaoGetAll {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            RecomendacaoDAO dao = new RecomendacaoDAOImpl(emf);
            List<Recomendacao> lista = dao.getAll();

            System.out.println("--- Lista de Recomendações ---");
            lista.forEach(System.out::println);
        }
    }
}