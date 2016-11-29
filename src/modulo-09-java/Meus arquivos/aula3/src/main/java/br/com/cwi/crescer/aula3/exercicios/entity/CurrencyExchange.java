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
@Table(name = "CURRENCY_EXCHANGE")
@NamedQueries({
    @NamedQuery(name = "CurrencyExchange.findAll", query = "SELECT c FROM CurrencyExchange c"),
    @NamedQuery(name = "CurrencyExchange.findByIdCurrencyExchange", query = "SELECT c FROM CurrencyExchange c WHERE c.idCurrencyExchange = :idCurrencyExchange"),
    @NamedQuery(name = "CurrencyExchange.findByDsCoin", query = "SELECT c FROM CurrencyExchange c WHERE c.dsCoin = :dsCoin"),
    @NamedQuery(name = "CurrencyExchange.findByVlRate", query = "SELECT c FROM CurrencyExchange c WHERE c.vlRate = :vlRate")})
public class CurrencyExchange implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CURRENCYEXCHANGE")
    @SequenceGenerator(name = "SEQ_CURRENCYEXCHANGE", sequenceName = "SEQ_CURRENCYEXCHANGE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CURRENCY_EXCHANGE")
    private BigDecimal idCurrencyExchange;
    @Basic(optional = false)
    @Column(name = "DS_COIN")
    private String dsCoin;
    @Basic(optional = false)
    @Lob
    @Column(name = "DT_CURRENCY_EXCHANGE")
    private byte[] dtCurrencyExchange;
    @Basic(optional = false)
    @Column(name = "VL_RATE")
    private BigDecimal vlRate;

    public CurrencyExchange() {
    }

    public CurrencyExchange(BigDecimal idCurrencyExchange) {
        this.idCurrencyExchange = idCurrencyExchange;
    }

    public CurrencyExchange(BigDecimal idCurrencyExchange, String dsCoin, byte[] dtCurrencyExchange, BigDecimal vlRate) {
        this.idCurrencyExchange = idCurrencyExchange;
        this.dsCoin = dsCoin;
        this.dtCurrencyExchange = dtCurrencyExchange;
        this.vlRate = vlRate;
    }

    public BigDecimal getIdCurrencyExchange() {
        return idCurrencyExchange;
    }

    public void setIdCurrencyExchange(BigDecimal idCurrencyExchange) {
        this.idCurrencyExchange = idCurrencyExchange;
    }

    public String getDsCoin() {
        return dsCoin;
    }

    public void setDsCoin(String dsCoin) {
        this.dsCoin = dsCoin;
    }

    public byte[] getDtCurrencyExchange() {
        return dtCurrencyExchange;
    }

    public void setDtCurrencyExchange(byte[] dtCurrencyExchange) {
        this.dtCurrencyExchange = dtCurrencyExchange;
    }

    public BigDecimal getVlRate() {
        return vlRate;
    }

    public void setVlRate(BigDecimal vlRate) {
        this.vlRate = vlRate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurrencyExchange != null ? idCurrencyExchange.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurrencyExchange)) {
            return false;
        }
        CurrencyExchange other = (CurrencyExchange) object;
        if ((this.idCurrencyExchange == null && other.idCurrencyExchange != null) || (this.idCurrencyExchange != null && !this.idCurrencyExchange.equals(other.idCurrencyExchange))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cwi.crescer.aula3.exercicios.entity.CurrencyExchange[ idCurrencyExchange=" + idCurrencyExchange + " ]";
    }
    
}
