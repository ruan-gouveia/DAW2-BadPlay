package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AdministradorDAO;
import br.edu.ifpb.es.daw.dao.ConteudoDAO;
import br.edu.ifpb.es.daw.dao.GeneroDAO;
import br.edu.ifpb.es.daw.dao.impl.AdministradorDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.ConteudoDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.GeneroDAOImpl;
import br.edu.ifpb.es.daw.entities.Administrador;
import br.edu.ifpb.es.daw.entities.Conteudo;
import br.edu.ifpb.es.daw.entities.Genero;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainConteudoSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            ConteudoDAO conteudoDAO = new ConteudoDAOImpl(emf);
            AdministradorDAO adminDAO = new AdministradorDAOImpl(emf);
            GeneroDAO generoDAO = new GeneroDAOImpl(emf);

            // 1. Criar um Administrador (dependência)
            Administrador adm = new Administrador();
            adm.setNome("Admin de Conteúdo");
            adm.setEmail("admin" + System.nanoTime() + "@badplay.com");
            adm.setSenha("123");
            adminDAO.save(adm);

            // 2. Criar um Gênero (dependência ManyToMany)
            Genero g = new Genero();
            g.setNome("Ação " + System.nanoTime());
            generoDAO.save(g);

            // 3. Criar o Conteúdo Genérico
            Conteudo c = new Conteudo();
            c.setTitulo("Documentário Genérico " + System.nanoTime());
            c.setDescricao("Um conteúdo que não é filme nem série.");
            c.setTipo("Documentário");

            // Preenchendo associações (Regra 4)
            c.setAdministrador(adm); // ManyToOne
            c.getGeneros().add(g);   // ManyToMany (adicionando na lista)


            conteudoDAO.save(c);
            System.out.println("Conteúdo genérico salvo com ID: " + c.getIdConteudo());
        }
    }
}