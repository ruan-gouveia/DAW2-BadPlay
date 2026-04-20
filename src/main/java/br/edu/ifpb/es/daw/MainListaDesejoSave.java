package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AdministradorDAO;
import br.edu.ifpb.es.daw.dao.FilmeDAO;
import br.edu.ifpb.es.daw.dao.ListaDesejoDAO;
import br.edu.ifpb.es.daw.dao.UsuarioDAO;
import br.edu.ifpb.es.daw.dao.impl.AdministradorDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.FilmeDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.ListaDesejoDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.UsuarioDAOImpl;
import br.edu.ifpb.es.daw.entities.Administrador;
import br.edu.ifpb.es.daw.entities.Filme;
import br.edu.ifpb.es.daw.entities.ListaDesejo;
import br.edu.ifpb.es.daw.entities.Usuario;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainListaDesejoSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            ListaDesejoDAO listaDao = new ListaDesejoDAOImpl(emf);
            UsuarioDAO usuarioDao = new UsuarioDAOImpl(emf);
            FilmeDAO filmeDao = new FilmeDAOImpl(emf);
            AdministradorDAO administradorDAO = new AdministradorDAOImpl(emf);

            Administrador a = administradorDAO.getByID(4L);

            // 1. Criar e salvar o USUÁRIO (Dono da lista)
            Usuario u = new Usuario();
            u.setNome("Ruan Gouveia");
            u.setEmail("ruan_lista" + System.nanoTime() + "@email.com"); // Regra 12: Único
            u.setSenha("senha123");
            u.setDataNascimento(LocalDate.of(2006,02,20));
            usuarioDao.save(u);

            // 2. Criar e salvar dois FILMES (Conteúdos para a lista)
            Filme f1 = new Filme();
            f1.setTitulo("Batman: O Cavaleiro das Trevas " + System.nanoTime());
            f1.setTipo("Filme");
            f1.setDuracao(152);
            f1.setUrlFilme("http://badplay.com/batman");
            f1.setDescricao("sla");
            f1.setAdministrador(a);
            filmeDao.save(f1);

            Filme f2 = new Filme();
            f2.setTitulo("A Origem " + System.nanoTime());
            f2.setTipo("Filme");
            f2.setDuracao(148);
            f2.setUrlFilme("http://badplay.com/inception");
            f2.setDescricao("sla2");
            f2.setAdministrador(a);
            filmeDao.save(f2);

            // 3. Criar a LISTA DE DESEJOS
            ListaDesejo lista = new ListaDesejo();
            lista.setNome("Maratona de Férias " + System.nanoTime());
            lista.setDataCriacao(LocalDateTime.now());

            // 4. VINCULAR AS ASSOCIAÇÕES (Regra 4 do professor)

            // Vincula o dono da lista (Many-to-One)
            lista.setUsuario(u);

            // Adiciona os conteúdos à lista (Many-to-Many)
            // Certifique-se que a lista 'conteudos' foi inicializada na entidade ListaDesejo
            lista.getConteudos().add(f1);
            lista.getConteudos().add(f2);

            // 5. SALVAR a Lista de Desejos
            // O Hibernate salvará em tb_lista_desejo
            // e criará 2 linhas na tabela de junção tb_lista_conteudo
            listaDao.save(lista);

            System.out.println("Lista de Desejos e vínculos salvos com sucesso!");
            System.out.println("ID da Lista: " + lista.getIdLista());
            System.out.println("Quantidade de itens na lista: " + lista.getConteudos().size());
        }
    }
}