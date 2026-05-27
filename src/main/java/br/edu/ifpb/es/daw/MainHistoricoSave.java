package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ConteudoDAO;
import br.edu.ifpb.es.daw.dao.HistoricoDAO;
import br.edu.ifpb.es.daw.dao.UsuarioDAO;
import br.edu.ifpb.es.daw.dao.impl.ConteudoDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.HistoricoDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.UsuarioDAOImpl;
import br.edu.ifpb.es.daw.entities.Filme;
import br.edu.ifpb.es.daw.entities.Historico;
import br.edu.ifpb.es.daw.entities.Usuario;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class MainHistoricoSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {

            HistoricoDAO historicoDao = new HistoricoDAOImpl(emf);
            UsuarioDAO usuarioDao = new UsuarioDAOImpl(emf);
            ConteudoDAO conteudoDao = new ConteudoDAOImpl(emf);

            // 1. Criar e salvar o Usuário
            Usuario u = new Usuario();
            u.setNome("Ruan Espectador");
            u.setEmail("ruan_watch" + System.nanoTime() + "@email.com");
            u.setSenha("123");
            usuarioDao.save(u);

            // 2. Criar e salvar um Conteúdo (Filme)
            Filme f = new Filme();
            f.setTitulo("O Poderoso Chefão " + System.nanoTime());
            f.setTipo("Filme");
            f.setDuracao(175);
            f.setUrlFilme("http://badplay.com/godfather");
            conteudoDao.save(f);

            // 3. Criar o Histórico
            Historico h = new Historico();

            // CORREÇÃO: Usando setTimestamp com LocalDateTime
            h.setTimestamp(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

            // 4. VINCULAR AS ASSOCIAÇÕES (Regra 4)
            h.setUsuario(u);
            h.setConteudo(f);

            // 5. Salvar o Histórico
            historicoDao.save(h);

            System.out.println("Histórico de reprodução salvo com sucesso!");
            System.out.println("Usuário: " + h.getUsuario().getNome());
            System.out.println("Assistiu: " + h.getConteudo().getTitulo());
            System.out.println("No momento: " + h.getTimestamp());
        }
    }
}