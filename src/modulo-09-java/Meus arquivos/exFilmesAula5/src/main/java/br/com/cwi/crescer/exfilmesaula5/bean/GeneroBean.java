package br.com.cwi.crescer.exfilmesaula5.bean;

import br.com.cwi.crescer.exfilmesaula5.dao.AbstractDao;
import br.com.cwi.crescer.exfilmesaula5.entity.Elenco;
import br.com.cwi.crescer.exfilmesaula5.entity.Genero;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    //JPA
    public List<Elenco> findByDescription(String descricao) {
        final Query query = this.getEntityManager().createQuery("select g from Genero g where upper(g.descricao) like :descricao");
        query.setParameter("descricao", descricao.toUpperCase());
        return query.getResultList();
    }

}
