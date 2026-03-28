package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PlanoDAO;
import br.edu.ifpb.es.daw.dao.impl.PlanoDAOImpl;
import br.edu.ifpb.es.daw.entities.Plano;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainPlanoDeleteAll {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu");

        PlanoDAO dao = new PlanoDAOImpl(emf);

        try {

            List<Plano> planos = dao.getAll();

            for (Plano p : planos) {

                dao.delete(p.getIdAssinatura());
            }

            System.out.println("Todos os Planos foram removidos do banco com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro ao remover os planos: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (emf != null && emf.isOpen()) {
                emf.close();
            }
        }
    }
}