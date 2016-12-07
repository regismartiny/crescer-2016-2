package br.com.cwi.crescer.aula9.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Carlos H. Nonnemacher
 */
@Entity
@Table(name = "FILME")
public class Filme implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FILME")
    @SequenceGenerator(name = "SEQ_FILME", sequenceName = "SEQ_FILME", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_FILME")
    private Long idFilme;

    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;
    
    @ManyToOne
    @Basic(optional = false)
    private Genero genero;
    
    @Basic(optional = false)
    @Column(name = "DIRETOR")
    private String diretor;
    
    @Temporal(value=DATE)
    @Basic(optional = true)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "DT_LANCAMENTO", nullable = true)
    private Date dtLancamento;
    
    @ManyToOne
    @Basic(optional = false)
    private Elenco elenco;
    
    @ManyToOne
    @Basic(optional = false)
    private Classificacao classificacao;
    
    @ManyToOne
    @Basic(optional = false)
    private Idioma idioma;

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Date getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(Date dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }
    
    
    
}
