/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.purplestudio.example.hibernate.persistance.core;

import eu.purplestudio.example.hibernate.persistance.integration.entity.ExampleEntity;
import eu.purplestudio.example.hibernate.persistance.integration.repo.RepoImpl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mikolaj
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-hibernate-persistence");
        EntityManager em = emf.createEntityManager();
        
        Object test = new ExampleEntity();
        em.getTransaction().begin();
        em.persist(test);
        test = new ExampleEntity();
        em.persist(test);
        em.getTransaction().commit();
        RepoImpl repo = new RepoImpl(em, ExampleEntity.class);
        List<ExampleEntity> list = repo.getAll();
        
        for(ExampleEntity entity: list){
            System.out.println(entity.getId());
        }
        
    }
    
}
