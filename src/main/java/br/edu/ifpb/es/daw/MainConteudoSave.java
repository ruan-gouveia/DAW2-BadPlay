package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ConteudoDAO;
import br.edu.ifpb.es.daw.dao.impl.ConteudoDAOImpl;
import br.edu.ifpb.es.daw.entities.Conteudo;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainConteudoSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            ConteudoDAO dao = new ConteudoDAOImpl(emf);
            Conteudo c = new Conteudo();
            c.setTitulo("Inception");
            c.setDescricao("Um ladrão que rouba segredos através da tecnologia de compartilhar sonhos.");
            c.setTipo("Filme");
            dao.save(c);
            System.out.println("Salvo: " + c);
        }
    }
}