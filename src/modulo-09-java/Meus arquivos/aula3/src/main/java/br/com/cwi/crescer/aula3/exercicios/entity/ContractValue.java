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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author regis.martiny
 */
@Entity
@Table(name = "CONTRACT_VALUE")
@NamedQueries({
    @NamedQuery(name = "ContractValue.findAll", query = "SELECT c FROM ContractValue c"),
    @NamedQuery(name = "ContractValue.findByIdContractValue", query = "SELECT c FROM ContractValue c WHERE c.idContractValue = :idContractValue"),
    @NamedQuery(name = "ContractValue.findByDsCoin", query = "SELECT c FROM ContractValue c WHERE c.dsCoin = :dsCoin"),
    @NamedQuery(name = "ContractValue.findByDsPeriodicity", query = "SELECT c FROM ContractValue c WHERE c.dsPeriodicity = :dsPeriodicity"),
    @NamedQuery(name = "ContractValue.findByVlAmountContractValue", query = "SELECT c FROM ContractValue c WHERE c.vlAmountContractValue = :vlAmountContractValue"),
    @NamedQuery(name = "ContractValue.findByVlMonthlyUsd", query = "SELECT c FROM ContractValue c WHERE c.vlMonthlyUsd = :vlMonthlyUsd")})
public class ContractValue implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CONTRACTVALUE")
    @SequenceGenerator(name = "SEQ_CONTRACTVALUE", sequenceName = "SEQ_CONTRACTVALUE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CONTRACT_VALUE")
    private BigDecimal idContractValue;
    @Basic(optional = false)
    @Column(name = "DS_COIN")
    private String dsCoin;
    @Basic(optional = false)
    @Column(name = "DS_PERIODICITY")
    private String dsPeriodicity;
    @Basic(optional = false)
    @Column(name = "VL_AMOUNT_CONTRACT_VALUE")
    private BigDecimal vlAmountContractValue;
    @Basic(optional = false)
    @Column(name = "VL_MONTHLY_USD")
    private BigDecimal vlMonthlyUsd;
    @JoinColumn(name = "CONTRACT_ID_CONTRACT", referencedColumnName = "ID_CONTRACT")
    @OneToOne(optional = false)
    private Contract contractIdContract;

    public ContractValue() {
    }

    public ContractValue(BigDecimal idContractValue) {
        this.idContractValue = idContractValue;
    }

    public ContractValue(BigDecimal idContractValue, String dsCoin, String dsPeriodicity, BigDecimal vlAmountContractValue, BigDecimal vlMonthlyUsd) {
        this.idContractValue = idContractValue;
        this.dsCoin = dsCoin;
        this.dsPeriodicity = dsPeriodicity;
        this.vlAmountContractValue = vlAmountContractValue;
        this.vlMonthlyUsd = vlMonthlyUsd;
    }

    public BigDecimal getIdContractValue() {
        return idContractValue;
    }

    public void setIdContractValue(BigDecimal idContractValue) {
        this.idContractValue = idContractValue;
    }

    public String getDsCoin() {
        return dsCoin;
    }

    public void setDsCoin(String dsCoin) {
        this.dsCoin = dsCoin;
    }

    public String getDsPeriodicity() {
        return dsPeriodicity;
    }

    public void setDsPeriodicity(String dsPeriodicity) {
        this.dsPeriodicity = dsPeriodicity;
    }

    public BigDecimal getVlAmountContractValue() {
        return vlAmountContractValue;
    }

    public void setVlAmountContractValue(BigDecimal vlAmountContractValue) {
        this.vlAmountContractValue = vlAmountContractValue;
    }

    public BigDecimal getVlMonthlyUsd() {
        return vlMonthlyUsd;
    }

    public void setVlMonthlyUsd(BigDecimal vlMonthlyUsd) {
        this.vlMonthlyUsd = vlMonthlyUsd;
    }

    public Contract getContractIdContract() {
        return contractIdContract;
    }

    public void setContractIdContract(Contract contractIdContract) {
        this.contractIdContract = contractIdContract;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContractValue != null ? idContractValue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContractValue)) {
            return false;
        }
        ContractValue other = (ContractValue) object;
        if ((this.idContractValue == null && other.idContractValue != null) || (this.idContractValue != null && !this.idContractValue.equals(other.idContractValue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cwi.crescer.aula3.exercicios.entity.ContractValue[ idContractValue=" + idContractValue + " ]";
    }
    
}
