package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AdministradorDAO;
import br.edu.ifpb.es.daw.dao.ConteudoDAO;
import br.edu.ifpb.es.daw.dao.FilmeDAO;
import br.edu.ifpb.es.daw.dao.impl.AdministradorDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.ConteudoDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.FilmeDAOImpl;
import br.edu.ifpb.es.daw.entities.Administrador;
import br.edu.ifpb.es.daw.entities.Conteudo;
import br.edu.ifpb.es.daw.entities.Filme;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainFilmeSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            FilmeDAO dao = new FilmeDAOImpl(emf);
            AdministradorDAO admDao = new AdministradorDAOImpl(emf);

            Administrador adm = new Administrador();
            adm.setNome("Ruanzihno");
            adm.setEmail("RuanDelas"+ System.nanoTime() + "@gmail.com");
            adm.setSenha("teste");
            admDao.save(adm);

            Filme f = new Filme();
            f.setTitulo("BadBoys Devs");
            f.setUrlFilme("http://badplay.com/filme/" + System.nanoTime());
            f.setDuracao(120);
            f.setDescricao("Filme de teste");
            f.setTipo("Filme");
            f.setAdministrador(adm);
            dao.save(f);
            System.out.println("Filme salvo: " + f);
        }
    }
}