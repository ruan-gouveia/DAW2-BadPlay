package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.*;
import br.edu.ifpb.es.daw.dao.impl.*;
import br.edu.ifpb.es.daw.entities.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

public class MainDataGenerator {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl(emf);
            PlanoDAO planoDAO = new PlanoDAOImpl(emf);
            AssinaturaDAO assinaturaDAO = new AssinaturaDAOImpl(emf);
            FilmeDAO filmeDAO = new FilmeDAOImpl(emf);
            AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAOImpl(emf);

            System.out.println("Populando o banco de dados com novos registros...");

            // 1. Criar 3 Usuários
            Usuario u1 = new Usuario();
            u1.setNome("João Silva");
            u1.setEmail("joao" + System.nanoTime() + "@email.com");
            u1.setSenha("123");
            usuarioDAO.save(u1);

            Usuario u2 = new Usuario();
            u2.setNome("Maria Souza");
            u2.setEmail("maria" + System.nanoTime() + "@email.com");
            u2.setSenha("123");
            usuarioDAO.save(u2);

            Usuario u3 = new Usuario();
            u3.setNome("Carlos Oliveira");
            u3.setEmail("carlos" + System.nanoTime() + "@email.com");
            u3.setSenha("123");
            usuarioDAO.save(u3);

            // 2. Criar 3 Planos
            Plano p1 = new Plano();
            p1.setTipo(TipoPlano.BASICO);
            p1.setValor(new BigDecimal("19.90"));
            planoDAO.save(p1);

            Plano p2 = new Plano();
            p2.setTipo(TipoPlano.PADRAO);
            p2.setValor(new BigDecimal("39.90"));
            planoDAO.save(p2);

            Plano p3 = new Plano();
            p3.setTipo(TipoPlano.PREMIUM);
            p3.setValor(new BigDecimal("59.90"));
            planoDAO.save(p3);

            // 3. Criar Assinaturas (João é Premium, Maria é Padrão)
            Assinatura ass1 = new Assinatura();
            ass1.setUsuario(u1);
            ass1.setPlano(p3);
            ass1.setDataInicio(LocalDate.now().minusDays(10));
            ass1.setStatus("ATIVA");
            assinaturaDAO.save(ass1);

            Assinatura ass2 = new Assinatura();
            ass2.setUsuario(u2);
            ass2.setPlano(p2);
            ass2.setDataInicio(LocalDate.now());
            ass2.setStatus("ATIVA");
            assinaturaDAO.save(ass2);

            // 4. Criar 3 Filmes
            Filme f1 = new Filme();
            f1.setTitulo("O Poderoso Chefão " + System.nanoTime());
            f1.setTipo("Filme");
            f1.setDuracao(175);
            f1.setUrlFilme("http://url1.com/" + System.nanoTime());
            filmeDAO.save(f1);

            Filme f2 = new Filme();
            f2.setTitulo("Toy Story " + System.nanoTime());
            f2.setTipo("Filme");
            f2.setDuracao(81);
            f2.setUrlFilme("http://url2.com/" + System.nanoTime());
            filmeDAO.save(f2);

            Filme f3 = new Filme();
            f3.setTitulo("Vingadores " + System.nanoTime());
            f3.setTipo("Filme");
            f3.setDuracao(143);
            f3.setUrlFilme("http://url3.com/" + System.nanoTime());
            filmeDAO.save(f3);

            // 5. Criar 5 Avaliações
            // Avaliações do Filme 1 (Notas: 5.0, 4.0, 4.5 -> Média = 4.5)
            Avaliacao av1 = new Avaliacao(); av1.setUsuario(u1); av1.setConteudo(f1); av1.setNota(5.0); avaliacaoDAO.save(av1);
            Avaliacao av2 = new Avaliacao(); av2.setUsuario(u2); av2.setConteudo(f1); av2.setNota(4.0); avaliacaoDAO.save(av2);
            Avaliacao av3 = new Avaliacao(); av3.setUsuario(u3); av3.setConteudo(f1); av3.setNota(4.5); avaliacaoDAO.save(av3);

            // Avaliações do Filme 2 e 3
            Avaliacao av4 = new Avaliacao(); av4.setUsuario(u1); av4.setConteudo(f2); av4.setNota(3.5); avaliacaoDAO.save(av4);
            Avaliacao av5 = new Avaliacao(); av5.setUsuario(u2); av5.setConteudo(f3); av5.setNota(5.0); avaliacaoDAO.save(av5);

            System.out.println("--- DADOS GERADOS COM SUCESSO ---");
        }
    }
}