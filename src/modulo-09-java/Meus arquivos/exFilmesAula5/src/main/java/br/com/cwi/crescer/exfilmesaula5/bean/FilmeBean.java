/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.exfilmesaula5.bean;

import br.com.cwi.crescer.exfilmesaula5.dao.AbstractDao;
import br.com.cwi.crescer.exfilmesaula5.entity.Filme;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author regis
 */
@Stateless
public class FilmeBean extends AbstractDao<Filme, Long>{

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public FilmeBean() {
        super(Filme.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Filme> findAll() {
        return this.getEntityManager().createQuery("select f from Filme f").getResultList();
    }

}
