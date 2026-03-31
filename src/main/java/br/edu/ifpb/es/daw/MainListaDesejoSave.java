package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ListaDesejoDAO;
import br.edu.ifpb.es.daw.dao.impl.ListaDesejoDAOImpl;
import br.edu.ifpb.es.daw.entities.ListaDesejo;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainListaDesejoSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            ListaDesejoDAO dao = new ListaDesejoDAOImpl(emf);
            ListaDesejo lista = new ListaDesejo();

            lista.setNome("Minha Lista " + System.nanoTime());
            lista.setDataCriacao(LocalDateTime.now());

            dao.save(lista);
            System.out.println("Lista de Desejos salva: " + lista);
        }
    }
}