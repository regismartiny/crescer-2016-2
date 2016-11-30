/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.exercicios.dao;

import br.com.cwi.crescer.aula3.exercicios.entity.ContractValue;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author regis
 */
public class ContractValueDAO extends AbstractDao<ContractValue, Long> {

    final EntityManager entityManager;

    public ContractValueDAO(EntityManager entityManager) {
        super(ContractValue.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<ContractValue> findAll() {
        return this.getEntityManager().createQuery("select p from ContractValue p").getResultList();
    }
}
