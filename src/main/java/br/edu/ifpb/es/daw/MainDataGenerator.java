package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.*;
import br.edu.ifpb.es.daw.dao.impl.*;
import br.edu.ifpb.es.daw.entities.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MainDataGenerator {
    public static void main(String[] args) throws Exception{

        try  (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            UsuarioDAO  usuarioDAO = new UsuarioDAOImpl(emf);
            PlanoDAO planoDAO = new PlanoDAOImpl(emf);
            AssinaturaDAO assinaturaDAO = new AssinaturaDAOImpl(emf);
            FilmeDAO filmeDAO = new FilmeDAOImpl(emf);
            AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAOImpl(emf);

            // 1. Criar Usuário
            Usuario u = new Usuario();
            u.setNome("João Consultas");
            u.setEmail("joao" + System.nanoTime() + "@email.com");
            u.setSenha("123");
            usuarioDAO.save(u);

            // 2. Criar Planos
            Plano p1 = new Plano();
            p1.setTipo(TipoPlano.BASICO);
            p1.setValor(new BigDecimal("19.90"));
            planoDAO.save(p1);

            Plano p2 = new Plano();
            p2.setTipo(TipoPlano.PREMIUM);
            p2.setValor(new BigDecimal("59.90"));
            planoDAO.save(p2);

            // 3. Criar Assinatura (para testar JOIN FETCH)
            Assinatura ass = new Assinatura();
            ass.setUsuario(u);
            ass.setPlano(p2);
            ass.setDataInicio(LocalDate.now());
            ass.setStatus("ATIVA");
            assinaturaDAO.save(ass);

            // 4. Criar Filmes (para testar duração)
            Filme f1 = new Filme();
            f1.setTitulo("Filme Curto " + System.nanoTime());
            f1.setTipo("Filme");
            f1.setDuracao(90);
            f1.setUrlFilme("http://url1.com");
            filmeDAO.save(f1);

            Filme f2 = new Filme();
            f2.setTitulo("Filme Longo " + System.nanoTime());
            f2.setTipo("Filme");
            f2.setDuracao(150);
            f2.setUrlFilme("http://url2.com");
            filmeDAO.save(f2);

            // 5. Criar Avaliações (para testar média e busca por Entidade)
            Avaliacao av1 = new Avaliacao();
            av1.setUsuario(u);
            av1.setConteudo(f2);
            av1.setNota(4.0);
            avaliacaoDAO.save(av1);

            Avaliacao av2 = new Avaliacao();
            av2.setUsuario(u);
            av2.setConteudo(f2);
            av2.setNota(5.0);
            avaliacaoDAO.save(av2);

            System.out.println("--- DADOS GERADOS COM SUCESSO ---");
            System.out.println("ID do Usuário gerado: " + u.getIdUsuario());
            System.out.println("ID do Filme Curto (f1) gerado: " + f1.getIdConteudo());
            System.out.println("ID do Filme Longo (f2) gerado: " + f2.getIdConteudo());
        }
    }
}
