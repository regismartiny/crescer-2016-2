package br.com.cwi.crescer.exfilmesaula5;

import br.com.cwi.crescer.exfilmesaula5.entity.Ator;
import br.com.cwi.crescer.exfilmesaula5.entity.Elenco;
import java.util.ArrayList;
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
public class CadastroElenco {

    @EJB
    private ElencoBean elencoBean;
    @EJB
    private AtorBean atorBean;
    
    private Elenco elenco;
    private List<Elenco> elencos;
    private List<Ator> opcoesAtores;
    private List<String> atoresSelecionados;

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public List<Elenco> getElencos() {
        return elencos;
    }

    public void setElencos(List<Elenco> elencos) {
        this.elencos = elencos;
    }

    public List<Ator> getOpcoesAtores() {
        return opcoesAtores;
    }

    public List<String> getAtoresSelecionados() {
        return atoresSelecionados;
    }

    public void setAtoresSelecionados(List<String> atoresSelecionados) {
        this.atoresSelecionados = atoresSelecionados;
    }

   


    
    @PostConstruct
    public void init() {
        this.elenco = new Elenco();
        this.elencos = elencoBean.findAll();
        this.elencos.sort((a,b)-> a.getIdElenco().compareTo(b.getIdElenco()));
        this.opcoesAtores = atorBean.findAll();
        this.opcoesAtores.sort((a,b)-> a.getIdAtor().compareTo(b.getIdAtor()));
    }

    
    
    
    public void adicionar() {
        List<Ator> atores = new ArrayList<>();
        for(String strIdAtor : this.atoresSelecionados){
            Long idAtor = Long.valueOf(strIdAtor);
            Ator ator = atorBean.find(idAtor);
            atores.add(ator);
        }
        this.elenco.setAtores(atores);
        elencoBean.insert(elenco);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro inserido com sucesso.", "OK"));
    }


}
