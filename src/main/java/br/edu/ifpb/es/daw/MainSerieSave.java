package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AdministradorDAO;
import br.edu.ifpb.es.daw.dao.GeneroDAO;
import br.edu.ifpb.es.daw.dao.SerieDAO;
import br.edu.ifpb.es.daw.dao.impl.AdministradorDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.GeneroDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.SerieDAOImpl;
import br.edu.ifpb.es.daw.entities.Administrador;
import br.edu.ifpb.es.daw.entities.Genero;
import br.edu.ifpb.es.daw.entities.Serie;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainSerieSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            SerieDAO serieDao = new SerieDAOImpl(emf);
            AdministradorDAO admDao = new AdministradorDAOImpl(emf);
            GeneroDAO generoDao = new GeneroDAOImpl(emf);

            // 1. Criar e salvar o Administrador (Lado 1 do relacionamento)
            Administrador adm = new Administrador();
            adm.setNome("Admin de Séries");
            adm.setEmail("admin_serie" + System.nanoTime() + "@badplay.com");
            adm.setSenha("123");
            admDao.save(adm);

            // 2. Criar e salvar um Gênero (Lado N do relacionamento ManyToMany)
            Genero g = new Genero();
            g.setNome("Suspense " + System.nanoTime());
            generoDao.save(g);

            // 3. Criar a Série
            Serie s = new Serie();

            // Campos herdados de Conteudo
            s.setTitulo("Dark " + System.nanoTime());
            s.setDescricao("Série alemã sobre viagem no tempo e mistério.");
            s.setTipo("Série");

            // 4. VINCULAR AS ASSOCIAÇÕES (Regra 4)
            s.setAdministrador(adm); // Vincula o Administrador
            s.getGeneros().add(g);   // Adiciona o Gênero à lista (Many-to-Many)

            // 5. Salvar a Série
            // O Hibernate salvará automaticamente em tb_conteudo e tb_serie
            // e também criará o registro na tabela de junção tb_conteudo_genero
            serieDao.save(s);

            System.out.println("Série salva com sucesso!");
            System.out.println("ID (via Conteudo): " + s.getIdConteudo());
            System.out.println("Administrador vinculado: " + s.getAdministrador().getNome());
        }
    }
}