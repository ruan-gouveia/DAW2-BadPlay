package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AdministradorDAO;
import br.edu.ifpb.es.daw.dao.SerieDAO;
import br.edu.ifpb.es.daw.dao.impl.AdministradorDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.SerieDAOImpl;
import br.edu.ifpb.es.daw.entities.Administrador;
import br.edu.ifpb.es.daw.entities.Genero;
import br.edu.ifpb.es.daw.entities.Serie;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainSerieSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            SerieDAO dao = new SerieDAOImpl(emf);
            AdministradorDAO admDAO = new AdministradorDAOImpl(emf);

            Administrador adm = new Administrador();
            adm.setNome("Mateus");
            adm.setEmail("Mateus" + System.nanoTime() + "gmail.com");
            adm.setSenha("Teste");
            admDAO.save(adm);


            Serie s = new Serie();
            s.setTitulo("The Last of Us " + System.nanoTime());
            s.setDescricao("Sobrevivência em um mundo pós-apocalíptico.");
            s.setTipo("Série");
            s.setAdministrador(adm);
            dao.save(s);
            System.out.println("Série salva! ID: " + s.getIdConteudo());
        }
    }
}