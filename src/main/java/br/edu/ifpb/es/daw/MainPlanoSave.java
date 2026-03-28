package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PlanoDAO;
import br.edu.ifpb.es.daw.dao.impl.PlanoDAOImpl;
import br.edu.ifpb.es.daw.entities.Plano;
import br.edu.ifpb.es.daw.entities.TipoPlano;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class MainPlanoSave {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu");
        PlanoDAO dao = new PlanoDAOImpl(emf);

        try {
            Plano plano = new Plano();
            plano.setValor(new BigDecimal("39.90"));
            plano.setTipo(TipoPlano.PREMIUM);

            dao.save(plano);
            System.out.println("Plano salvo com sucesso: " + plano);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            emf.close();
        }
    }
}