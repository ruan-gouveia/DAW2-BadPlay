package br.edu.ifpb.es.daw.config;

import br.edu.ifpb.es.daw.entities.*;
import br.edu.ifpb.es.daw.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final AdministradorRepository administradorRepository;
    private final PlanoRepository planoRepository;
    private final GeneroRepository generoRepository;
    private final FilmeRepository filmeRepository;
    private final SerieRepository serieRepository;
    private final TemporadaRepository temporadaRepository;
    private final EpisodioRepository episodioRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    public DataSeeder(UsuarioRepository usuarioRepository, AdministradorRepository administradorRepository, PlanoRepository planoRepository, GeneroRepository generoRepository, FilmeRepository filmeRepository, SerieRepository serieRepository, TemporadaRepository temporadaRepository, EpisodioRepository episodioRepository, AvaliacaoRepository avaliacaoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.administradorRepository = administradorRepository;
        this.planoRepository = planoRepository;
        this.generoRepository = generoRepository;
        this.filmeRepository = filmeRepository;
        this.serieRepository = serieRepository;
        this.temporadaRepository = temporadaRepository;
        this.episodioRepository = episodioRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("⏳ Injetando nova carga de dados de teste (sem apagar os antigos)...");

        // Sufixo único para evitar violação de Unique Constraints (e-mails, nomes de gêneros, URLs)
        String sfx = "_" + System.nanoTime();

        // 1. Criar Administrador
        Administrador adm = new Administrador();
        adm.setNome("Admin Supremo");
        adm.setEmail("admin" + sfx + "@badplay.com"); // Email único garantido
        adm.setSenha("123456");
        administradorRepository.save(adm);

        // 2. Criar Gêneros (Nome único garantido)
        Genero gAcao = new Genero(); gAcao.setNome("Ação" + sfx); generoRepository.save(gAcao);
        Genero gFiccao = new Genero(); gFiccao.setNome("Ficção Científica" + sfx); generoRepository.save(gFiccao);
        Genero gDrama = new Genero(); gDrama.setNome("Drama" + sfx); generoRepository.save(gDrama);

        // 3. Criar Planos (Não tem constraint única além do ID, mas adicionaremos novos)
        Plano pBasico = new Plano(); pBasico.setTipo(TipoPlano.BASICO); pBasico.setValor(new BigDecimal("19.90")); planoRepository.save(pBasico);
        Plano pPremium = new Plano(); pPremium.setTipo(TipoPlano.PREMIUM); pPremium.setValor(new BigDecimal("49.90")); planoRepository.save(pPremium);

        // 4. Criar Usuários
        Usuario u1 = new Usuario(); u1.setNome("Ruan Gouveia"); u1.setEmail("ruan" + sfx + "@email.com"); u1.setSenha("123456"); u1.setDataNascimento(LocalDate.of(2000, 1, 1)); usuarioRepository.save(u1);
        Usuario u2 = new Usuario(); u2.setNome("Professor DAW"); u2.setEmail("professor" + sfx + "@ifpb.com"); u2.setSenha("senhaForte"); u2.setDataNascimento(LocalDate.of(1985, 5, 10)); usuarioRepository.save(u2);

        // 5. Criar Filme
        Filme filme = new Filme();
        filme.setTitulo("Matrix " + sfx);
        filme.setDescricao("Um hacker descobre que a realidade é uma simulação.");
        filme.setTipo("FILME");
        filme.setUrlFilme("http://badplay.com/matrix" + sfx); // URL única
        filme.setDuracao(136);
        filme.setAdministrador(adm);
        filme.setGeneros(List.of(gAcao, gFiccao));
        filmeRepository.save(filme);

        // 6. Criar Série com Temporada e Episódio
        Serie serie = new Serie();
        serie.setTitulo("Breaking Bad " + sfx);
        serie.setDescricao("Professor de química vira traficante.");
        serie.setTipo("SERIE");
        serie.setAdministrador(adm);
        serie.setGeneros(List.of(gDrama, gAcao));
        serieRepository.save(serie);

        Temporada temp1 = new Temporada();
        temp1.setNumeroTemporada(1);
        temp1.setSerie(serie);
        temporadaRepository.save(temp1);

        Episodio ep1 = new Episodio();
        ep1.setNomeEpisodio("Piloto");
        ep1.setNumeroEpisodio(1);
        ep1.setDuracao(58);
        ep1.setUrlEpisodio("http://badplay.com/bb/s01e01" + sfx); // URL única
        ep1.setTemporada(temp1);
        episodioRepository.save(ep1);

        // 7. Criar Avaliação
        Avaliacao av = new Avaliacao();
        av.setNota(5.0);
        av.setUsuario(u1);
        av.setConteudo(filme);
        avaliacaoRepository.save(av);

        System.out.println("✅ Nova carga de dados injetada com sucesso no banco!");
    }
}