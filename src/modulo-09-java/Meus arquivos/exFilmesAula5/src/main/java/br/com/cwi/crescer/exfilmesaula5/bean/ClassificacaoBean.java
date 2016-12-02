package br.com.cwi.crescer.exfilmesaula5.bean;

import br.com.cwi.crescer.exfilmesaula5.entity.Classificacao;
import br.com.cwi.crescer.exfilmesaula5.dao.AbstractDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author regis
 */
@Stateless
public class ClassificacaoBean extends AbstractDao<Classificacao, Long>{

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public ClassificacaoBean() {
        super(Classificacao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Classificacao> findAll() {
        return this.getEntityManager().createQuery("select c from Classificacao c").getResultList();
    }

}
