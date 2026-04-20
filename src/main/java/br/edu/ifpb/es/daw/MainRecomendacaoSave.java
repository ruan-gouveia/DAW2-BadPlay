package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AdministradorDAO;
import br.edu.ifpb.es.daw.dao.ConteudoDAO;
import br.edu.ifpb.es.daw.dao.RecomendacaoDAO;
import br.edu.ifpb.es.daw.dao.UsuarioDAO;
import br.edu.ifpb.es.daw.dao.impl.AdministradorDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.ConteudoDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.RecomendacaoDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.UsuarioDAOImpl;
import br.edu.ifpb.es.daw.entities.Administrador;
import br.edu.ifpb.es.daw.entities.Conteudo;
import br.edu.ifpb.es.daw.entities.Recomendacao;
import br.edu.ifpb.es.daw.entities.Usuario;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class MainRecomendacaoSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            UsuarioDAO uDAO = new UsuarioDAOImpl(emf);
            RecomendacaoDAO rdao = new RecomendacaoDAOImpl(emf);
            ConteudoDAO cDAO = new ConteudoDAOImpl(emf);
            AdministradorDAO admDao = new AdministradorDAOImpl(emf);

            Administrador a = admDao.getByID(2L);

            Usuario u = new Usuario();
            u.setNome("Arthur");
            u.setEmail("TurzinhoDelas" + System.nanoTime() + "@gmail.com");
            u.setDataNascimento(LocalDate.of(2002, 11, 29));
            u.setSenha("teste");
            uDAO.save(u);

            Conteudo c = new Conteudo();
            c.setTitulo("Documentário Genérico " + System.nanoTime());
            c.setDescricao("Um conteúdo que não é filme nem série.");
            c.setTipo("Documentário");
            c.setAdministrador(a);
            cDAO.save(c);


            Recomendacao r = new Recomendacao();
            r.setMotivo("Porque você assistiu X");
            r.setUsuario(u);
            r.setConteudo(c);

            rdao.save(r);
        }
    }
}
