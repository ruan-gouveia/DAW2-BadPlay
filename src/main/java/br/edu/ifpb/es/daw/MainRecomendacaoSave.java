package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.RecomendacaoDAO;
import br.edu.ifpb.es.daw.dao.impl.RecomendacaoDAOImpl;
import br.edu.ifpb.es.daw.entities.Conteudo;
import br.edu.ifpb.es.daw.entities.Recomendacao;
import br.edu.ifpb.es.daw.entities.Usuario;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainRecomendacaoSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {

            RecomendacaoDAO rdao = new RecomendacaoDAOImpl(emf);
            Usuario u = new Usuario(); // ... salvar
            Conteudo c = new Conteudo(); // ... salvar

            Recomendacao r = new Recomendacao();
            r.setMotivo("Porque você assistiu X");
            r.setUsuario(u);
            r.setConteudo(c);

            rdao.save(r);
        }
    }
}
