package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ListaDesejoDAO;
import br.edu.ifpb.es.daw.dao.impl.ListaDesejoDAOImpl;
import br.edu.ifpb.es.daw.entities.ListaDesejo;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainListaDesejoUpdate {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            ListaDesejoDAO dao = new ListaDesejoDAOImpl(emf);
            ListaDesejo lista = dao.getByID(1L);
            if (lista != null) {
                lista.setNome("Favoritos " + System.nanoTime());
                dao.update(lista);
                System.out.println("Lista atualizada: " + lista);
            }
        }
    }
}