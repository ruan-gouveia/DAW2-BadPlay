package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.*;
import br.edu.ifpb.es.daw.dao.impl.*;
import br.edu.ifpb.es.daw.entities.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

public class MainAssinaturaSave {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            // Precisamos dos 3 DAOs
            UsuarioDAO userDAO = new UsuarioDAOImpl(emf);
            PlanoDAO planoDAO = new PlanoDAOImpl(emf);
            AssinaturaDAO assinaturaDAO = (AssinaturaDAO) new AssinaturaDAOImpl(emf);

            // 1. Criar e salvar dependências
            Usuario u = new Usuario();
            u.setNome("Assinante Teste");
            u.setEmail("teste" + System.nanoTime() + "@email.com");
            u.setSenha("123");
            userDAO.save(u);

            Plano p = new Plano();
            p.setTipo(TipoPlano.PREMIUM);
            p.setValor(new BigDecimal("49.90"));
            planoDAO.save(p);

            // 2. Criar a Assinatura vinculando os objetos
            Assinatura ass = new Assinatura();
            ass.setDataInicio(LocalDate.now());
            ass.setStatus("ATIVA");
            ass.setUsuario(u); // Associação ManyToOne
            ass.setPlano(p);   // Associação ManyToOne

            assinaturaDAO.save(ass);
            System.out.println("Assinatura salva com sucesso! ID: " + ass.getId());
        }
    }
}