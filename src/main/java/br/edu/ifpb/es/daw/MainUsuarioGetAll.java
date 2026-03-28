package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.UsuarioDAO;
import br.edu.ifpb.es.daw.dao.impl.UsuarioDAOImpl;
import br.edu.ifpb.es.daw.entities.Usuario;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class MainUsuarioGetAll {

    public static void main(String[] args) throws PersistenciaDawException {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {

            UsuarioDAO dao = new UsuarioDAOImpl(emf);

            List<Usuario> usuarios = dao.getAll();

            for (Usuario usuario : usuarios){
                System.out.println(usuario);
            }
        }
    }
}
