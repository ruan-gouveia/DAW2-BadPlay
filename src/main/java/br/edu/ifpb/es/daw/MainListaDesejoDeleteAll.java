package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ListaDesejoDAO;
import br.edu.ifpb.es.daw.dao.impl.ListaDesejoDAOImpl;
import br.edu.ifpb.es.daw.entities.ListaDesejo;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainListaDesejoDeleteAll {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            ListaDesejoDAO dao = new ListaDesejoDAOImpl(emf);
            for (ListaDesejo lista : dao.getAll()) {
                dao.delete(lista.getIdLista());
            }
            System.out.println("Todas as listas de desejos foram removidas.");
        }
    }
}