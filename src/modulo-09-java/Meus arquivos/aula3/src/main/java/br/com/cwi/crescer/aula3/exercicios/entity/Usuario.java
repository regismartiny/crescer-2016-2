/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.exercicios.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author regis.martiny
 */
@Entity
@Table(name = "USUARIO")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByDsEmail", query = "SELECT u FROM Usuario u WHERE u.dsEmail = :dsEmail"),
    @NamedQuery(name = "Usuario.findByDsSenha", query = "SELECT u FROM Usuario u WHERE u.dsSenha = :dsSenha"),
    @NamedQuery(name = "Usuario.findByDsSituacao", query = "SELECT u FROM Usuario u WHERE u.dsSituacao = :dsSituacao"),
    @NamedQuery(name = "Usuario.findByDsUserName", query = "SELECT u FROM Usuario u WHERE u.dsUserName = :dsUserName"),
    @NamedQuery(name = "Usuario.findByNmUsuario", query = "SELECT u FROM Usuario u WHERE u.nmUsuario = :nmUsuario"),
    @NamedQuery(name = "Usuario.findByTpPermissao", query = "SELECT u FROM Usuario u WHERE u.tpPermissao = :tpPermissao")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private BigDecimal idUsuario;
    @Basic(optional = false)
    @Column(name = "DS_EMAIL")
    private String dsEmail;
    @Basic(optional = false)
    @Column(name = "DS_SENHA")
    private String dsSenha;
    @Basic(optional = false)
    @Column(name = "DS_SITUACAO")
    private String dsSituacao;
    @Basic(optional = false)
    @Column(name = "DS_USER_NAME")
    private String dsUserName;
    @Basic(optional = false)
    @Column(name = "NM_USUARIO")
    private String nmUsuario;
    @Basic(optional = false)
    @Column(name = "TP_PERMISSAO")
    private String tpPermissao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdUsuario")
    private List<Servico> servicoList;

    public Usuario() {
    }

    public Usuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(BigDecimal idUsuario, String dsEmail, String dsSenha, String dsSituacao, String dsUserName, String nmUsuario, String tpPermissao) {
        this.idUsuario = idUsuario;
        this.dsEmail = dsEmail;
        this.dsSenha = dsSenha;
        this.dsSituacao = dsSituacao;
        this.dsUserName = dsUserName;
        this.nmUsuario = nmUsuario;
        this.tpPermissao = tpPermissao;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public String getDsSituacao() {
        return dsSituacao;
    }

    public void setDsSituacao(String dsSituacao) {
        this.dsSituacao = dsSituacao;
    }

    public String getDsUserName() {
        return dsUserName;
    }

    public void setDsUserName(String dsUserName) {
        this.dsUserName = dsUserName;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getTpPermissao() {
        return tpPermissao;
    }

    public void setTpPermissao(String tpPermissao) {
        this.tpPermissao = tpPermissao;
    }

    public List<Servico> getServicoList() {
        return servicoList;
    }

    public void setServicoList(List<Servico> servicoList) {
        this.servicoList = servicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cwi.crescer.aula3.exercicios.entity.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
