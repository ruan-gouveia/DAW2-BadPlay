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
        StringBuilder consoleOutput = new StringBuilder();
        consoleOutput.append("\n=======================================================\n");
        consoleOutput.append("          RESULTADO FINAL DAS CONSULTAS JPQL           \n");
        consoleOutput.append("=======================================================\n");

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            FilmeDAO filmeDAO = new FilmeDAOImpl(emf);
            PlanoDAO planoDAO = new PlanoDAOImpl(emf);
            AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAOImpl(emf);
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl(emf);
            ConteudoDAO conteudoDAO = new ConteudoDAOImpl(emf);

            Usuario usuarioParams = usuarioDAO.getAll().get(0);
            Conteudo conteudoParams = conteudoDAO.getAll().get(0);

            // ---------------------------------------------------------
            // 2.1) Parâmetro Tipo Wrapper (Filmes com mais de 100 min)
            // ---------------------------------------------------------
            List<Filme> filmesLongos = filmeDAO.findByDuracaoMaiorQue(100);
            consoleOutput.append("\n[2.1] Filmes com mais de 100 min (Parâmetro Wrapper):\n");
            filmesLongos.forEach(f -> consoleOutput.append(String.format("   -> Filme: %s | Duração: %d min\n", f.getTitulo(), f.getDuracao())));

            // ---------------------------------------------------------
            // 2.2) Parâmetro Entidade (Avaliações do Usuário)
            // ---------------------------------------------------------
            List<Avaliacao> avaliacoesDoUser = avaliacaoDAO.findByUsuario(usuarioParams);
            consoleOutput.append("\n[2.2] Avaliações feitas por '").append(usuarioParams.getNome()).append("' (Parâmetro Entidade):\n");
            avaliacoesDoUser.forEach(a -> consoleOutput.append(String.format("   -> Nota: %.1f | Título: %s\n", a.getNota(), a.getConteudo().getTitulo())));

            // ---------------------------------------------------------
            // 2.3) Dois Parâmetros (Planos entre R$20 e R$70)
            // ---------------------------------------------------------
            List<Plano> planosCaros = planoDAO.findByValorBetween(new BigDecimal("20.00"), new BigDecimal("70.00"));
            consoleOutput.append("\n[2.3] Planos entre R$20 e R$70 (Dois Parâmetros):\n");
            planosCaros.forEach(p -> consoleOutput.append(String.format("   -> Plano: %s | Valor: R$ %.2f\n", p.getTipo(), p.getValor())));

            // ---------------------------------------------------------
            // 2.4) Função de Agregação (Média de Notas de um Conteúdo)
            // ---------------------------------------------------------
            Double media = avaliacaoDAO.getMediaNotasByConteudo(conteudoParams);
            consoleOutput.append("\n[2.4] Média de Notas (Função de Agregação):\n");
            consoleOutput.append(String.format("   -> Título: %s | Média: %.2f estrelas\n", conteudoParams.getTitulo(), (media != null ? media : 0.0)));

            // ---------------------------------------------------------
            // 2.5) JOIN FETCH Relacionamento LAZY (Usuário com Assinaturas)
            // ---------------------------------------------------------
            Usuario uFetch = usuarioDAO.findByIdWithAssinaturas(usuarioParams.getIdUsuario());
            consoleOutput.append("\n[2.5] Usuário + Assinaturas (JOIN FETCH LAZY):\n");
            consoleOutput.append("   -> Usuário: ").append(uFetch.getNome()).append("\n");
            consoleOutput.append("   -> Qtd de Assinaturas (Carregadas via FETCH): ").append(uFetch.getAssinaturas().size()).append("\n");

        }

        System.out.println(consoleOutput.toString());
    }
}