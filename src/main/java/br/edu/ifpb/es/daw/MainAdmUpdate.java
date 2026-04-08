package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AdministradorDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.AdministradorDAOImpl;
import br.edu.ifpb.es.daw.entities.Administrador;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainAdmUpdate {

    public static void main(String[] args) throws PersistenciaDawException {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw-pu")){

            AdministradorDAO dao = new AdministradorDAOImpl(emf);

            Administrador adm = new Administrador();

            adm.setEmail("Arthur@gmail.com");
            adm.setNome("Arthur");
            adm.setSenha("teste123");

            dao.save(adm);

            System.out.println(adm);

            adm.setEmail("Henrqiue" + System.nanoTime() +  "@gmail.com");

            dao.update(adm);

            System.out.println(adm);


        }
    }
}
