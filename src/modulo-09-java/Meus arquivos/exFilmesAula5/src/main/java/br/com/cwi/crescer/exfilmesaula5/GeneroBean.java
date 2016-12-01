package br.com.cwi.crescer.exfilmesaula5;

import br.com.cwi.crescer.exfilmesaula5.dao.AbstractDao;
import br.com.cwi.crescer.exfilmesaula5.entity.Genero;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author regis
 */
@Stateless
public class GeneroBean extends AbstractDao<Genero, Long>{

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public GeneroBean() {
        super(Genero.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Genero> findAll() {
        return this.getEntityManager().createQuery("select g from Genero g").getResultList();
    }

}
