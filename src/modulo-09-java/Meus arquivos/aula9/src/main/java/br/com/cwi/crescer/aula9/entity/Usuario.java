package br.com.cwi.crescer.aula9.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author regis
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;

    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    
    @Basic(optional = false)
    @Column(name = "SENHA")
    private String senha;

    public Usuario(String nome, String email, String senhaCripto) {
        this.nome = nome;
        this.email = email;
        this.senha = senhaCripto;
    }

    public Usuario() {}

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) obj;
        if (idUsuario == null) {
            if (other.idUsuario != null) {
                return false;
            }
        } else if (!idUsuario.equals(other.idUsuario)) {
            return false;
        }
        return true;
    }
    
    
}
