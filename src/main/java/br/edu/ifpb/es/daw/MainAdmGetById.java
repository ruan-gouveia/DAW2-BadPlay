package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AdministradorDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.AdministradorDAOImpl;
import br.edu.ifpb.es.daw.entities.Administrador;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainAdmGetById {

    public static void main(String[] args) throws PersistenciaDawException {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")) {

            AdministradorDAO dao = new AdministradorDAOImpl(emf);

            dao.delete(6L);
            System.out.printf("Administrador deletado!");




        }

    }
}
