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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author regis.martiny
 */
@Entity
@Table(name = "COTACAO")
@NamedQueries({
    @NamedQuery(name = "Cotacao.findAll", query = "SELECT c FROM Cotacao c"),
    @NamedQuery(name = "Cotacao.findByIdCotacao", query = "SELECT c FROM Cotacao c WHERE c.idCotacao = :idCotacao"),
    @NamedQuery(name = "Cotacao.findByDsCotacaoDollarAustraliano", query = "SELECT c FROM Cotacao c WHERE c.dsCotacaoDollarAustraliano = :dsCotacaoDollarAustraliano"),
    @NamedQuery(name = "Cotacao.findByDsCotacaoDollarCanadense", query = "SELECT c FROM Cotacao c WHERE c.dsCotacaoDollarCanadense = :dsCotacaoDollarCanadense"),
    @NamedQuery(name = "Cotacao.findByDsCotacaoEuro", query = "SELECT c FROM Cotacao c WHERE c.dsCotacaoEuro = :dsCotacaoEuro"),
    @NamedQuery(name = "Cotacao.findByDsCotacaoFrancoSuico", query = "SELECT c FROM Cotacao c WHERE c.dsCotacaoFrancoSuico = :dsCotacaoFrancoSuico"),
    @NamedQuery(name = "Cotacao.findByDsCotacaoLibra", query = "SELECT c FROM Cotacao c WHERE c.dsCotacaoLibra = :dsCotacaoLibra"),
    @NamedQuery(name = "Cotacao.findByDsCotacaoReal", query = "SELECT c FROM Cotacao c WHERE c.dsCotacaoReal = :dsCotacaoReal"),
    @NamedQuery(name = "Cotacao.findByDsCotacaoYen", query = "SELECT c FROM Cotacao c WHERE c.dsCotacaoYen = :dsCotacaoYen"),
    @NamedQuery(name = "Cotacao.findByDsCotacaoYuan", query = "SELECT c FROM Cotacao c WHERE c.dsCotacaoYuan = :dsCotacaoYuan")})
public class Cotacao implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_COTACAO")
    @SequenceGenerator(name = "SEQ_COTACAO", sequenceName = "SEQ_COTACAO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_COTACAO")
    private BigDecimal idCotacao;
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_DOLLAR_AUSTRALIANO")
    private BigDecimal dsCotacaoDollarAustraliano;
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_DOLLAR_CANADENSE")
    private BigDecimal dsCotacaoDollarCanadense;
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_EURO")
    private BigDecimal dsCotacaoEuro;
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_FRANCO_SUICO")
    private BigDecimal dsCotacaoFrancoSuico;
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_LIBRA")
    private BigDecimal dsCotacaoLibra;
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_REAL")
    private BigDecimal dsCotacaoReal;
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_YEN")
    private BigDecimal dsCotacaoYen;
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_YUAN")
    private BigDecimal dsCotacaoYuan;
    @Basic(optional = false)
    @Lob
    @Column(name = "DT_COTACAO")
    private byte[] dtCotacao;

    public Cotacao() {
    }

    public Cotacao(BigDecimal idCotacao) {
        this.idCotacao = idCotacao;
    }

    public Cotacao(BigDecimal idCotacao, BigDecimal dsCotacaoDollarAustraliano, BigDecimal dsCotacaoDollarCanadense, BigDecimal dsCotacaoEuro, BigDecimal dsCotacaoFrancoSuico, BigDecimal dsCotacaoLibra, BigDecimal dsCotacaoReal, BigDecimal dsCotacaoYen, BigDecimal dsCotacaoYuan, byte[] dtCotacao) {
        this.idCotacao = idCotacao;
        this.dsCotacaoDollarAustraliano = dsCotacaoDollarAustraliano;
        this.dsCotacaoDollarCanadense = dsCotacaoDollarCanadense;
        this.dsCotacaoEuro = dsCotacaoEuro;
        this.dsCotacaoFrancoSuico = dsCotacaoFrancoSuico;
        this.dsCotacaoLibra = dsCotacaoLibra;
        this.dsCotacaoReal = dsCotacaoReal;
        this.dsCotacaoYen = dsCotacaoYen;
        this.dsCotacaoYuan = dsCotacaoYuan;
        this.dtCotacao = dtCotacao;
    }

    public BigDecimal getIdCotacao() {
        return idCotacao;
    }

    public void setIdCotacao(BigDecimal idCotacao) {
        this.idCotacao = idCotacao;
    }

    public BigDecimal getDsCotacaoDollarAustraliano() {
        return dsCotacaoDollarAustraliano;
    }

    public void setDsCotacaoDollarAustraliano(BigDecimal dsCotacaoDollarAustraliano) {
        this.dsCotacaoDollarAustraliano = dsCotacaoDollarAustraliano;
    }

    public BigDecimal getDsCotacaoDollarCanadense() {
        return dsCotacaoDollarCanadense;
    }

    public void setDsCotacaoDollarCanadense(BigDecimal dsCotacaoDollarCanadense) {
        this.dsCotacaoDollarCanadense = dsCotacaoDollarCanadense;
    }

    public BigDecimal getDsCotacaoEuro() {
        return dsCotacaoEuro;
    }

    public void setDsCotacaoEuro(BigDecimal dsCotacaoEuro) {
        this.dsCotacaoEuro = dsCotacaoEuro;
    }

    public BigDecimal getDsCotacaoFrancoSuico() {
        return dsCotacaoFrancoSuico;
    }

    public void setDsCotacaoFrancoSuico(BigDecimal dsCotacaoFrancoSuico) {
        this.dsCotacaoFrancoSuico = dsCotacaoFrancoSuico;
    }

    public BigDecimal getDsCotacaoLibra() {
        return dsCotacaoLibra;
    }

    public void setDsCotacaoLibra(BigDecimal dsCotacaoLibra) {
        this.dsCotacaoLibra = dsCotacaoLibra;
    }

    public BigDecimal getDsCotacaoReal() {
        return dsCotacaoReal;
    }

    public void setDsCotacaoReal(BigDecimal dsCotacaoReal) {
        this.dsCotacaoReal = dsCotacaoReal;
    }

    public BigDecimal getDsCotacaoYen() {
        return dsCotacaoYen;
    }

    public void setDsCotacaoYen(BigDecimal dsCotacaoYen) {
        this.dsCotacaoYen = dsCotacaoYen;
    }

    public BigDecimal getDsCotacaoYuan() {
        return dsCotacaoYuan;
    }

    public void setDsCotacaoYuan(BigDecimal dsCotacaoYuan) {
        this.dsCotacaoYuan = dsCotacaoYuan;
    }

    public byte[] getDtCotacao() {
        return dtCotacao;
    }

    public void setDtCotacao(byte[] dtCotacao) {
        this.dtCotacao = dtCotacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCotacao != null ? idCotacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotacao)) {
            return false;
        }
        Cotacao other = (Cotacao) object;
        if ((this.idCotacao == null && other.idCotacao != null) || (this.idCotacao != null && !this.idCotacao.equals(other.idCotacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cwi.crescer.aula3.exercicios.entity.Cotacao[ idCotacao=" + idCotacao + " ]";
    }
    
}
