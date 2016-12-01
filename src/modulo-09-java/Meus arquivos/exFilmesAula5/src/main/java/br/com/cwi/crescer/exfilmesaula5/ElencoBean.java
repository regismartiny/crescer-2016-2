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
public class ElencoBean extends AbstractDao<Elenco, Long>{

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public ElencoBean() {
        super(Elenco.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Elenco> findAll() {
        return this.getEntityManager().createQuery("select e from Elenco e").getResultList();
    }
    
    //JPA
    public List<Elenco> findByName(String nome) {
        final Query query = this.getEntityManager().createQuery("select e from Elenco e where upper(e.nome) like :nome");
        query.setParameter("nome", nome.toUpperCase());
        return query.getResultList();
    }

}
