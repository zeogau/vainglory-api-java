package gg.zeogau.vg.datadumper.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by zeogau on 3/10/17.
 */
public class EntityManagement {
    private static EntityManager em;
    private EntityManagement() {}

    public static EntityManager getTheManager() {
        if(em==null){
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpa-vainglory");
            em =  emFactory.createEntityManager();
        }
        return em;

    }
}
