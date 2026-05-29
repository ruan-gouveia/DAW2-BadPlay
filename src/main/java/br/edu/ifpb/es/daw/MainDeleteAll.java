package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.*;
import br.edu.ifpb.es.daw.dao.impl.*;
import br.edu.ifpb.es.daw.entities.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainDeleteAll {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {

            // Instancia todos os DAOs necessários
            EpisodioDAO epDAO = new EpisodioDAOImpl(emf);
            TemporadaDAO tempDAO = new TemporadaDAOImpl(emf);
            AssinaturaDAO assDAO = new AssinaturaDAOImpl(emf);
            AvaliacaoDAO avalDAO = new AvaliacaoDAOImpl(emf);
            HistoricoDAO histDAO = new HistoricoDAOImpl(emf);
            RecomendacaoDAO recDAO = new RecomendacaoDAOImpl(emf);
            ListaDesejoDAO listaDAO = new ListaDesejoDAOImpl(emf);
            FilmeDAO filmeDAO = new FilmeDAOImpl(emf);
            SerieDAO serieDAO = new SerieDAOImpl(emf);
            ConteudoDAO contDAO = new ConteudoDAOImpl(emf);
            UsuarioDAO userDAO = new UsuarioDAOImpl(emf);
            PlanoDAO planoDAO = new PlanoDAOImpl(emf);
            GeneroDAO generoDAO = new GeneroDAOImpl(emf);
            AdministradorDAO admDAO = new AdministradorDAOImpl(emf);

            System.out.println("Iniciando a limpeza do Banco de Dados...");


            // 1. Nível mais baixo e tabelas de cruzamento associativas
            epDAO.getAll().forEach(e -> { try { epDAO.delete(e.getIdEpisodio()); } catch (Exception ex){} });
            tempDAO.getAll().forEach(t -> { try { tempDAO.delete(t.getIdTemporada()); } catch (Exception ex){} });
            assDAO.getAll().forEach(a -> { try { assDAO.delete(a.getId()); } catch (Exception ex){} });
            avalDAO.getAll().forEach(a -> { try { avalDAO.delete(a.getId()); } catch (Exception ex){} });
            histDAO.getAll().forEach(h -> { try { histDAO.delete(h.getId()); } catch (Exception ex){} });
            recDAO.getAll().forEach(r -> { try { recDAO.delete(r.getId()); } catch (Exception ex){} });
            listaDAO.getAll().forEach(l -> { try { listaDAO.delete(l.getIdLista()); } catch (Exception ex){} });

            // 2. Nível intermediário (Herança)
            filmeDAO.getAll().forEach(f -> { try { filmeDAO.delete(f.getIdConteudo()); } catch (Exception ex){} });
            serieDAO.getAll().forEach(s -> { try { serieDAO.delete(s.getIdConteudo()); } catch (Exception ex){} });
            contDAO.getAll().forEach(c -> { try { contDAO.delete(c.getIdConteudo()); } catch (Exception ex){} });

            // 3. Nível Base
            userDAO.getAll().forEach(u -> { try { userDAO.delete(u.getIdUsuario()); } catch (Exception ex){} });
            planoDAO.getAll().forEach(p -> { try { planoDAO.delete(p.getIdAssinatura()); } catch (Exception ex){} });
            generoDAO.getAll().forEach(g -> { try { generoDAO.delete(g.getIdGenero()); } catch (Exception ex){} });
            admDAO.getAll().forEach(adm -> { try { admDAO.delete(adm.getIdAdministrador()); } catch (Exception ex){} });

            System.out.println("Banco de Dados totalmente limpo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}