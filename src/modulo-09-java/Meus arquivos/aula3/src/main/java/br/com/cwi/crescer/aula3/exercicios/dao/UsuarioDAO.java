/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.exercicios.dao;

import br.com.cwi.crescer.aula3.exercicios.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author regis
 */
public class UsuarioDAO extends AbstractDao<Usuario, Long> {

    final EntityManager entityManager;

    public UsuarioDAO(EntityManager entityManager) {
        super(Usuario.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Usuario> findAll() {
        return this.getEntityManager().createQuery("select p from Usuario p").getResultList();
    }
}
