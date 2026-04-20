package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.EpisodioDAO;
import br.edu.ifpb.es.daw.dao.SerieDAO;
import br.edu.ifpb.es.daw.dao.TemporadaDAO;
import br.edu.ifpb.es.daw.dao.impl.EpisodioDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.SerieDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.TemporadaDAOImpl;
import br.edu.ifpb.es.daw.entities.Episodio;
import br.edu.ifpb.es.daw.entities.Serie;
import br.edu.ifpb.es.daw.entities.Temporada;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEpisodioSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            SerieDAO serieDao = new SerieDAOImpl(emf);
            TemporadaDAO temporadaDao = new TemporadaDAOImpl(emf);
            EpisodioDAO episodioDao = new EpisodioDAOImpl(emf);

            // 1. Criar e salvar a Série (que é um Conteúdo)
            Serie s = new Serie();
            s.setTitulo("The Boys " + System.nanoTime());
            s.setDescricao("Série sobre super-heróis corruptos.");
            s.setTipo("Série");
            serieDao.save(s);

            // 2. Criar e salvar a Temporada vinculada à Série
            Temporada t = new Temporada();
            t.setNumeroTemporada(1);
            t.setSerie(s); // Associação ManyToOne
            temporadaDao.save(t);

            // 3. Criar e salvar o Episódio vinculado à Temporada
            Episodio ep = new Episodio();
            ep.setNumeroEpisodio(1);
            ep.setDuracao(60);
            // Regra 13: Unicidade da URL
            ep.setUrlEpisodio("http://badplay.com/watch/" + System.nanoTime());
            ep.setNomeEpisodio("TTTT");
            ep.setTemporada(t); // Associação ManyToOne

            episodioDao.save(ep);

            System.out.println("Cadeia salva com sucesso!");
            System.out.println("Série ID: " + s.getIdConteudo());
            System.out.println("Temporada ID: " + t.getIdTemporada());
            System.out.println("Episódio ID: "  + ep.getIdEpisodio());
        }
    }
}