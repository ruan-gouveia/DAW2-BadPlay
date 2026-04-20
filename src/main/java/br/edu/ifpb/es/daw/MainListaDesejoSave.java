package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ListaDesejoDAO;
import br.edu.ifpb.es.daw.dao.UsuarioDAO;
import br.edu.ifpb.es.daw.dao.impl.ListaDesejoDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.UsuarioDAOImpl;
import br.edu.ifpb.es.daw.entities.ListaDesejo;
import br.edu.ifpb.es.daw.entities.Usuario;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainListaDesejoSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            ListaDesejoDAO dao = new ListaDesejoDAOImpl(emf);
            UsuarioDAO uDAO = new UsuarioDAOImpl(emf);

            Usuario u = uDAO.getByID(1L);

            ListaDesejo lista = new ListaDesejo();

            lista.setNome("Minha Lista " + System.nanoTime());
            lista.setDataCriacao(LocalDateTime.now());
            lista.setUsuario(u);

            dao.save(lista);
            System.out.println("Lista de Desejos salva: " + lista);
        }
    }
}