package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.UsuarioDAO;
import br.edu.ifpb.es.daw.dao.impl.UsuarioDAOImpl;
import br.edu.ifpb.es.daw.entities.Usuario;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class MainUsuarioUpdate {

    public static void main(String[] args) throws PersistenciaDawException {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")){

            UsuarioDAO dao = new UsuarioDAOImpl(emf);

            Usuario usuario = new Usuario();

            usuario.setNome("João da Silva");

            usuario.setEmail("joao" + System.nanoTime() + "@badplay.com");
            usuario.setSenha("senha123");
            usuario.setDataNascimento(LocalDate.of(1995, 8, 20));

            dao.save(usuario);

            System.out.println(usuario);

            // Atualizado

            usuario.setNome("Arthur Henrique");
            usuario.setDataNascimento(LocalDate.of(2002, 11, 29));

            dao.update(usuario);

            System.out.println(usuario);

        }
    }

}
