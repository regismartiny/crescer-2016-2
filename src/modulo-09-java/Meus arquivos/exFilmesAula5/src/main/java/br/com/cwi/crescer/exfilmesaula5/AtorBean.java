package br.com.cwi.crescer.exfilmesaula5;

import br.com.cwi.crescer.exfilmesaula5.dao.AbstractDao;
import br.com.cwi.crescer.exfilmesaula5.entity.Ator;
import br.com.cwi.crescer.exfilmesaula5.entity.Elenco;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author regis
 */
@Stateless
public class AtorBean extends AbstractDao<Ator, Long>{

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public AtorBean() {
        super(Ator.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Ator> findAll() {
        return this.getEntityManager().createQuery("select a from Ator a").getResultList();
    }
    
    //JPA
    public List<Ator> findByName(String nome) {
        final Query query = this.getEntityManager().createQuery("select a from Ator a where upper(a.nome) = :nome");
        query.setParameter("nome", nome.toUpperCase());
        return query.getResultList();
    }
}
