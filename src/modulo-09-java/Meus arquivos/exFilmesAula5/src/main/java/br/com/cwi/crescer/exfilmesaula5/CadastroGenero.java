package br.com.cwi.crescer.exfilmesaula5;

import br.com.cwi.crescer.exfilmesaula5.bean.GeneroBean;
import br.com.cwi.crescer.exfilmesaula5.entity.Genero;
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
public class CadastroGenero {

    @EJB
    private GeneroBean generoBean;
    
    private Genero genero;
    private List<Genero> generos;

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    
    
    @PostConstruct
    public void init() {
        this.genero = new Genero();
        this.generos = generoBean.findAll();
        this.generos.sort((a,b)-> a.getIdGenero().compareTo(b.getIdGenero()));
    }

    
    
    
    public void adicionar() {
        generoBean.insert(genero);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro inserido com sucesso.", "OK"));
    }


}
