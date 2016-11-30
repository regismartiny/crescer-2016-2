/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.exercicios.dao;

import br.com.cwi.crescer.aula3.exercicios.entity.Cotacao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author regis
 */
public class CotacaoDAO extends AbstractDao<Cotacao, Long> {

    final EntityManager entityManager;

    public CotacaoDAO(EntityManager entityManager) {
        super(Cotacao.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Cotacao> findAll() {
        return this.getEntityManager().createQuery("select p from Cotacao p").getResultList();
    }
}
