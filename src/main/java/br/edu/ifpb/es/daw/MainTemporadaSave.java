package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AdministradorDAO;
import br.edu.ifpb.es.daw.dao.ConteudoDAO;
import br.edu.ifpb.es.daw.dao.SerieDAO;
import br.edu.ifpb.es.daw.dao.TemporadaDAO;
import br.edu.ifpb.es.daw.dao.impl.AdministradorDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.ConteudoDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.SerieDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.TemporadaDAOImpl;
import br.edu.ifpb.es.daw.entities.Administrador;
import br.edu.ifpb.es.daw.entities.Conteudo;
import br.edu.ifpb.es.daw.entities.Serie;
import br.edu.ifpb.es.daw.entities.Temporada;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainTemporadaSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            TemporadaDAO temporadaDao = new TemporadaDAOImpl(emf);
            SerieDAO serieDao = new SerieDAOImpl(emf);
            AdministradorDAO admDao = new AdministradorDAOImpl(emf);

            Administrador adm = new Administrador();
            adm.setNome("Admin de Séries");
            adm.setEmail("admin_serie" + System.nanoTime() + "@badplay.com");
            adm.setSenha("123");
            admDao.save(adm);

            // 1. Criar e salvar a Série (Dependência da Temporada)
            Serie s = new Serie();
            s.setTitulo("Stranger Things " + System.nanoTime());
            s.setDescricao("Mistérios sobrenaturais em Hawkins.");
            s.setTipo("Série");
            s.setAdministrador(adm);
            serieDao.save(s);

            // 2. Criar a Temporada
            Temporada t = new Temporada();
            t.setNumeroTemporada(1);

            // 3. VINCULAR A ASSOCIAÇÃO (Regra 4)
            // Vincula a temporada à série que acabamos de salvar
            t.setSerie(s);

            // 4. Salvar a Temporada
            temporadaDao.save(t);

            System.out.println("Temporada salva com sucesso!");
            System.out.println("ID da Temporada: " + t.getIdTemporada());
            System.out.println("Vinculada à Série: " + t.getSerie().getTitulo());

        }
    }
}