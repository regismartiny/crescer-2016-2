/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.exercicios.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CONTRACT")
@NamedQueries({
    @NamedQuery(name = "Contract.findAll", query = "SELECT c FROM Contract c"),
    @NamedQuery(name = "Contract.findByIdContract", query = "SELECT c FROM Contract c WHERE c.idContract = :idContract"),
    @NamedQuery(name = "Contract.findByDsDescription", query = "SELECT c FROM Contract c WHERE c.dsDescription = :dsDescription"),
    @NamedQuery(name = "Contract.findByDsState", query = "SELECT c FROM Contract c WHERE c.dsState = :dsState"),
    @NamedQuery(name = "Contract.findByDsWebsite", query = "SELECT c FROM Contract c WHERE c.dsWebsite = :dsWebsite"),
    @NamedQuery(name = "Contract.findByNmContract", query = "SELECT c FROM Contract c WHERE c.nmContract = :nmContract")})
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CONTRACT")
    @SequenceGenerator(name = "SEQ_CONTRACT", sequenceName = "SEQ_CONTRACT", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CONTRACT")
    private BigDecimal idContract;
    @Basic(optional = false)
    @Column(name = "DS_DESCRIPTION")
    private String dsDescription;
    @Basic(optional = false)
    @Column(name = "DS_STATE")
    private String dsState;
    @Basic(optional = false)
    @Column(name = "DS_WEBSITE")
    private String dsWebsite;
    @Basic(optional = false)
    @Column(name = "NM_CONTRACT")
    private String nmContract;
    @JoinColumn(name = "CLIENT_ID_CLIENT", referencedColumnName = "ID_CLIENT")
    @ManyToOne(optional = false)
    private Client clientIdClient;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "contractIdContract")
    private ContractValue contractValue;

    public Contract() {
    }

    public Contract(BigDecimal idContract) {
        this.idContract = idContract;
    }

    public Contract(BigDecimal idContract, String dsDescription, String dsState, String dsWebsite, String nmContract) {
        this.idContract = idContract;
        this.dsDescription = dsDescription;
        this.dsState = dsState;
        this.dsWebsite = dsWebsite;
        this.nmContract = nmContract;
    }

    public BigDecimal getIdContract() {
        return idContract;
    }

    public void setIdContract(BigDecimal idContract) {
        this.idContract = idContract;
    }

    public String getDsDescription() {
        return dsDescription;
    }

    public void setDsDescription(String dsDescription) {
        this.dsDescription = dsDescription;
    }

    public String getDsState() {
        return dsState;
    }

    public void setDsState(String dsState) {
        this.dsState = dsState;
    }

    public String getDsWebsite() {
        return dsWebsite;
    }

    public void setDsWebsite(String dsWebsite) {
        this.dsWebsite = dsWebsite;
    }

    public String getNmContract() {
        return nmContract;
    }

    public void setNmContract(String nmContract) {
        this.nmContract = nmContract;
    }

    public Client getClientIdClient() {
        return clientIdClient;
    }

    public void setClientIdClient(Client clientIdClient) {
        this.clientIdClient = clientIdClient;
    }

    public ContractValue getContractValue() {
        return contractValue;
    }

    public void setContractValue(ContractValue contractValue) {
        this.contractValue = contractValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContract != null ? idContract.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contract)) {
            return false;
        }
        Contract other = (Contract) object;
        if ((this.idContract == null && other.idContract != null) || (this.idContract != null && !this.idContract.equals(other.idContract))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cwi.crescer.aula3.exercicios.entity.Contract[ idContract=" + idContract + " ]";
    }
    
}
