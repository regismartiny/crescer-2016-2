/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.exercicios.dao;

import br.com.cwi.crescer.aula3.exercicios.entity.CurrencyExchange;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author regis
 */
public class CurrencyExchangeDAO extends AbstractDao<CurrencyExchange, Long> {

    final EntityManager entityManager;

    public CurrencyExchangeDAO(EntityManager entityManager) {
        super(CurrencyExchange.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<CurrencyExchange> findAll() {
        return this.getEntityManager().createQuery("select p from CurrencyExchange p").getResultList();
    }
}
