package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PlanoDAO;
import br.edu.ifpb.es.daw.dao.impl.PlanoDAOImpl;
import br.edu.ifpb.es.daw.entities.Plano;
import br.edu.ifpb.es.daw.entities.TipoPlano;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class MainPlanoUpdate {
    public static void main(String[] args) throws Exception {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {
            PlanoDAO dao = new PlanoDAOImpl(emf);

            Long idAtualizar = 1L;
            Plano plano = dao.getByID(idAtualizar);

            if (plano != null) {
                System.out.println("Antes da atualização: " + plano);

                // Atualizando os valores
                plano.setValor(new BigDecimal("55.90"));
                plano.setTipo(TipoPlano.PREMIUM);

                dao.update(plano);
                System.out.println("Após a atualização: " + plano);
            } else {
                System.out.println("Plano não encontrado para o ID: " + idAtualizar);
            }
        }
    }
}