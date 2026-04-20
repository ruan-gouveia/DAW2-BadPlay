package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.*;
import br.edu.ifpb.es.daw.dao.impl.*;
import br.edu.ifpb.es.daw.entities.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class MainAvaliacaoSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            UsuarioDAO uDAO = new UsuarioDAOImpl(emf);
            ConteudoDAO conteudoDAO = new ConteudoDAOImpl(emf);
            AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAOImpl(emf);
            AdministradorDAO admDao = new AdministradorDAOImpl(emf);

            Administrador a = admDao.getByID(2L);

            // 1. Criar e salvar Usuario
            Usuario u = new Usuario();
            u.setNome("Arthur Avaliação");
            u.setEmail("TurzinhoDelas" + System.nanoTime() + "@gmail.com");
            u.setDataNascimento(LocalDate.of(2002, 11, 29));
            u.setSenha("teste");
            uDAO.save(u);

            // 2. Criar e salvar Conteúdo (pode ser Filme ou Serie também)
            Conteudo c = new Conteudo();
            c.setTitulo("Documentário Genérico " + System.nanoTime());
            c.setDescricao("Um conteúdo que não é filme nem série.");
            c.setTipo("Documentário");
            c.setAdministrador(a);
            conteudoDAO.save(c);

            // 3. Criar Avaliação (Regra 4)
            Avaliacao av = new Avaliacao();
            av.setNota(5.0);
            av.setUsuario(u);
            av.setConteudo(c);

            avaliacaoDAO.save(av);
            System.out.println("Avaliação salva com sucesso! ID: " + av.getId());
        }
    }
}
