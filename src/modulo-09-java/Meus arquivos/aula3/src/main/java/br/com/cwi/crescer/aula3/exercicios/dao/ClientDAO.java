/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.exercicios.dao;

import br.com.cwi.crescer.aula3.exercicios.entity.Client;
import br.com.cwi.crescer.aula3.dao.IDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author regis
 */
public class ClientDAO implements IDAO<Client, Long>{
    private final EntityManager em;

    public ClientDAO(EntityManager entityManager) {
        em = entityManager;
    }

    @Override
    public void insert(Client c) {
        try {
            em.getTransaction().begin();
            if (c.getIdClient() != null) {
                em.merge(c);
            } else {
                em.persist(c);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Client c) {
        try {
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Client find(Long id) {
        try {
            return em.find(Client.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Client> findAll() {
        return em.createQuery("select c from Client c").getResultList();
    }
    
    //JPA
    public List<Client> findByNome(String nmClient) {
        final Query query = em.createQuery("select c from Client c where upper(c.nmClient) like :nmClient");
        query.setParameter("nmClient", nmClient.toUpperCase());
        return query.getResultList();
    }

}
