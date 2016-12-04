package br.com.cwi.crescer.exfilmesaula5.bean;

import br.com.cwi.crescer.exfilmesaula5.dao.AbstractDao;
import br.com.cwi.crescer.exfilmesaula5.entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author regis
 */
@Stateless
public class UsuarioBean extends AbstractDao<Usuario, Long>{

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public UsuarioBean() {
        super(Usuario.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Usuario> findAll() {
        return this.getEntityManager().createQuery("select u from Usuario u").getResultList();
    }
    
    //JPA
    public List<Usuario> findByName(String nome) {
        final Query query = this.getEntityManager().createQuery("select u from Usuario u where upper(u.nome) like :nome");
        query.setParameter("nome", nome.toUpperCase());
        return query.getResultList();
    }

    public List<Usuario> findByEmail(String email) {
        final Query query = this.getEntityManager().createQuery("select u from Usuario u where upper(u.email) = :email");
        query.setParameter("email", email.toUpperCase());
        return query.getResultList();
    }

}
