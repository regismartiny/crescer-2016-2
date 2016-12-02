package br.com.cwi.crescer.exfilmesaula5;

import br.com.cwi.crescer.exfilmesaula5.entity.Classificacao;
import br.com.cwi.crescer.exfilmesaula5.entity.Filme;
import br.com.cwi.crescer.exfilmesaula5.entity.Genero;
import br.com.cwi.crescer.exfilmesaula5.entity.Elenco;
import br.com.cwi.crescer.exfilmesaula5.entity.Idioma;
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
    @EJB
    private ClassificacaoBean classificacaoBean;
    @EJB
    private IdiomaBean idiomaBean;
    
    private Filme filme;
    private List<Filme> filmes;
    private List<Genero> opcoesGenero;
    private List<Elenco> opcoesElenco;
    private List<Classificacao> opcoesClassificacao;
    private List<Idioma> opcoesIdioma;

    @PostConstruct
    public void init() {
        this.filme = new Filme();
        this.filmes = filmeBean.findAll();
        this.filmes.sort((a,b)-> a.getIdFilme().compareTo(b.getIdFilme()));
        this.opcoesGenero = generoBean.findAll();
        this.opcoesGenero.sort((a,b)-> a.getIdGenero().compareTo(b.getIdGenero()));
        this.opcoesElenco = elencoBean.findAll();
        this.opcoesElenco.sort((a,b)-> a.getIdElenco().compareTo(b.getIdElenco()));
        this.opcoesClassificacao = classificacaoBean.findAll();
        this.opcoesClassificacao.sort((a,b)-> a.getIdClassificacao().compareTo(b.getIdClassificacao()));
        this.opcoesIdioma = idiomaBean.findAll();
        this.opcoesIdioma.sort((a,b)-> a.getIdIdioma().compareTo(b.getIdIdioma()));
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

    public List<Classificacao> getOpcoesClassificacao() {
        return opcoesClassificacao;
    }

    public List<Idioma> getOpcoesIdioma() {
        return opcoesIdioma;
    }
    
    

    
    
    public void adicionar() {
        filmeBean.insert(filme);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Filme cadastrado com sucesso.", "OK"));
    }


}
