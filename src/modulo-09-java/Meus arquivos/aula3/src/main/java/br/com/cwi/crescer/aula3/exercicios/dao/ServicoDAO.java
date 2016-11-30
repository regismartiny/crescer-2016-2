/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.exercicios.dao;

import br.com.cwi.crescer.aula3.exercicios.entity.Servico;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author regis
 */
public class ServicoDAO extends AbstractDao<Servico, Long> {

    final EntityManager entityManager;

    public ServicoDAO(EntityManager entityManager) {
        super(Servico.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Servico> findAll() {
        return this.getEntityManager().createQuery("select p from Servico p").getResultList();
    }
}
