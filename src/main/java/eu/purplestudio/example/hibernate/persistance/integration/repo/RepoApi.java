/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.purplestudio.example.hibernate.persistance.integration.repo;

import java.util.List;

/**
 *
 * @author mikolaj
 */
public interface RepoApi {
    Object findById(Long id);
    List<Object> getAll(); 
    void save(Object object);
    void remove(Object object);
}
