/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.exercicios.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author regis.martiny
 */
@Entity
@Table(name = "SERVICO")
@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s"),
    @NamedQuery(name = "Servico.findByIdServico", query = "SELECT s FROM Servico s WHERE s.idServico = :idServico"),
    @NamedQuery(name = "Servico.findByDsDescricao", query = "SELECT s FROM Servico s WHERE s.dsDescricao = :dsDescricao"),
    @NamedQuery(name = "Servico.findByDsPeriodicidade", query = "SELECT s FROM Servico s WHERE s.dsPeriodicidade = :dsPeriodicidade"),
    @NamedQuery(name = "Servico.findByDsSimboloMoeda", query = "SELECT s FROM Servico s WHERE s.dsSimboloMoeda = :dsSimboloMoeda"),
    @NamedQuery(name = "Servico.findByDsSituacao", query = "SELECT s FROM Servico s WHERE s.dsSituacao = :dsSituacao"),
    @NamedQuery(name = "Servico.findByDsWebsite", query = "SELECT s FROM Servico s WHERE s.dsWebsite = :dsWebsite"),
    @NamedQuery(name = "Servico.findByNmServico", query = "SELECT s FROM Servico s WHERE s.nmServico = :nmServico"),
    @NamedQuery(name = "Servico.findByVlMensalUsd", query = "SELECT s FROM Servico s WHERE s.vlMensalUsd = :vlMensalUsd"),
    @NamedQuery(name = "Servico.findByVlTotalServico", query = "SELECT s FROM Servico s WHERE s.vlTotalServico = :vlTotalServico")})
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_SERVICO")
    @SequenceGenerator(name = "SEQ_SERVICO", sequenceName = "SEQ_SERVICO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_SERVICO")
    private BigDecimal idServico;
    @Basic(optional = false)
    @Column(name = "DS_DESCRICAO")
    private String dsDescricao;
    @Basic(optional = false)
    @Column(name = "DS_PERIODICIDADE")
    private String dsPeriodicidade;
    @Basic(optional = false)
    @Column(name = "DS_SIMBOLO_MOEDA")
    private String dsSimboloMoeda;
    @Basic(optional = false)
    @Column(name = "DS_SITUACAO")
    private String dsSituacao;
    @Basic(optional = false)
    @Column(name = "DS_WEBSITE")
    private String dsWebsite;
    @Basic(optional = false)
    @Column(name = "NM_SERVICO")
    private String nmServico;
    @Basic(optional = false)
    @Column(name = "VL_MENSAL_USD")
    private BigDecimal vlMensalUsd;
    @Basic(optional = false)
    @Column(name = "VL_TOTAL_SERVICO")
    private BigDecimal vlTotalServico;
    @JoinColumn(name = "USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario usuarioIdUsuario;

    public Servico() {
    }

    public Servico(BigDecimal idServico) {
        this.idServico = idServico;
    }

    public Servico(BigDecimal idServico, String dsDescricao, String dsPeriodicidade, String dsSimboloMoeda, String dsSituacao, String dsWebsite, String nmServico, BigDecimal vlMensalUsd, BigDecimal vlTotalServico) {
        this.idServico = idServico;
        this.dsDescricao = dsDescricao;
        this.dsPeriodicidade = dsPeriodicidade;
        this.dsSimboloMoeda = dsSimboloMoeda;
        this.dsSituacao = dsSituacao;
        this.dsWebsite = dsWebsite;
        this.nmServico = nmServico;
        this.vlMensalUsd = vlMensalUsd;
        this.vlTotalServico = vlTotalServico;
    }

    public BigDecimal getIdServico() {
        return idServico;
    }

    public void setIdServico(BigDecimal idServico) {
        this.idServico = idServico;
    }

    public String getDsDescricao() {
        return dsDescricao;
    }

    public void setDsDescricao(String dsDescricao) {
        this.dsDescricao = dsDescricao;
    }

    public String getDsPeriodicidade() {
        return dsPeriodicidade;
    }

    public void setDsPeriodicidade(String dsPeriodicidade) {
        this.dsPeriodicidade = dsPeriodicidade;
    }

    public String getDsSimboloMoeda() {
        return dsSimboloMoeda;
    }

    public void setDsSimboloMoeda(String dsSimboloMoeda) {
        this.dsSimboloMoeda = dsSimboloMoeda;
    }

    public String getDsSituacao() {
        return dsSituacao;
    }

    public void setDsSituacao(String dsSituacao) {
        this.dsSituacao = dsSituacao;
    }

    public String getDsWebsite() {
        return dsWebsite;
    }

    public void setDsWebsite(String dsWebsite) {
        this.dsWebsite = dsWebsite;
    }

    public String getNmServico() {
        return nmServico;
    }

    public void setNmServico(String nmServico) {
        this.nmServico = nmServico;
    }

    public BigDecimal getVlMensalUsd() {
        return vlMensalUsd;
    }

    public void setVlMensalUsd(BigDecimal vlMensalUsd) {
        this.vlMensalUsd = vlMensalUsd;
    }

    public BigDecimal getVlTotalServico() {
        return vlTotalServico;
    }

    public void setVlTotalServico(BigDecimal vlTotalServico) {
        this.vlTotalServico = vlTotalServico;
    }

    public Usuario getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Usuario usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServico != null ? idServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.idServico == null && other.idServico != null) || (this.idServico != null && !this.idServico.equals(other.idServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cwi.crescer.aula3.exercicios.entity.Servico[ idServico=" + idServico + " ]";
    }
    
}
