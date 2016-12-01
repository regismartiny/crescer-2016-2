package br.com.cwi.crescer.exfilmesaula5;

import br.com.cwi.crescer.exfilmesaula5.entity.Ator;
import br.com.cwi.crescer.exfilmesaula5.entity.Filme;
import br.com.cwi.crescer.exfilmesaula5.entity.Genero;
import br.com.cwi.crescer.exfilmesaula5.entity.Elenco;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * @author regis
 */
@ManagedBean
@ViewScoped
public class CadastroAtor {

    @EJB
    private AtorBean atorBean;
    
    private Ator ator;
    private List<Ator> atores;


    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }
    
    

    @PostConstruct
    public void init() {
        this.ator = new Ator();
        this.atores = atorBean.findAll();
        this.atores.sort((a,b)-> a.getIdAtor().compareTo(b.getIdAtor()));
    }

    
    
    
    public void adicionar() {
        atorBean.insert(ator);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }


}
