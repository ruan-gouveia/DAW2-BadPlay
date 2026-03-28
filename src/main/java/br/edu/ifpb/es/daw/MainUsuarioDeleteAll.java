package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.UsuarioDAO;
import br.edu.ifpb.es.daw.dao.impl.UsuarioDAOImpl;
import br.edu.ifpb.es.daw.entities.Usuario;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainUsuarioDeleteAll {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu");
        UsuarioDAO dao = new UsuarioDAOImpl(emf);

        try {
            List<Usuario> usuarios = dao.getAll();
            for (Usuario u : usuarios) {
                dao.delete(u.getIdUsuario());
            }
            System.out.println("Todos os Usuários foram removidos do banco!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            emf.close();
        }
    }
}