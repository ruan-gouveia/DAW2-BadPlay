package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.UsuarioDAO;
import br.edu.ifpb.es.daw.dao.impl.UsuarioDAOImpl;
import br.edu.ifpb.es.daw.entities.Usuario;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class MainUsuarioSave {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu");
        UsuarioDAO dao = new UsuarioDAOImpl(emf);

        try {
            Usuario usuario = new Usuario();
            usuario.setNome("João da Silva");

            usuario.setEmail("joao" + System.nanoTime() + "@badplay.com");
            usuario.setSenha("senha123");
            usuario.setDataNascimento(LocalDate.of(1995, 8, 20));

            dao.save(usuario);
            System.out.println("Usuário salvo com sucesso: " + usuario);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            emf.close();
        }
    }
}