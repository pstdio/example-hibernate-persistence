package eu.purplestudio.example.hibernate.persistance.integration.repo;

import java.util.List;

/**
 *
 * @author mikolaj
 */
public interface RepoApi {
    Object findById(Long id);
    List getAll(); 
    void save(Object object);
    void remove(Object object);
}
