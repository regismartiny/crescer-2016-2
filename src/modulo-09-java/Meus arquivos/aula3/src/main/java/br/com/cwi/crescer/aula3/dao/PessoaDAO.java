/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.dao;

import br.com.cwi.crescer.aula3.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author regis.martiny
 */
public class PessoaDAO implements IDAO<Pessoa, Long> {

    private final EntityManager em;

    public PessoaDAO(EntityManager entityManager) {
        em = entityManager;
    }

    @Override
    public void insert(Pessoa p) {
        try {
            em.getTransaction().begin();
            if (p.getIdPessoa() != null) {
                em.merge(p);
            } else {
                em.persist(p);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Pessoa p) {
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Pessoa find(Long id) {
        try {
            return em.find(Pessoa.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Pessoa> findAll() {
        return em.createQuery("select p from Pessoa p").getResultList();
    }
    
    //JPA
    public List<Pessoa> findByNome(String nmPessoa) {
        final Query query = em.createQuery("select p from Pessoa p where upper(p.nmPessoa) like :nmPessoa");
        query.setParameter("nmPessoa", nmPessoa.toUpperCase());
        return query.getResultList();
    }

}
