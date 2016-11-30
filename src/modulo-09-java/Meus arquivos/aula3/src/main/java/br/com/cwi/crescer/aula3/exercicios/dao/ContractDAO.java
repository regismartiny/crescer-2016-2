/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.exercicios.dao;

import br.com.cwi.crescer.aula3.exercicios.entity.Contract;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author regis
 */
public class ContractDAO extends AbstractDao<Contract, Long> {

    final EntityManager entityManager;

    public ContractDAO(EntityManager entityManager) {
        super(Contract.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Contract> findAll() {
        return this.getEntityManager().createQuery("select p from Contract p").getResultList();
    }
}
