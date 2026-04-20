package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.*;
import br.edu.ifpb.es.daw.dao.impl.*;
import br.edu.ifpb.es.daw.entities.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainAvaliacaoSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            UsuarioDAO userDAO = new UsuarioDAOImpl(emf);
            ConteudoDAO conteudoDAO = new ConteudoDAOImpl(emf);
            AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAOImpl(emf);

            // 1. Criar e salvar Usuario
            Usuario u = new Usuario();
            u.setNome("Ruan Critico");
            u.setEmail("ruan.critico" + System.nanoTime() + "@email.com");
            u.setSenha("123");
            userDAO.save(u);

            // 2. Criar e salvar Conteúdo (pode ser Filme ou Serie também)
            Conteudo c = new Conteudo();
            c.setTitulo("Inception " + System.nanoTime());
            c.setTipo("Filme");
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
