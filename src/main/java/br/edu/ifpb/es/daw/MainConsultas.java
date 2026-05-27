package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.*;
import br.edu.ifpb.es.daw.dao.impl.*;
import br.edu.ifpb.es.daw.entities.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.List;

public class MainConsultas {

        public static void main(String[] args) throws Exception {
            try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
                FilmeDAO filmeDAO = new FilmeDAOImpl(emf);
                PlanoDAO planoDAO = new PlanoDAOImpl(emf);
                AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAOImpl(emf);
                UsuarioDAO usuarioDAO = new UsuarioDAOImpl(emf);
                ConteudoDAO conteudoDAO = new ConteudoDAOImpl(emf); // Para resgatar a entidade como parâmetro

                // ATENÇÃO: Pegamos o ID do usuário e filme gerados (ajuste se necessário ou use getAll().get(0))
                Usuario usuarioParams = usuarioDAO.getAll().get(0);
                Conteudo conteudoParams = conteudoDAO.getAll().get(0);

                System.out.println("\n=== 2.1) Parâmetro Tipo Wrapper (Filmes com mais de 100 min) ===");
                List<Filme> filmesLongos = filmeDAO.findByDuracaoMaiorQue(100);
                filmesLongos.forEach(f -> System.out.println("Filme: " + f.getTitulo() + " | Duração: " + f.getDuracao()));

                System.out.println("\n=== 2.2) Parâmetro Entidade (Avaliações do Usuário) ===");
                List<Avaliacao> avaliacoesDoUser = avaliacaoDAO.findByUsuario(usuarioParams);
                avaliacoesDoUser.forEach(a -> System.out.println("Nota: " + a.getNota() + " | Filme ID: " + a.getConteudo().getIdConteudo()));

                System.out.println("\n=== 2.3) Dois Parâmetros (Planos entre R$20 e R$70) ===");
                List<Plano> planosCaros = planoDAO.findByValorBetween(new BigDecimal("20.00"), new BigDecimal("70.00"));
                planosCaros.forEach(p -> System.out.println("Plano: " + p.getTipo() + " | Valor: " + p.getValor()));

                System.out.println("\n=== 2.4) Função de Agregação (Média de Notas de um Conteúdo) ===");
                Double media = avaliacaoDAO.getMediaNotasByConteudo(conteudoParams);
                System.out.println("Conteúdo ID: " + conteudoParams.getIdConteudo() + " | Média: " + media);

                System.out.println("\n=== 2.5) JOIN FETCH Relacionamento LAZY (Usuário com Assinaturas) ===");
                Usuario uFetch = usuarioDAO.findByIdWithAssinaturas(usuarioParams.getIdUsuario());
                System.out.println("Usuário: " + uFetch.getNome());
                System.out.println("Qtd de Assinaturas (Carregadas com EAGER via FETCH): " + uFetch.getAssinaturas().size());
            }
        }
}
