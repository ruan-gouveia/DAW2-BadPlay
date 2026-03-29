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
            usuario.setNome("Ruan Gouveia");

            usuario.setEmail("ruan" + System.nanoTime() + "@gmail.com");
            usuario.setSenha("pressao12345");
            usuario.setDataNascimento(LocalDate.of(2006, 2, 20));

            dao.save(usuario);
            System.out.println("Usuário salvo com sucesso: " + usuario);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            emf.close();
        }
    }
}