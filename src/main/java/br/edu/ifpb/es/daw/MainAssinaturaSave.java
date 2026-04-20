package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AssinaturaDAO;
import br.edu.ifpb.es.daw.dao.PlanoDAO;
import br.edu.ifpb.es.daw.dao.UsuarioDAO;
import br.edu.ifpb.es.daw.dao.impl.AssinaturaDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.PlanoDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.UsuarioDAOImpl;
import br.edu.ifpb.es.daw.entities.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

public class MainAssinaturaSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            UsuarioDAO userDAO = new UsuarioDAOImpl(emf);
            PlanoDAO planoDAO = new PlanoDAOImpl(emf);
            AssinaturaDAO assinaturaDAO = new AssinaturaDAOImpl(emf);

            // 1. Criar e salvar Usuário (Dependência)
            Usuario u = new Usuario();
            u.setNome("Ruan Assinante");
            u.setEmail("ruan.assinante" + System.nanoTime() + "@email.com");
            u.setSenha("senha123");
            userDAO.save(u);

            // 2. Criar e salvar Plano (Dependência)
            Plano p = new Plano();
            p.setTipo(TipoPlano.PREMIUM);
            p.setValor(new BigDecimal("49.90"));
            planoDAO.save(p);

            // 3. Criar Assinatura vinculando os dois (Regra 4)
            Assinatura ass = new Assinatura();
            ass.setDataInicio(LocalDate.now());
            ass.setDataFim(LocalDate.now().plusDays(30));
            ass.setStatus("ATIVA");
            ass.setUsuario(u); // Associação
            ass.setPlano(p);   // Associação

            assinaturaDAO.save(ass);
            System.out.println("Assinatura salva com sucesso! ID: " + ass.getId());
        }
    }
}