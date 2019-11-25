package eu.purplestudio.example.hibernate.persistance.integration.repo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Table;

/**
 *
 * @author mikolaj
 */
public class RepoImpl implements RepoApi {

    private final EntityManager em;
    private final Class clazz;
    
    public RepoImpl(EntityManager em, Class clazz){
        this.em = em;
        this.clazz = clazz;
    }
    
    @Override
    public Object findById(Long id) {
        return em.find(clazz, id);
    }

    @Override
    public List getAll() {
        if(!clazz.isAnnotationPresent(Table.class))
            return null;

        List out = em.createQuery(
                "SELECT o FROM "+clazz.getName()+" o"
        ).getResultList();

        return out;
    }

    @Override
    public void save(Object object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public void remove(Object object) {
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
    }
    
}
