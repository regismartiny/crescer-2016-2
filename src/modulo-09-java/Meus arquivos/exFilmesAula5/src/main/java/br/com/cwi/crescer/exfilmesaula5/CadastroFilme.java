package br.com.cwi.crescer.exfilmesaula5;

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
public class CadastroFilme {

    @EJB
    private FilmeBean filmeBean;
    @EJB
    private GeneroBean generoBean;
    @EJB
    private ElencoBean elencoBean;
    
    private Filme filme;
    private List<Filme> filmes;
    private List<Genero> opcoesGenero;
    private List<Elenco> opcoesElenco;

    @PostConstruct
    public void init() {
        this.filme = new Filme();
        this.filmes = filmeBean.findAll();
        this.filmes.sort((a,b)-> a.getIdFilme().compareTo(b.getIdFilme()));
        this.opcoesGenero = generoBean.findAll();
        this.opcoesGenero.sort((a,b)-> a.getIdGenero().compareTo(b.getIdGenero()));
        this.opcoesElenco = elencoBean.findAll();
        this.opcoesElenco.sort((a,b)-> a.getIdElenco().compareTo(b.getIdElenco()));
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public List<Genero> getOpcoesGenero() {
        return opcoesGenero;
    }

    public List<Elenco> getOpcoesElenco() {
        return opcoesElenco;
    }

    
    
    public void adicionar() {
        filmeBean.insert(filme);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Filme cadastrado com sucesso.", "OK"));
    }


}
