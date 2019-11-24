/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit;

import eu.purplestudio.example.hibernate.persistance.integration.entity.ExampleEntity;
import eu.purplestudio.example.hibernate.persistance.integration.repo.RepoImpl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mikolaj
 */
public class CRUDTest {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static RepoImpl repo;
    
    public CRUDTest() throws Exception {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
        emf = Persistence.createEntityManagerFactory("example-hibernate-persistence");
        em = emf.createEntityManager();
        repo = new RepoImpl(em, ExampleEntity.class);
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        ExampleEntity entity = new ExampleEntity();
        entity.setExampleColumn("row created");
        repo.save(entity);
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @Test
    public void update() throws Exception {
        List<ExampleEntity> entities = repo.getAll();
        ExampleEntity entity = entities.get(entities.size() - 1);
        Long id = entity.getId();
        entity.setExampleColumn("update");
        repo.save(entity);
        entity = (ExampleEntity) repo.findById(id);
        
        if(!entity.getExampleColumn().equals("update"))
            throw new Exception("upadte error");
    }
    
    @Test
    public void remove() throws Exception {
        List<ExampleEntity> entities = repo.getAll();
        ExampleEntity entity = entities.get(entities.size() - 1);
        Long id = entity.getId();
        repo.remove(entity);
        entity = (ExampleEntity) repo.findById(id);
        
        if(entity != null)
            throw new Exception("entity is not null");
    }
    
    @Test
    public void getAll() throws Exception {
        setUp();
        
        if(repo.getAll().size() < 2)
            throw new Exception("list is to small");
    }
    
}
