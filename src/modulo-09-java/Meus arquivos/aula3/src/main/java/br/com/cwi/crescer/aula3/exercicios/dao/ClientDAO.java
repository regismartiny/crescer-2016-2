/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.exercicios.dao;

import br.com.cwi.crescer.aula3.exercicios.entity.Client;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author regis
 */
public class ClientDAO extends AbstractDao<Client, Long> {

    final EntityManager entityManager;

    public ClientDAO(EntityManager entityManager) {
        super(Client.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Client> findAll() {
        return this.getEntityManager().createQuery("select p from Client p").getResultList();
    }
}
